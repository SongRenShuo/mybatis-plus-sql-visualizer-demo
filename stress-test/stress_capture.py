# -*- coding: utf-8 -*-
"""增强捕获并发压测：本机直连，不走代理；只读为主 + 少量 update，排除 delete 类。"""
import sys, threading, time, json, urllib.request, urllib.error, random, collections

BASE = "http://127.0.0.1:8082"
# 权重：(路径, 权重, 说明)
READS = [
    ("/mpj/user/joinList", 12, "join 基础"),
    # /mpj/user/page 剔除：demo 固有缺陷（setTableName 拼 "user"_2026 非法语法），COUNT 必 500
    ("/mpj/full/joinKinds", 8, "join 全形态"),
    ("/mpj/full/aggregate", 8, "聚合"),
    ("/mpj/full/onApply", 6, "on apply"),
    ("/mpj/locator/lambdaJoin", 10, "lambda join"),
    # /mpj/locator/mapFamily 剔除：mapOne 查到 3 行必 500，demo 数据语义问题
    ("/mpj/ext/union", 6, "union"),
    ("/mpj/ext/association", 6, "association"),
    ("/mpj/device/entityList", 8, "entity join"),
    ("/mpj/user/collection", 6, "collection 填充"),
    ("/mpj/perf/n1", 14, "N+1 日志风暴(5条/请求)"),
]
WRITE = ("/mpj/user/updateJoin", 1, "update join 写捕获")  # 低比例，只造写路径
OPENER = urllib.request.build_opener(urllib.request.ProxyHandler({}))
TIMEOUT = 30

stop = threading.Event()
lock = threading.Lock()
stats = {
    "ok": 0, "err": 0, "status": collections.Counter(), "paths": collections.Counter(),
    "lat": [], "errors": collections.Counter(),
}

def pick():
    pool = [(p, w) for p, w, _ in READS]
    if WRITE_RATIO > 0:
        pool.append((WRITE[0], WRITE[1]))
    total = sum(w for _, w in pool)
    r = random.uniform(0, total)
    acc = 0
    for p, w in pool:
        acc += w
        if r <= acc:
            return p
    return pool[-1][0]

def worker(idx):
    local = []
    while not stop.is_set():
        path = pick()
        t0 = time.perf_counter()
        try:
            with OPENER.open(BASE + path, timeout=TIMEOUT) as resp:
                resp.read()
                code = resp.getcode()
        except urllib.error.HTTPError as e:
            code = e.code
            with lock:
                stats["err"] += 1
                stats["errors"]["HTTP %d" % code] += 1
            continue
        except Exception as e:
            with lock:
                stats["err"] += 1
                stats["errors"][type(e).__name__ + ": " + str(e)[:80]] += 1
            continue
        dt = (time.perf_counter() - t0) * 1000
        local.append((dt, path, code))
    if local:
        with lock:
            for dt, path, code in local:
                stats["ok"] += 1
                stats["lat"].append(dt)
                stats["status"][code] += 1
                stats["paths"][path] += 1

def pct(sorted_lat, p):
    if not sorted_lat:
        return 0
    i = min(len(sorted_lat) - 1, int(round(p / 100.0 * len(sorted_lat))) - 1)
    return sorted_lat[max(i, 0)]

def run_phase(name, threads, seconds, write_ratio):
    global WRITE_RATIO, stop
    WRITE_RATIO = write_ratio
    stop = threading.Event()
    for k in ("ok", "err"):
        stats[k] = 0
    stats["status"].clear(); stats["paths"].clear(); stats["lat"] = []
    stats["errors"].clear()
    ts = [threading.Thread(target=worker, args=(i,), daemon=True) for i in range(threads)]
    t0 = time.perf_counter()
    for t in ts: t.start()
    time.sleep(seconds)
    stop.set()
    for t in ts: t.join(timeout=TIMEOUT)
    wall = time.perf_counter() - t0
    lat = sorted(stats["lat"])
    rps = stats["ok"] / wall if wall else 0
    print("\n===== %s: %d 线程 x %ds =====" % (name, threads, seconds))
    print("成功=%d 失败=%d RPS=%.1f" % (stats["ok"], stats["err"], rps))
    if lat:
        print("延迟 ms: avg=%.0f p50=%.0f p90=%.0f p99=%.0f max=%.0f"
              % (sum(lat)/len(lat), pct(lat,50), pct(lat,90), pct(lat,99), lat[-1]))
    print("状态码: " + json.dumps(dict(stats["status"])))
    print("接口分布: " + json.dumps(dict(stats["paths"])))
    if stats["errors"]:
        top = stats["errors"].most_common(5)
        print("错误TOP: " + json.dumps(top, ensure_ascii=False))

if __name__ == "__main__":
    phases = json.loads(sys.argv[1]) if len(sys.argv) > 1 else [
        {"name": "warm", "threads": 4, "seconds": 10, "write": 0},
        {"name": "storm32", "threads": 32, "seconds": 60, "write": 0.1},
        {"name": "storm64", "threads": 64, "seconds": 45, "write": 0.05},
    ]
    WRITE_RATIO = 0
    for ph in phases:
        run_phase(ph["name"], ph["threads"], ph["seconds"], ph.get("write", 0))
    print("\nDONE")

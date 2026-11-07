# -*- coding: utf-8 -*-
"""压测后自动取证：从沙盒 idea.log 提取插件侧验收读数，替代肉眼。
用法: python verify_capture.py [sandbox_log_path] [--since "2026-11-07 13:40:00"]
输出: 刷新拍耗时分布 / 追赶徽章事件 / 插件异常 / 建议结论
"""
import sys, re, io, collections
from datetime import datetime

DEFAULT_LOG = (r"F:/code/Java/Gitee/SongRenShuo/mybatis-plus-sql-visualizer"
               r"/.worktrees/sqllist-catchup/.intellijPlatform/sandbox/"
               r"mybatis-plus-sql-visualizer/IU-2024.3.7.1/log/idea.log")

TS = re.compile(r"^(\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}),(\d{3})")
BEAT = re.compile(r"LogPanel\.refreshList (\d+)ms \(visible=(\d+)\)")
BADGE = re.compile(r"追赶中|catchUp|catch-up", re.I)

def main():
    log = DEFAULT_LOG
    since = None
    args = sys.argv[1:]
    if args and not args[0].startswith("--"):
        log = args.pop(0)
    if "--since" in args:
        since = datetime.strptime(args[args.index("--since") + 1], "%Y-%m-%d %H:%M:%S")
    beats, badges, severe, mpsv_err = [], 0, [], 0
    with io.open(log, encoding="utf-8", errors="replace") as f:
        for line in f:
            m = TS.match(line)
            if not m:
                continue
            ts = datetime.strptime(m.group(1), "%Y-%m-%d %H:%M:%S")
            if since and ts < since:
                continue
            if "LogPerfProbe" in line:
                bm = BEAT.search(line)
                if bm:
                    beats.append((ts, int(bm.group(1)), int(bm.group(2))))
                    continue
            if BADGE.search(line):
                badges += 1
                continue
            if " SEVERE " in line or " ERROR " in line:
                if "mybatisplus" in line or "mpsv" in line or "sqlvis" in line:
                    mpsv_err += 1
                    if len(severe) < 5:
                        severe.append(line.strip()[:160])
    print("==== 压测后插件侧取证（%s 起）====" % (since or "全部"))
    if beats:
        ms = sorted(b[1] for b in beats)
        n = len(ms)
        span = (beats[-1][0] - beats[0][0]).total_seconds()
        print("refreshList 慢拍记录: %d 拍 / 跨度 %.0fs" % (n, span) if span else "refreshList 慢拍记录: %d 拍" % n)
        print("  耗时 ms: min=%d p50=%d p90=%d max=%d 总EDT占用≈%.1fs (占比≈%.1f%%)"
              % (ms[0], ms[n//2], ms[int(n*0.9)], ms[-1],
                 sum(ms)/1000.0, 100.0*sum(ms)/1000.0/max(span, 1) if span else 0))
        vis = set(b[2] for b in beats)
        print("  visible 行数: %s" % sorted(vis))
    else:
        print("refreshList 慢拍记录: 0（未触发阈值 INFO——面板轻载或探针未到阈值）")
    print("追赶徽章日志事件: %d 条" % badges)
    print("插件相关 SEVERE/ERROR: %d 条" % mpsv_err)
    for s in severe:
        print("  " + s)
    print("==== 判读口径 ====")
    print("· 慢拍总EDT占用 <3% 且 max<50ms = 瘦身达标")
    print("· 徽章事件存在且成对（出现+消失）= 追赶可见化正常")
    print("· 插件 SEVERE >0 = 捕获链有缺陷，贴原文排查")

if __name__ == "__main__":
    main()

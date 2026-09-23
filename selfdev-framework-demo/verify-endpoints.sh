#!/usr/bin/env bash
# selfdev-framework-demo 端点验证：逐条打全部端点，记录 HTTP 状态与响应体前 160 字符
BASE="http://127.0.0.1:8086"
PASS=0; FAIL=0
check() {
  local label="$1" method="$2" url="$3"
  local code body
  if [ "$method" = "POST" ]; then
    code=$(curl -s -o /tmp/resp.txt -w "%{http_code}" -X POST "$url")
  else
    code=$(curl -s -o /tmp/resp.txt -w "%{http_code}" "$url")
  fi
  body=$(head -c 160 /tmp/resp.txt | tr -d '\n')
  if [ "$code" = "200" ]; then
    PASS=$((PASS+1)); printf "[200] %-46s %s\n" "$label" "$body"
  else
    FAIL=$((FAIL+1)); printf "[%s] %-46s %s\n" "$code" "$label" "$body"
  fi
}

check "index"                     GET  "$BASE/selfdev/index"
check "A1 static-call"            GET  "$BASE/selfdev/style/static-call?status=1"
check "A2 bean-call"              GET  "$BASE/selfdev/style/bean-call?status=1"
check "A3 fluent-chain"           GET  "$BASE/selfdev/style/fluent-chain?owner=lisi&limit=5"
check "A4 lambda-callback"        GET  "$BASE/selfdev/style/lambda-callback?planId=PLAN_2026001"
check "A5 anonymous-callback"     GET  "$BASE/selfdev/style/anonymous-callback?planId=PLAN_2026001"
check "A6 jdk-proxy"              GET  "$BASE/selfdev/style/jdk-proxy?status=1"
check "A7 reflection"             GET  "$BASE/selfdev/style/reflection?planId=PLAN_2026001"
check "A8 helper-wrapped"         GET  "$BASE/selfdev/style/helper-wrapped?owner=lisi"
check "A9 async-future"           GET  "$BASE/selfdev/style/async-future?status=1"
check "A10 executor-pool"         GET  "$BASE/selfdev/style/executor-pool?owner=lisi"
check "A11 batch-loop"            POST "$BASE/selfdev/style/batch-loop?planIds=PLAN_2026001,PLAN_2026002,PLAN_2026003"
check "A12 combined-nested"       GET  "$BASE/selfdev/style/combined-nested?planId=PLAN_2026001&owner=lisi"
check "B13 depth/shallow"         GET  "$BASE/selfdev/depth/shallow?status=1"
check "B14 depth/deep-three"      GET  "$BASE/selfdev/depth/deep-three?planId=PLAN_2026001"
check "B15 depth/cross-service"   GET  "$BASE/selfdev/depth/cross-service?owner=lisi&limit=5"
check "B16 same-package-delegate" GET  "$BASE/selfdev/depth/same-package-delegate?owner=lisi"
check "C17 query/paged"           GET  "$BASE/selfdev/query/paged?owner=lisi&index=1&size=2"
check "C18 query/paged-deep"      GET  "$BASE/selfdev/query/paged-deep?planId=PLAN_2026001&index=1&size=5"
check "C19 query/count"           GET  "$BASE/selfdev/query/count?status=1"
check "C20 query/aggregate"       GET  "$BASE/selfdev/query/aggregate"
check "C21 query/join"            GET  "$BASE/selfdev/query/join?planId=PLAN_2026001"
check "C22 query/in-condition"    GET  "$BASE/selfdev/query/in-condition?planIds=PLAN_2026001,PLAN_2026002"
check "C23 query/or-nested"       GET  "$BASE/selfdev/query/or-nested?owner=zhangsan&status=1"
check "C24 query/order-limit"     GET  "$BASE/selfdev/query/order-limit?orderBy=amount%20desc&limit=3"
check "D25 write/update"          POST "$BASE/selfdev/write/update?planId=PLAN_2026005&projectName=quality-trace-updated"
check "D26 write/delete"          POST "$BASE/selfdev/write/delete?planId=PLAN_NOT_EXIST"
check "D27 write/batch-update"    POST "$BASE/selfdev/write/batch-update?planIds=PLAN_2026001,PLAN_2026002&status=1"
check "E28 tool/directory-builder" GET "$BASE/selfdev/tool/directory-builder?owner=lisi"
check "E29 tool/jar-builder"      GET  "$BASE/selfdev/tool/jar-builder?owner=lisi"
check "E30 tool/jar-shared-first" GET  "$BASE/selfdev/tool/jar-shared-first?planIds=PLAN_2026001,PLAN_2026002"
check "E31 tool/jar-shared-second" GET "$BASE/selfdev/tool/jar-shared-second?planIds=PLAN_2026003,PLAN_2026004,PLAN_2026005"
check "E32 tool/dir-shared-first" GET  "$BASE/selfdev/tool/dir-shared-first?planIds=PLAN_2026001,PLAN_2026002"
check "E33 tool/dir-shared-second" GET "$BASE/selfdev/tool/dir-shared-second?planIds=PLAN_2026003,PLAN_2026004,PLAN_2026005"

echo "----------------------------------------"
echo "PASS=$PASS FAIL=$FAIL"

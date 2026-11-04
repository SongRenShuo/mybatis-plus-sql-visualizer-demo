# oracle-demo —— Oracle 增强捕获复现语料

用最小代价复现「Oracle 应用在增强捕获里只看到 `select 1 from dual`，MyBatis-Plus 业务 SQL 一条不出」。

## 它做了什么

启动即跑（无 web、无端口、跑完退出）：

| 步骤 | SQL 形态 | 缺陷态是否可见 |
|---|---|---|
| Hikari 连接校验 | plain `Statement` + `select 1 from dual` | 可见 |
| 建表（原生 JDBC） | plain `Statement` + `create table` | 可见 |
| `mapper.insert` | `PreparedStatement` 无参 executeUpdate | **不可见** |
| `mapper.selectById` | `PreparedStatement` 无参 executeQuery | **不可见** |
| `mapper.selectList` | 同上 | **不可见** |
| `mapper.updateById` | `PreparedStatement` 无参 executeUpdate | **不可见** |

判据只看 agent 事件（`REPRO` 行只是宿主控制台锚点）：缺陷态 2 条，修复态 6 条（4 条业务 SQL 带绑定参数）。

## 跑法

```bash
# 1) 构建
mvn -f oracle-demo/pom.xml package -DskipTests
#    本机若没有 mvn：/d/HuanJing/Maven/maven-mvnd-1.0.3/bin/mvnd.cmd 同上参数

# 2) 假接收端（agent 是 TCP 客户端，IDE 侧是服务端）
python <插件仓>/dev-support/agent-capture-repro/fake_receiver.py 15900

# 3) 挂 agent 启动（端口与第 2 步一致）
java -javaagent:<agent fat jar>=port=15900,logLevel=warn \
     -jar oracle-demo/target/oracle-demo-1.0.0.jar
```

agent 产物路径：`<插件仓>/sub-projects/sql-visualizer-agent/build/dist/mps-sql-agent.jar`。
注意 `build/libs/*.jar` 是普通模块 jar（不含重定位 ASM），**不能**直接 `-javaagent`。

## 想对比「改前 / 改后」

- 改后（含 T-OracleWrapperRegistry 修复）：`64371dd8` 及之后构建的 `mps-sql-agent.jar`
- 改前：在插件仓 `git worktree add <dir> 64371dd8^`，在 worktree 里跑
  `./gradlew :sql-visualizer-agent:agentFatJar`，用那个 `build/dist/mps-sql-agent.jar`

## 连的是哪个库

`application.yml` 里是测试服务器上的 Oracle Free 23（容器 `xc3-oracle-free`，
`103.36.220.245:21521/FREEPDB1`，用户 `probe`）。换库改这三行即可；表 `DEMO_USER` 由启动时自建
（先 drop 再 create，仅用于复现，别指向有数据的库）。

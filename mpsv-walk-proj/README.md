# mpsv-walk-proj

SQL Visualizer 插件的一次性真机走查工程（原在插件仓外，测试完成后并入本 demo 仓复用）。

## 为什么要单独一个工程

1. **本仓数据源是 MySQL，插件的执行目标按方言匹配选**——SQL Server 专有的链路（`SET IDENTITY_INSERT` 包装、方括号引用、`Msg 544`）在本仓的工程里跑不起来。
2. **本仓的 `DataSourceJdbcSmokeTest` 要求每个登记的数据源都 JDBC 可达**，所以不能把 SQL Server 数据源塞进本仓根 `.idea`。
3. 走查需要一张**含 identity 列**的表和一条**必然失败**的语句，这些属于一次性夹具，不适合混进示例模块。

## 里面有什么

| 文件 | 用途 |
|---|---|
| `probe/ProbeService.java` | `userMapper.delete(...)` 链——光标放进去按 `Alt+Shift+Q` 出预览，可执行、可走「更多 → 回滚 SQL → 粘贴快照 → 回填」 |
| `probe/ProbeFail.java` + `probe/Ghost.java` | 映射一张**不存在**的表——让预览执行必然失败，用来验错误定位按钮的出现/不出现 |
| `probe/ProbeMapper.java` | 注解 SQL：一条 DELETE、一条 SELECT，以及千行 VALUES 的 `<foreach>` 批量 INSERT（验插入列提示） |
| `probe/User.java` | 对应 `dbo.[user]` 的实体 |
| `batch1000.sql` | 1000 行 VALUES 的 INSERT（40 KB），用来验预览编辑的插入列 inlay |

## 怎么跑

```bash
# 1. 起 SQL Server 探针容器（127.0.0.1:14333，库 master，含 dbo.[user]）
docker start mpsv-mssql

# 2. 从插件仓库启动沙盒，指向本目录
cd <插件仓库>
./gradlew runIde -PgifRecord=true --args="<本目录绝对路径>"

# 3. 沙盒里打开 probe 下的文件，光标放进 Wrapper 链，按 Alt+Shift+Q
```

`-PgifRecord=true` 走 262 平台沙盒；不带该参数走 243。数据源需在沙盒里建一次（Database 工具窗 `+` → `Data Source from URL` → `jdbc:sqlserver://127.0.0.1:14333;database=master` → 认证改 User & Password → Schemas 页勾 `Default schema (dbo)`），建好后 IDE 会自行内省。

## 说明

`.idea/` 在本仓被 git 忽略（与其它模块一致），所以**数据源配置只存在于本地**，不进版本库；换机器要重建一次数据源。

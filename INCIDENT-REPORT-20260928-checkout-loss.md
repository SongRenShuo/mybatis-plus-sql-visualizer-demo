# 事故报告：demo 仓在途改动 checkout 丢失与恢复

- **时刻**：2026-09-28 12:27:25（checkout）/ 13:0x（恢复完成）
- **肇事动作**：沙盒走查前对 demo 仓执行 `git checkout -- .`（意图还原 mybatis-plus-demo 的走查残留），**波及同仓 jpa-hibernate-demo 的 3 个并行会话在途文件**——违反「并行会话在途改动禁 checkout」铁律（该教训在册，本会话三犯记录再+1）。

## 丢失内容

| 文件 | 丢失内容 | 来源会话 |
|---|---|---|
| controller/JpaFullCoverageController.java | 3 次 Edit（+1181/+515/+802） | sess_3de92d6e（09-28 12:12~12:15） |
| service/JpaFullCoverageService.java | 1 次 Edit（+482） | 同上 |
| service/JpaDeepCoverageService.java | 3 次 Edit（+520/+205/收尾简名化） | 同上 |

内容主题 = **WmsDockBooking 嵌入段路径语料**（criteriaEmbeddedPath / specificationEmbeddedPath，O-71 走查批次延续）+ untracked 的 WmsDockBookingRepository.java / hbm/test.xml（untracked 未受 checkout 影响，仍在）。

## 恢复过程

1. **会话 DB 挖掘**：ZCode 会话库（`db.sqlite` part 表）完整保存每次 Edit 的 old_string/new_string 载荷——搜出 `sess_3de92d6e` 09-28 12:12~12:15 的 10 次 Edit。
2. **按时间升序重放**：new_string 已在 → SKIP（防重复）；old_string 匹配 → APPLIED。9 次全部 APPLIED。
3. **收尾编辑手工应用**：12:15:32 的 MISMATCH（全限定名 → import 简名）按其语义手工对齐。
4. **误重放核查**：16:05/16:07 两次老会话编辑被重放后 git diff 无变化（内容与 HEAD 提交一致）——无害。

## 恢复后状态

- `git status`：5 个 M（Controller/Entity/JpaDeepCoverageService/JpaFullCoverageService/JpaFullCoverageServiceImpl）+ 2 个 untracked（WmsDockBookingRepository.java / hbm/test.xml）——与事故前状态对齐（事故前 `head -3` 截断了 status 输出，实际在途文件为 5 个）。
- 内容抽查：JpaDeepCoverageService diff 正是 WmsDockBooking 嵌入段语料；UserEntity +2 行合理。
- **未做编译验证**（demo 为 maven 项目，mvn 不在 PATH）——建议后续会话或用户跑一次 `mvn compile` 复核。

## 教训（升级版）

1. `git checkout -- .` 在多模块仓库（多子项目并存）是**全仓无差别还原**——跨子项目在途改动必被波及。铁律应升级为：** checkout 只允许显式路径清单，禁止 `.`**。
2. 会话 DB（part 表）是 Edit 载荷的完整审计源——「并行会话在途改动丢失」从不可恢复降级为**可按载荷重放恢复**（本次 10/10 恢复）。
3. 走查前对非走查子项目执行 `git status --short` 并留存完整输出（本会话 `head -3` 截断掩盖了事故范围）。

# 复现用例：页面 XML 数据源里的 HQL 识别与转换（T-PagesHql，2026-11-05）

## 场景

自研框架（VTradex Forest 一类）的 `<pages>` 配置里，`<maintainPage>/<datasource>` 的内容是
**HQL**（Hibernate Query Language），不是原生 SQL。旧版本插件把它当原生 SQL 直接展示：

- `FROM UserEntity` 原样出现，执行报「表不存在」；
- `u.firstName` 这类**实体属性**不映射成列 `first_name`；
- `#{SESSION_USER_ID}` / `:keyword` 不提取参数，参数面板是空的。

## 复现文件

`jpa-hibernate-demo/src/main/resources/pages/user-maintain-hql.xml`

```xml
<maintainPage id="userHqlMaintain" entityClass="cn.song.jpademo.entity.UserEntity">
    <datasource><![CDATA[
select u.id, u.username, u.email, u.firstName, u.lastName, u.age
  from UserEntity u
 where u.username like :keyword
   and u.id = #{SESSION_USER_ID}
 order by u.id desc
]]></datasource>
</maintainPage>
```

实体映射见 `src/main/java/cn/song/jpademo/entity/UserEntity.java`（`@Entity @Table(name = "user")`，
`firstName` → `first_name`）。

## 复现步骤

1. 用装了本插件的 IDE 打开 `user-maintain-hql.xml`；
2. 点 `maintainPage` 行左侧的 SQL 预览图标（或光标在标签内按预览快捷键）；
3. 观察预览面板。

## 预期结果（修复后）

| 观察点 | 预期 |
|---|---|
| 面板顶部 meta | 出现「来源: HQL（已转换）」 |
| SQL 正文 | `UserEntity` → `user`；`firstName` → `first_name`；`lastName` → `last_name` |
| 参数面板 | 两行：`keyword`、`SESSION_USER_ID`（`#{}` 框架占位符被识别为命名参数） |
| 页签 | 多出「原文」页签，内容是未转换的 HQL，只读 |
| 列信息页签 | 仍显示 XML 里 `<columns>` 的元数据（不因转换丢失） |

## 反向对照（不能误判）

`mybatis-plus-demo/src/main/resources/pages/user-maintain.xml` 的 `orderMaintain`：

```xml
<maintainPage entityClass="...entity.Order">
    <datasource><![CDATA[SELECT o.id, o.order_no FROM t_order o ...]]></datasource>
```

`entityClass` 是 `Order`，但语句根标识符是**表名** `t_order` → 判定为原生 SQL，预览必须与旧版逐字一致
（不转换、无「原文」页签、无 HQL 警示）。这条是检测器的反向护栏。

## 变体一：页面标签名不固定

自研框架的页面标签名各家不同（`maintainPage` / `listPage` / `queryPage` …），插件**不按标签名硬编码**，
判定口径是「`<pages>` 的直接子级 + 带 `<datasource>` 子元素」：

```xml
<pages>
    <listPage id="lp1" entityClass="cn.song.jpademo.entity.UserEntity">
        <datasource><![CDATA[select u from UserEntity u]]></datasource>
    </listPage>
</pages>
```

## 变体二：没有 entityClass、没有 type 的 `<dataValue>`

复现文件：`jpa-hibernate-demo/src/main/resources/pages/user-data-value.xml`

```xml
<pageConfig>
    <query id="userDataValueHql">
        <dataValue><![CDATA[
select u.id, u.username, u.firstName
  from UserEntity u
 where u.username like :keyword
]]></dataValue>
    </query>
</pageConfig>
```

没有 `entityClass` 可依据时，判据改为「根标识符能解析为持久化实体，且其表名 ≠ 根标识符」
（`UserEntity` → `user`），命中即走 HQL 转换；同一文件里的原生 SQL
（`SELECT o.id, o.order_no FROM t_order o`）根名就是表名，保持直显、不转换。

## 设置开关

设置 → 界面与操作 →「页面数据源语言（<datasource>）」：

- **自动**（默认）：按 `entityClass` 与根标识符的关系推断；
- **仅 SQL**：关闭 HQL 转换（自动判定误判时退回旧行为）；
- **仅 HQL**：自动判定漏判时强制按 HQL 转换。

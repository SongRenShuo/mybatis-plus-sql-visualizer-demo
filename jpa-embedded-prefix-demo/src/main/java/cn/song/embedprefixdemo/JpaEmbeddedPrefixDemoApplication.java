package cn.song.embedprefixdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Embedded 嵌入列前缀复现用例启动类（端口 8087）。
 *
 * 本模块专门复现「实体上不写任何 @Column/@AttributeOverride，@Embedded 字段的列名由
 * Hibernate 组件路径命名策略（component-path）决定」这一形态——用户报障时插件把
 * `inv.qty.baseQty` 预览成 `inv.base_qty`，而真库列是 `qty_base_qty`。
 *
 * 跑起来即自证：启动时 ddl-auto=update 会按该策略建表，实测建出的列就是
 * `qty_base_qty` / `move_tool_pallet_no`（见启动日志的 create table 语句）；
 * `GET /embed-prefix/columns` 可直接读到真库列名，与插件预览产物对照。
 *
 * 详见模块 README 的验收清单。
 *
 * @author SongRenShuo
 */
@SpringBootApplication
public class JpaEmbeddedPrefixDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaEmbeddedPrefixDemoApplication.class, args);
    }
}

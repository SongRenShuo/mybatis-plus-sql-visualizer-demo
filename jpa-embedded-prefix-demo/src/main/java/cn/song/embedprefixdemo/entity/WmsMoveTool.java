package cn.song.embedprefixdemo.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * 移动器具（嵌入对象）。
 *
 * **故意不写 @Column / @AttributeOverride**：component-path 下 `moveTool.palletNo`
 * 的真实列是 `move_tool_pallet_no`。
 *
 * @author SongRenShuo
 */
@Embeddable
public class WmsMoveTool implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 托盘号 */
    private String palletNo;

    public String getPalletNo() {
        return palletNo;
    }

    public void setPalletNo(String palletNo) {
        this.palletNo = palletNo;
    }
}

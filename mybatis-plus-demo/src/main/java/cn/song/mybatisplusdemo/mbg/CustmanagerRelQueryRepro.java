package cn.song.mybatisplusdemo.mbg;

import java.util.List;

/**
 * {@code CtCustmanagerRelMapper.selectByExample} 的调用点复现（MBG Example 形态）。
 *
 * <p>刻意做成普通类：不连库、不注册 Controller。插件的「Example 调用点反推」需要从
 * {@code createCriteria().andXxxYyy(...)} 与 {@code example.or()} 的实际调用形态出发，
 * 把 Criterion 还原成 SQL，因此这里只保留两种最典型的构造方式。
 *
 * @author SongRenShuo
 */
public class CustmanagerRelQueryRepro {

    private final CtCustmanagerRelMapper custmanagerRelMapper;

    public CustmanagerRelQueryRepro(CtCustmanagerRelMapper custmanagerRelMapper) {
        this.custmanagerRelMapper = custmanagerRelMapper;
    }

    /**
     * 单条件：{@code WHERE ( cust_id = ? )}。
     */
    public List<CtCustmanagerRel> querySingle() {
        CtCustmanagerRelExample example = new CtCustmanagerRelExample();
        example.createCriteria().andCustIdEqualTo(42L);
        return custmanagerRelMapper.selectByExample(example);
    }

    /**
     * 双条件 OR：两条 Criteria 由 {@code separator="or"} 连接，
     * 预期形态为 {@code WHERE ( cust_id = ? ) or ( staff_login like ? )}。
     */
    public List<CtCustmanagerRel> queryOr() {
        CtCustmanagerRelExample example = new CtCustmanagerRelExample();
        example.createCriteria().andCustIdEqualTo(42L);
        example.or().andStaffLoginLike("song%");
        return custmanagerRelMapper.selectByExample(example);
    }
}

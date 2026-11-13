package cn.song.mybatisplusdemo.repro;

import cn.song.mybatisplusdemo.entity.Order;
import cn.song.mybatisplusdemo.mapper.OrderMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * T-PreviewStmtTypeScope 复现语料：同一个 {@code LambdaQueryWrapper} 变量在方法里被复用——
 * 先交给 {@code update(entity, w)}，重新赋值后再交给 {@code delete(w)}。
 *
 * <p>对应用户工程 2026-11-12 报障形态：{@code CuPartyOrgMemberComponent} 里 216-217 行
 * {@code cuPartyOrgMemberComponent.update(entity, w)}，232 行重新赋值后 235 行
 * {@code delete(w)}。旧判型口径「该变量任意一处被写调用消费即改判」叠上「update 档位恒先命中」，
 * 于是光标停在查询/条件语句上预览也报 {@code UPDATE}——用户看到的是「查询被识别成 update」。
 *
 * <p>修复后预期（按锚点位置）：
 * <ul>
 *   <li>光标在 {@code update(patch, w)} 那条语句（或它的 {@code .eq} 条件语句）→ {@code UPDATE}，
 *       meta 行「类型依据: update() 消费（第 N 行）」，工具栏「语句: UPDATE」可切到 DELETE；</li>
 *   <li>光标在 {@code delete(w)} 那条语句 → {@code DELETE}；</li>
 *   <li>光标在 Component 的 {@code qryOneByWrapper} 形参上 → {@code SELECT} 且无 WHERE
 *       （跨方法取不到调用方条件，能力边界，如实不造条件）；</li>
 *   <li>工具栏切换入口只在「同一 wrapper 上出现 ≥2 档消费」时出现，单档场景面板不变。</li>
 * </ul>
 *
 * <p>刻意做成普通类：不连库、不注册 Controller（与 {@code CustmanagerRelQueryRepro} 同惯例），
 * 只保留判型需要的调用形态。两个入口方法名 {@code update} / {@code delete} 与用户工程一致——
 * 消费语义识别按方法名匹配，名字换了就复现不出来。
 *
 * @author SongRenShuo
 */
public class WrapperReuseRepro {

    private final OrderMapper orderMapper;

    private final OrderComponent orderComponent;

    public WrapperReuseRepro(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
        this.orderComponent = new OrderComponent(orderMapper);
    }

    /**
     * 与用户工程 Component 层同构：同名方法 {@code qryOneByWrapper} / {@code update} / {@code delete}，
     * 内部直通 {@link OrderMapper}。
     */
    public static class OrderComponent {

        private final OrderMapper orderMapper;

        public OrderComponent(OrderMapper orderMapper) {
            this.orderMapper = orderMapper;
        }

        /**
         * 查询入口（形参 wrapper 直通 mapper）：形参锚点下预览取不到调用方条件，产出无 WHERE 的 SELECT。
         */
        public Order qryOneByWrapper(LambdaQueryWrapper<Order> wrapper) {
            return orderMapper.selectOne(wrapper);
        }

        /**
         * 更新入口（{@code update(entity, wrapper)} 双参、wrapper 非首参）：实体更新消费 → UPDATE 档位。
         */
        public boolean update(Order entity, LambdaQueryWrapper<Order> wrapper) {
            return orderMapper.update(entity, wrapper) > 0;
        }

        /**
         * 删除入口（{@code delete(wrapper)} 单参）：删除消费 → DELETE 档位。
         */
        public int delete(LambdaQueryWrapper<Order> wrapper) {
            return orderMapper.delete(wrapper);
        }
    }

    /**
     * 查询路径（用户工程 119 行形态）：消费方法名 {@code qryOneByWrapper} 不在消费集合内，
     * 预览保持默认 SELECT（含 WHERE 条件）。
     */
    public Order queryByWrapper(Integer userId) {
        LambdaQueryWrapper<Order> orderLambdaQueryWrapper = new LambdaQueryWrapper<>();
        orderLambdaQueryWrapper.eq(Order::getUserId, userId)
            .eq(Order::getStatus, 0);
        return orderComponent.qryOneByWrapper(orderLambdaQueryWrapper);
    }

    /**
     * 复用路径（用户工程 216-217 行 / 232-235 行形态）：同一个变量先 update、重新赋值后再 delete。
     *
     * <p>锚点验收点：update 语句与 delete 语句各应得到自己的语句类型，且工具栏可来回切换；
     * 变量声明行落在两条消费之间偏上游，默认判到锚点之后最近的一条（update）。
     */
    public int updateThenDeleteByReusedWrapper(Order patch, Integer userId, String orderNo) {
        LambdaQueryWrapper<Order> orderLambdaQueryWrapper = new LambdaQueryWrapper<>();
        orderLambdaQueryWrapper.eq(Order::getUserId, userId)
            .eq(Order::getStatus, 0);
        orderComponent.update(patch, orderLambdaQueryWrapper);

        orderLambdaQueryWrapper = new LambdaQueryWrapper<>();
        orderLambdaQueryWrapper.eq(Order::getOrderNo, orderNo)
            .eq(Order::getUserId, userId);
        return orderComponent.delete(orderLambdaQueryWrapper);
    }
}

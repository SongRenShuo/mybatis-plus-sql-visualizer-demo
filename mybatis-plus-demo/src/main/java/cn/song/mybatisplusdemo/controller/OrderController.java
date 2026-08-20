package cn.song.mybatisplusdemo.controller;

import cn.song.mybatisplusdemo.entity.Order;
import cn.song.mybatisplusdemo.mapper.OrderMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单管理：演示多表相关查询（t_order 表）
 *
 * @author SongRenShuo
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * LambdaQueryWrapper：金额区间 + 状态 + 排序
     */
    @GetMapping("/list")
    public List<Order> list(BigDecimal minAmount, BigDecimal maxAmount, Integer status) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.between(minAmount != null && maxAmount != null,
                Order::getAmount, minAmount, maxAmount);
        queryWrapper.eq(status != null, Order::getStatus, status);
        queryWrapper.orderByDesc(Order::getCreateTime);
        return orderMapper.selectList(queryWrapper);
    }

    /**
     * QueryWrapper 字符串列名：金额统计
     */
    @GetMapping("/sum")
    public List<java.util.Map<String, Object>> sumByUser() {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_id", "sum(amount) as total", "count(*) as cnt");
        queryWrapper.groupBy("user_id");
        queryWrapper.having("sum(amount) > 100");
        queryWrapper.orderByDesc("total");
        return orderMapper.selectMaps(queryWrapper);
    }

    /**
     * UpdateWrapper 条件更新：已支付订单金额打折
     */
    @GetMapping("/discount")
    public int discount(BigDecimal rate, Integer status) {
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
        updateWrapper.setSql("amount = amount * " + rate);
        updateWrapper.eq("status", status);
        return orderMapper.update(null, updateWrapper);
    }
}

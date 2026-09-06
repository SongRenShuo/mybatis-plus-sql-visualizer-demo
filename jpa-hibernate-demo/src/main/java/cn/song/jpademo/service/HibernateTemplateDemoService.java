package cn.song.jpademo.service;

import cn.song.jpademo.entity.WmsDockBooking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * HibernateTemplate 老式 DAO 调用形态演示 Service。
 *
 * 每个方法对应一种「自定义 DAO HQL 调用」形态，供插件 SQL Visualizer 验证：
 * 字面量直传 / 变量直字面量 / 拼接初始化式 / 链式 `+` / name-value 交替 /
 * 名字数组+值数组 / Map / UPDATE / DELETE / IN 集合 / 位置参数 / 纯 FROM / 原生 SQL。
 *
 * @author SongRenShuo
 */
public interface HibernateTemplateDemoService {

    /**
     * 形态 1（用户反馈同款）：拼接初始化式 + 名字数组+值数组 双数组传参。
     * 统计各状态预约数（LEFT JOIN WmsAsn），插件应显示 gutter 图标且预览展开完整 HQL。
     */
    Object[] getHeadData(String warehouseId, LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 形态 2：字面量直传 + name-value 交替（HQL 单行）。
     */
    List<WmsDockBooking> listByStatus(String status);

    /**
     * 形态 3：变量直字面量（String hql = "..."; 非拼接）。
     */
    List<WmsDockBooking> listByWarehouse(String warehouseId);

    /**
     * 形态 4：链式 `+` 单表达式（PsiPolyadicExpression 多操作数）。
     */
    List<WmsDockBooking> listByStatusAndType(String status, String type);

    /**
     * 形态 5：Map 单参数传参（hql + Map）。
     */
    List<WmsDockBooking> listActiveByWarehouse(String warehouseId, Integer status);

    /**
     * 形态 6：UPDATE HQL（execute 方法，name-value 交替）。
     */
    int updateStatusById(Long id, String newStatus);

    /**
     * 形态 7：DELETE HQL（execute 方法，name-value 交替）。
     */
    int deleteAsnById(Long id);

    /**
     * 形态 8：IN 集合（:idList + name-value 传 List）。
     */
    List<WmsDockBooking> findByIdList(List<Long> idList);

    /**
     * 形态 9：位置参数（?1 形态，直接传值）。
     */
    List<WmsDockBooking> findByStatusPositional(String status);

    /**
     * 形态 10：纯 FROM 无 SELECT（from Entity where ...）。
     */
    List<WmsDockBooking> findByWarehouseFromOnly(String warehouseId);

    /**
     * 形态 11：原生 SQL（createSQLQuery 形态，DAO 实现内）。
     */
    List<?> nativeDockCount(String warehouseId);

    /**
     * 形态 12：findByValueBean（实体属性作为参数条件）。
     */
    List<?> findByValueBeanDemo(WmsDockBooking sample);

    /**
     * 形态 13：HibernateTemplate 直接 API 基础 CRUD（save/load/update/delete/merge）。
     */
    WmsDockBooking crudDemo(Long id, WmsDockBooking booking);
}
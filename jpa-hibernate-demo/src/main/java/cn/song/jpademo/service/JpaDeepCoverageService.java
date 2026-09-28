package cn.song.jpademo.service;

import cn.song.jpademo.dto.UserLiteDTO;
import cn.song.jpademo.entity.UserEntity;
import cn.song.jpademo.entity.WmsDockBooking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * JPA 深水区覆盖服务层
 * Criteria 补形态（EXISTS 子查询 / coalesce·concat 表达式函数 / fetch join）、
 * Specification 组合器（where/and/or/not）、@Procedure 存储过程调用
 *
 * @author SongRenShuo
 */
public interface JpaDeepCoverageService {

    /**
     * Criteria EXISTS 子查询：有高额订单的客户
     */
    List<UserEntity> criteriaExistsSubquery(java.math.BigDecimal minAmount);

    /**
     * Criteria 表达式函数：coalesce / concat / length 投影
     */
    List<Map<String, Object>> criteriaExpressionFunctions();

    /**
     * Criteria fetch join：一次性取关联部门
     */
    List<UserEntity> criteriaFetchJoin(Integer status);

    /**
     * Specification 组合器：where / and / or / not
     */
    List<UserEntity> specificationCombinators(String keyword, Integer status, Integer minAge);

    /**
     * @Procedure 存储过程：count_users_by_status
     */
    Integer procedureCountByStatus(Integer status);

    /**
     * @NamedQueries 容器命名查询（OrderEntity 容器注解形态）
     */
    List<?> namedQueryContainer(String orderNo);

    /**
     * DTO 投影复用（UserLiteDTO 构造器表达式配套深水区查询）
     */
    List<UserLiteDTO> liteProjection(Integer status);

    /**
     * Criteria 嵌入段路径：root.get("updateInfo").get("createdTime") 穿透 @Embedded 对象
     */
    List<WmsDockBooking> criteriaEmbeddedPath(String warehouseId);

    /**
     * Specification 嵌入段路径：root.get("updateInfo").get("createdTime") 组合条件
     */
    List<WmsDockBooking> specificationEmbeddedPath(String warehouseId, LocalDateTime minTime);
}

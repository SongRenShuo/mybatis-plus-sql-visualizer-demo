package cn.song.mpjdemo.service;

import cn.song.mpjdemo.dto.UserDTO;
import cn.song.mpjdemo.entity.UserDO;

import java.util.List;
import java.util.Map;

/**
 * MPJ 场景全覆盖服务（补齐 MpjExtService 未覆盖的 API 形态）
 *
 * @author SongRenShuo
 */
public interface MpjFullCoverageService {

    /**
     * join 类型与重载：innerJoin/rightJoin/fullJoin、4 参别名、5 参 rightAlias
     */
    List<UserDTO> joinKindsAndOverloads();

    /**
     * 子查询条件族：(col, Class, wrapper) 形态
     */
    List<UserDTO> subqueryConditions();

    /**
     * IfExists 族：eqIfExists/gtIfExists/likeIfExists/betweenIfExists/inIfNotEmpty/notInIfNotEmpty
     */
    List<UserDTO> ifExistsFamily(Integer age, String tel, List<Integer> ids);

    /**
     * 聚合列扩展：selectAsClass/selectCount/selectFunc 字符串模板 {0}/selectFilter
     */
    List<Map<String, Object>> aggregateExt();

    /**
     * updateJoin：setUpdateEntity/set 副表列/setIncrBy/setDecrBy/setApply
     */
    int updateJoinExt();

    /**
     * deleteJoin：多表删除/delete 指定表/deleteAll
     */
    int deleteJoinExt();

    /**
     * on 条件 lambda 内 apply 子查询
     */
    List<UserDTO> onLambdaApply();

    /**
     * MPJQueryWrapper 字符串形态补充：聚合列 + 子查询 IN
     */
    List<UserDTO> queryStringExt();
}

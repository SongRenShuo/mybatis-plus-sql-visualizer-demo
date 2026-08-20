package cn.song.mpjdemo.service;

import cn.song.mpjdemo.dto.UserDTO;
import cn.song.mpjdemo.entity.UserDO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * MPJ 扩展写法服务层（MPJQueryWrapper 字符串 / selectAssociation / union / selectSub / distinct / 链式）
 *
 * @author SongRenShuo
 */
public interface MpjExtService {

    /**
     * MPJQueryWrapper 字符串写法：selectAll + select(字符串列) + leftJoin/rightJoin(字符串 SQL)
     */
    List<UserDTO> queryWrapperString();

    /**
     * selectAssociation 一对一映射（user → 默认地址）
     */
    List<UserDTO> selectAssociation();

    /**
     * selectCollection 带 prefix + 子表过滤（额外条件集合映射）
     */
    List<UserDTO> selectCollectionWithFilter();

    /**
     * union / unionAll 合并查询
     */
    List<UserDTO> unionQuery();

    /**
     * selectSub 子查询列（SELECT (子查询) AS alias）
     */
    List<UserDTO> selectSubQuery();

    /**
     * distinct 去重 + selectFunc 聚合
     */
    List<Map<String, Object>> distinctAndFunc();

    /**
     * 自定义 join（join(keyWord, condition, joinSql, args)）+ last / apply
     */
    List<UserDTO> customJoinAndApply();

    /**
     * 逻辑删除开关：disableLogicDel / disableSubLogicDel / logicDelToOn
     */
    List<UserDTO> logicDelSwitch();

    /**
     * 链式 count / one / list / page（Chain 接口）
     */
    Map<String, Object> chainCountOneList(Integer id);

    /**
     * 更多条件：allEq / and-or 嵌套 / exists / notExists / between / in
     */
    List<UserDTO> moreConditions(Map<com.baomidou.mybatisplus.core.toolkit.support.SFunction<UserDO, ?>, Object> allEq,
                                 Integer minAge, Integer maxAge, List<Integer> ids);
}

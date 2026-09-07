package cn.song.mpjdemo.service.impl;

import cn.song.mpjdemo.dto.UserDTO;
import cn.song.mpjdemo.entity.AddressDO;
import cn.song.mpjdemo.entity.AreaDO;
import cn.song.mpjdemo.entity.UserDO;
import cn.song.mpjdemo.mapper.UserMapper;
import cn.song.mpjdemo.service.MpjFullCoverageService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.github.yulichang.wrapper.UpdateJoinWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MPJ 场景全覆盖服务实现类
 * 补齐 join 类型与重载、子查询条件族、IfExists 族、聚合列扩展、updateJoin/deleteJoin 变体等
 *
 * @author SongRenShuo
 */
@Service
public class MpjFullCoverageServiceImpl implements MpjFullCoverageService {

    @Resource
    private UserMapper userMapper;

    /**
     * join 类型与重载：innerJoin/rightJoin/fullJoin、4 参别名（addr）、5 参 rightAlias
     */
    @Override
    public List<UserDTO> joinKindsAndOverloads() {
        // innerJoin + rightJoin
        List<UserDTO> innerRight = userMapper.selectJoinList(UserDTO.class,
                JoinWrappers.lambda(UserDO.class)
                        .selectAll(UserDO.class)
                        .select(AddressDO::getTel)
                        .innerJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                        .rightJoin(AreaDO.class, on -> on
                                .eq(AreaDO::getId, AddressDO::getAreaId))
                        .eq(UserDO::getSex, 1));
        // fullJoin（副表别名 addr）+ rightJoin 5 参 rightAlias（alias, left, rightAlias, right）
        List<UserDTO> fullRight = userMapper.selectJoinList(UserDTO.class,
                JoinWrappers.lambda(UserDO.class)
                        .selectAll(UserDO.class)
                        .select("addr.tel")
                        .fullJoin(AddressDO.class, "addr", on -> on
                                .eq(AddressDO::getUserId, UserDO::getId))
                        .rightJoin(AreaDO.class, "a", AreaDO::getId, "addr", AddressDO::getAreaId)
                        .eq(UserDO::getId, 1));
        if (fullRight.isEmpty()) {
            return innerRight;
        }
        return fullRight;
    }

    /**
     * 子查询条件族：(col, Class, wrapper) 形态 → t.id IN (SELECT ...)/NOT IN/EXISTS/IS NULL
     */
    @Override
    public List<UserDTO> subqueryConditions() {
        return userMapper.selectJoinList(UserDTO.class,
                JoinWrappers.lambda(UserDO.class)
                        .selectAll(UserDO.class)
                        // in 子查询：id IN (SELECT user_id FROM user_address WHERE status = 1)
                        .in(UserDO::getId, AddressDO.class, sub -> sub
                                .select(AddressDO::getUserId)
                                .eq(AddressDO::getStatus, 1))
                        // notIn 子查询
                        .notIn(UserDO::getId, AreaDO.class, sub -> sub
                                .select(AreaDO::getId)
                                .eq(AreaDO::getCity, "杭州"))
                        // exists 子查询
                        .exists(AreaDO.class, sub -> sub
                                .select(AreaDO::getId)
                                .eq(AreaDO::getProvince, "浙江省"))
                        // isNull / isNotNull 子查询形态
                        .isNotNull(UserDO::getHeadImg)
                        .orderByDesc(UserDO::getId));
    }

    /**
     * IfExists 族：值为 null/空时自动跳过条件；setIfExists 用于条件更新
     */
    @Override
    public List<UserDTO> ifExistsFamily(Integer age, String tel, List<Integer> ids) {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eqIfExists(UserDO::getAge, age)
                .likeIfExists(AddressDO::getTel, tel)
                .gtIfExists(UserDO::getSex, 0)
                .betweenIfExists(UserDO::getAge, 10, 80)
                .notBetweenIfExists(UserDO::getAge, 100, 200)
                .inIfNotEmpty(UserDO::getId, ids)
                .notInIfNotEmpty(UserDO::getSex, (java.util.Collection<Integer>) null)
                .orderByAsc(UserDO::getId);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * 聚合列扩展：selectAsClass/selectCount/聚合族（Sum/Max/Min/Avg/Len，各 3 重载，1.5.8 已有）/
     * selectFunc 字符串模板 {0}/selectFilter
     */
    @Override
    public List<Map<String, Object>> aggregateExt() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                // selectAsClass(Class, Class)：实体列按目标 DTO 映射输出
                .selectAsClass(UserDO.class, UserDTO.class)
                .selectCount(UserDO::getId, "total")
                // 聚合族三重载：(列, 别名字符串)、(列, 别名SFunction)、(列)
                .selectSum(UserDO::getAge, "sum_age")
                .selectMax(UserDO::getAge, UserDTO::getAge)
                .selectMin(UserDO::getAge, "min_age")
                .selectAvg(UserDO::getAge, "avg_age")
                // selectLen → LENGTH(col) AS 别名
                .selectLen(UserDO::getName, "name_len")
                // 字符串模板函数：IFNULL({0}, {1})，{0}/{1} 依次取 accept 的列
                .selectFunc("IFNULL({0}, {1})", c -> c.accept(UserDO::getAge, UserDO::getSex), "age_or_sex")
                // selectFilter(Class, Predicate<SelectCache>)：按列元数据过滤输出列
                .selectFilter(AddressDO.class, col -> "tel".equals(col.getColumn()))
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .groupBy(UserDO::getSex)
                .orderByDesc(UserDO::getSex);
        return userMapper.selectJoinMaps(wrapper);
    }

    /**
     * updateJoin：set 副表列/setIncrBy/setDecrBy/setApply/setUpdateEntity/setIfExists
     */
    @Override
    public int updateJoinExt() {
        UpdateJoinWrapper<UserDO> wrapper = JoinWrappers.update(UserDO.class)
                // setUpdateEntity：实体非空字段并入 SET 子句
                .setUpdateEntity(new UserDO().setAge(20))
                .set(AddressDO::getTel, "13800000000")
                .set(UserDO::getHeadImg, UserDO::getName, "addr")
                .setIncrBy(UserDO::getAge, 1)
                .setDecrBy(true, UserDO::getSex, 1)
                // setApply 签名：(boolean, 模板, FuncConsumer 列, 常量参数...)
                .setApply(true, "t.name = concat({0}, '_u')", c -> c.accept(UserDO::getName))
                .innerJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(AddressDO::getStatus, 1);
        // updateJoin 需携带实体（set 值也可由实体承载），UpdateJoinWrapper 作为 MPJBaseJoin 传入
        return userMapper.updateJoin(new UserDO(), wrapper);
    }

    /**
     * deleteJoin：删除主表关联数据/delete 指定表/deleteAll 全量
     */
    @Override
    public int deleteJoinExt() {
        // 删除主表 t 中关联副表的记录
        int mainDeleted = userMapper.deleteJoin(JoinWrappers.delete(UserDO.class)
                .innerJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(AddressDO::getStatus, 0));
        // 删除副表 addr 的关联记录（多表删除）
        int subDeleted = userMapper.deleteJoin(JoinWrappers.delete(UserDO.class)
                .delete("addr")
                .innerJoin(AddressDO.class, "addr", AddressDO::getUserId, UserDO::getId)
                .isNull(UserDO::getHeadImg));
        return mainDeleted + subDeleted;
    }

    /**
     * on 条件 lambda 内 apply 子查询 + ext 扩展条件（MFunction 形态）
     */
    @Override
    public List<UserDTO> onLambdaApply() {
        return userMapper.selectJoinList(UserDTO.class,
                JoinWrappers.lambda(UserDO.class)
                        .selectAll(UserDO.class)
                        .select(AddressDO::getTel)
                        .leftJoin(AddressDO.class, on -> on
                                .eq(AddressDO::getUserId, UserDO::getId)
                                .apply("addr.status = (select max(status) from user_address)"))
                        // ext 形态：3 参列对列 join（首列为副表列）+ MFunction 追加 ON 条件
                        .leftJoin(AreaDO.class, AreaDO::getId, AddressDO::getAreaId,
                                ext -> ext.eq(AreaDO::getProvince, "浙江省"))
                        .eq(UserDO::getSex, 0)
                        .orderByDesc(UserDO::getAge));
    }

    /**
     * MPJQueryWrapper 字符串形态补充：聚合列 + IN 子查询 + 分页
     */
    @Override
    public List<UserDTO> queryStringExt() {
        Page<UserDTO> page = new Page<>(1, 10);
        Page<UserDTO> result = userMapper.selectJoinPage(page, UserDTO.class,
                JoinWrappers.query(UserDO.class)
                        .selectAll(UserDO.class)
                        // selectIgnore：从 selectAll 结果剔除列（字符串链专属方法，1.5.8 已有）
                        .selectIgnore("head_img")
                        .select("(select count(*) from user_address ua where ua.user_id = t.id) AS tel")
                        .leftJoin("user_address addr on t.id = addr.user_id")
                        .in("t.id", "select user_id from user_address where status = 1")
                        .groupBy("t.id", "t.name")
                        .having("count(*) > {0}", 0)
                        .orderByDesc("t.id"));
        return result.getRecords();
    }
}

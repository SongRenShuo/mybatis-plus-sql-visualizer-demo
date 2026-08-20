package cn.song.mpjdemo.service.impl;

import cn.song.mpjdemo.dto.UserDTO;
import cn.song.mpjdemo.entity.AddressDO;
import cn.song.mpjdemo.entity.AreaDO;
import cn.song.mpjdemo.entity.UserDO;
import cn.song.mpjdemo.mapper.UserMapper;
import cn.song.mpjdemo.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.github.yulichang.wrapper.enums.DefaultFuncEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户联查服务实现类
 * 集中编写 MPJ 各种联表调用链，供 mybatis-plus-sql-visualizer 插件预览 SQL
 *
 * @author SongRenShuo
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 三表联查：selectAll + select + selectAs + leftJoin + rightJoin + innerJoin
     * SELECT t.id, t.name, t.age, t1.tel, t1.address, t2.province, t2.city AS city
     * FROM user t LEFT JOIN user_address t1 ON t1.user_id = t.id
     * INNER JOIN area t2 ON t2.id = t1.area_id
     * WHERE t.id = 1 AND t1.tel LIKE '1%'
     */
    @Override
    public List<UserDTO> selectJoinList() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel)
                .selectAs(AddressDO::getAddress, UserDTO::getAddress)
                .select(AreaDO::getProvince, AreaDO::getCity)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .rightJoin(AreaDO.class, AreaDO::getId, AddressDO::getAreaId)
                .eq(UserDO::getId, 1)
                .like(AddressDO::getTel, "1");
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * join 多条件 on + ext 扩展条件
     * 左连接带额外 ON 条件（ext -> ext.eq(...)）
     */
    @Override
    public List<UserDTO> selectJoinWithOnCondition() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel, AddressDO::getAddress)
                .leftJoin(AddressDO.class, on -> on
                        .eq(AddressDO::getUserId, UserDO::getId)
                        .eq(AddressDO::getStatus, 1))
                .leftJoin(AreaDO.class, AreaDO::getId, AddressDO::getAreaId, ext -> ext
                        .eq(AreaDO::getCity, "杭州"))
                .eq(UserDO::getSex, 1);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * selectCollection 一对多映射：user → 地址集合
     */
    @Override
    public List<UserDTO> selectJoinCollection() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .selectCollection("user_address", AddressDO.class, UserDTO::getAddressList)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getId, 1);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * 子查询 join（MConsumer 形态：leftJoin(Class, t -> t.setAlias(...).selectAll().ge(...), 左列, 右列)）
     */
    @Override
    public List<UserDTO> selectJoinSubQuery() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel)
                .leftJoin(AddressDO.class, t -> t
                                .setAlias("addr")
                                .selectAll()
                                .ge(AddressDO::getStatus, 0),
                        AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getId, 1);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * from 子查询主表（from(from -> from.selectAll().ge(...).last("LIMIT 10"))）
     */
    @Override
    public List<UserDTO> selectJoinFrom() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll()
                .from(from -> from
                        .selectAll()
                        .ge(UserDO::getId, 0)
                        .last("LIMIT 10"))
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .ge(UserDO::getId, 0);
        return userMapper.selectJoinList(UserDTO.class, wrapper);
    }

    /**
     * around + setTableName + pageByMain 综合分页
     * - setTableName：动态表名（演示写法，实际按业务传入表名后缀）
     * - pageByMain：按主表分页
     */
    @Override
    public IPage<UserDTO> selectJoinPage(Page<UserDTO> page) {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .selectAll(UserDO.class)
                .select(AddressDO::getTel)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .setTableName(name -> name + "_2026")
                .pageByMain()
                .eq(UserDO::getId, 1)
                .around("/* hint */ ", " /* end */");
        return userMapper.selectJoinPage(page, UserDTO.class, wrapper);
    }

    /**
     * selectFunc 聚合 + groupBy + having
     */
    @Override
    public List<Map<String, Object>> selectJoinFunc() {
        MPJLambdaWrapper<UserDO> wrapper = JoinWrappers.lambda(UserDO.class)
                .select(UserDO::getSex)
                .selectFunc(DefaultFuncEnum.COUNT, UserDO::getId, "cnt")
                .selectFunc(DefaultFuncEnum.SUM, UserDO::getAge, "ageSum")
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .groupBy(UserDO::getSex)
                .having("count(*) > 1")
                .orderByAsc(UserDO::getSex);
        return userMapper.selectJoinMaps(wrapper);
    }

    /**
     * updateJoin 联表更新（MPJUpdateWrapper）
     * UPDATE user t LEFT JOIN user_address t1 ON t1.user_id = t.id
     * SET t1.status = 1 WHERE t.id = 1
     */
    @Override
    public int updateJoin() {
        return userMapper.updateJoin(null, JoinWrappers.update(UserDO.class)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .set(AddressDO::getStatus, 1)
                .eq(UserDO::getId, 1));
    }

    /**
     * deleteJoin 联表删除（MPJDeleteWrapper）
     * DELETE t1, t FROM user t LEFT JOIN user_address t1 ON t1.user_id = t.id WHERE t.id = 1
     */
    @Override
    public int deleteJoin() {
        return userMapper.deleteJoin(JoinWrappers.delete(UserDO.class)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .deleteAll()
                .eq(UserDO::getId, 1));
    }

    /**
     * fill 填充用例（MPJ 1.5.1+，插件 fill 测试对齐 1.5.x）
     * fill 系列：fill(field, tagField)、fill(field, oneClass, tagField)、
     * fill(field, oneField, tagField)、fill(field, oneClass, tagField, consumer)
     * 语义：以 field 取到的值为 IN 条件，查询 oneClass/oneField 所在表，回填到 tagField
     */
    @Override
    public List<UserDTO> selectFill() {
        // 方式一（2 参）：fill(源字段, 回填字段) —— 按回填字段类型推断关联表主键匹配
        List<UserDTO> list = userMapper.selectJoinList(UserDTO.class,
                JoinWrappers.lambda(UserDO.class)
                        .selectAll(UserDO.class)
                        .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                        .fill(UserDO::getId, UserDO::getAddressList));
        // 方式二（3 参 oneClass）：fill(源字段, 关联实体类, 回填字段)
        userMapper.selectJoinList(UserDTO.class,
                JoinWrappers.lambda(UserDO.class)
                        .selectAll(UserDO.class)
                        .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                        .fill(UserDO::getId, AddressDO.class, UserDO::getAddressList));
        // 方式三（3 参 oneField）：fill(源字段, 关联表外键字段, 回填字段)
        userMapper.selectJoinList(UserDTO.class,
                JoinWrappers.lambda(UserDO.class)
                        .selectAll(UserDO.class)
                        .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                        .fill(UserDO::getId, AddressDO::getUserId, UserDO::getAddressList));
        // 方式四（4 参 + consumer）：fill(源字段, 关联实体类, 回填字段, w -> w.eq(...))
        userMapper.selectJoinList(UserDTO.class,
                JoinWrappers.lambda(UserDO.class)
                        .selectAll(UserDO.class)
                        .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                        .fill(UserDO::getId, AddressDO.class, UserDO::getAddressList,
                                w -> w.eq(AddressDO::getStatus, 1)));
        return list;
    }
}

package cn.song.mybatisplusdemo.service;

import cn.song.mybatisplusdemo.entity.SysConfig;
import cn.song.mybatisplusdemo.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Wrapper 工厂/链式/工具类形态全覆盖服务
 * 覆盖 Wrappers 工厂族、ChainWrappers 链式终结点、Db kit 静态 CRUD、SimpleQuery、ActiveRecord
 *
 * @author SongRenShuo
 */
public interface WrapperFactoryCoverageService {

    /**
     * Wrappers 工厂族：lambdaQuery/lambdaUpdate/query/update/emptyWrapper
     */
    Map<String, Object> listByWrappersFactory(String username);

    /**
     * ChainWrappers 链式：queryChain/updateChain 终结点（list/one/count/exists/page）
     */
    Map<String, Object> listByChainWrappers(String username);

    /**
     * Db kit 静态 CRUD：list/getById/save/removeById/update/count
     */
    Map<String, Object> crudByDbKit(String username);

    /**
     * SimpleQuery：keyMap / map / list 三形态
     */
    Map<String, Object> queryBySimpleQuery(String keyword);

    /**
     * ActiveRecord 形态：insert/updateById/deleteById（Model 基类）
     */
    Map<String, Object> crudByActiveRecord(SysConfig config);

    /**
     * BaseMapper CRUD 补形态：selectMapsPage/selectCount/exists/update(wrapper)/remove(wrapper)/removeByMap
     */
    Map<String, Object> crudMapperMoreForms(String keyword);

    /**
     * 裸工厂链 + 带参 exists 子查询（T-ExistsChainTerminal 复现用例，2026-10-07）
     *
     * 四种写法产出同一份 SQL，用于对照插件的静态预览：裸工厂链 / var 声明 / 变量声明（对照）/
     * 裸工厂链 notExists（对照）。详见实现类 KDoc 的验收清单。
     */
    Map<String, Object> listByBareFactoryChainExists(String username);
}

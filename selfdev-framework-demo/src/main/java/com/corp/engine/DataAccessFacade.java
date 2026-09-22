package com.corp.engine;

import com.corp.meta.FilterExpression;

import java.util.List;
import java.util.Map;

/**
 * 自研框架数据访问门面接口（供 JDK 动态代理形态使用）。
 *
 * <p>真实项目中业务常面向接口编程、由框架在启动期织入实现或代理；此处以
 * {@link JdkProxyFactory} 生成代理，验证「代理帧被跳过、真实业务帧仍能定位」。
 *
 * @author SongRenShuo
 */
public interface DataAccessFacade {

    List<Map<String, Object>> findByFilter(String schemaCode, FilterExpression filter);

    Map<String, Object> findOneByFilter(String schemaCode, FilterExpression filter);

    long countByFilter(String schemaCode, FilterExpression filter);
}

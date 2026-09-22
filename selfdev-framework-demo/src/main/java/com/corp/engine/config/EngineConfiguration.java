package com.corp.engine.config;

import com.corp.engine.DataAccessFacade;
import com.corp.engine.DataAccessFacadeImpl;
import com.corp.engine.DataQueryTool;
import com.corp.engine.DataUpdateTool;
import com.corp.engine.DmlRepository;
import com.corp.engine.EngineHolder;
import com.corp.engine.JdkProxyFactory;
import com.corp.engine.LocalDbService;
import com.corp.engine.MetaDataService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * 自研框架装配配置：模拟真实框架自带的 auto-configuration。
 *
 * <p>框架包根（{@code com.corp.*}）不在业务应用的组件扫描范围内，故由应用显式
 * {@code @Import(EngineConfiguration.class)} 引入——这与真实项目里框架通过
 * {@code spring.factories} / starter 自动装配是同一件事。
 *
 * <p>{@link DataAccessFacade} 对外暴露的是 {@link JdkProxyFactory} 生成的动态代理，
 * 供「接口 + 代理」调用形态使用。
 *
 * @author SongRenShuo
 */
@Configuration
public class EngineConfiguration {

    @Bean
    public MetaDataService metaDataService() {
        return new MetaDataService();
    }

    @Bean
    public DmlRepository dmlRepository(NamedParameterJdbcTemplate template) {
        return new DmlRepository(template);
    }

    @Bean
    public LocalDbService localDbService(MetaDataService metaDataService, DmlRepository dmlRepository) {
        return new LocalDbService(metaDataService, dmlRepository);
    }

    /** 面向业务的 Bean 门面。 */
    @Bean
    public DataQueryTool dataQueryTool(LocalDbService localDbService) {
        return new DataQueryTool(localDbService);
    }

    /** 门面接口（动态代理形态）。 */
    @Bean
    public DataAccessFacade dataAccessFacade(LocalDbService localDbService) {
        return JdkProxyFactory.proxy(new DataAccessFacadeImpl(localDbService));
    }

    /** 装配完成后把引擎交给静态门面。 */
    @Bean
    public EngineHolder engineHolder(LocalDbService localDbService, MetaDataService metaDataService,
                                     DataAccessFacade dataAccessFacade) {
        EngineHolder holder = new EngineHolder(localDbService, metaDataService, dataAccessFacade);
        DataUpdateTool.init(holder);
        return holder;
    }
}

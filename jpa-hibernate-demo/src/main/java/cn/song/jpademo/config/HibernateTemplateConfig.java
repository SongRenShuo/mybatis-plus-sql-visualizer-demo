package cn.song.jpademo.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * HibernateTemplate 手动配置（Spring Boot 2.6.3 不自动创建 HibernateTemplate bean）。\n *\n * 老式 DAO（HibernateDaoSupport / HibernateTemplate）与 JPA 同源：\n * 由容器 EntityManagerFactory 解包出 Hibernate SessionFactory 供模板使用。\n *\n * @author SongRenShuo\n */
@Configuration
public class HibernateTemplateConfig {

    /**
     * HibernateTemplate 模板 bean（老式 DAO 注入用）。
     *
     * 直接从 JPA EntityManagerFactory 解包出 SessionFactory，
     * 不再单独声明同名 sessionFactory @Bean，避免与 Spring Boot
     * HibernateJpaConfiguration 自动装配的 SessionFactory 冲突导致循环依赖。
     */
    @Bean
    public HibernateTemplate hibernateTemplate(EntityManagerFactory entityManagerFactory) {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        HibernateTemplate template = new HibernateTemplate(sessionFactory);
        template.setCheckWriteOperations(false);
        return template;
    }

    /**
     * 老式 DAO 写路径事务管理器（非 primary）。
     *
     * 关键点：必须绑定「原生 SessionFactory」作资源 key——
     * application.yml 把 current_session_context_class 配成 SpringSessionContext，
     * 它在 currentSession() 里用 Hibernate 内部持有的原生 SessionFactoryImpl 查
     * TransactionSynchronizationManager；容器注入的 EntityManagerFactory 是 Spring
     * 代理（unwrap 返回代理自身），若用代理做 key 则 key 不相等，
     * 模板拿不到事务会话，UPDATE/DELETE 仍抛 TransactionRequiredException。
     * 使用处：@Transactional(transactionManager = "hibernateTransactionManager")。
     */
    @Bean
    public HibernateTransactionManager hibernateTransactionManager(EntityManagerFactory entityManagerFactory,
                                                                   DataSource dataSource) {
        // 资源 key 必须是 Hibernate 内部原生 SessionFactoryImpl：
        // 先经 EntityManagerFactoryInfo 拿原生 EMF（绕开 Spring 代理），再 unwrap 出原生 SF；
        // SpringSessionContext.currentSession() 查 TransactionSynchronizationManager
        // 用的 key 正是这个原生实例，key 不一致则模板拿不到事务会话。
        EntityManagerFactory nativeEmf =
                ((EntityManagerFactoryInfo) entityManagerFactory).getNativeEntityManagerFactory();
        SessionFactory nativeSessionFactory = nativeEmf.unwrap(SessionFactory.class);
        HibernateTransactionManager txm = new HibernateTransactionManager(nativeSessionFactory);
        txm.setDataSource(dataSource);
        return txm;
    }

    /**
     * JPA 事务管理器（显式接管，保持 Boot 默认行为）。
     *
     * 注册了任意 PlatformTransactionManager 后，Boot 的
     * HibernateJpaConfiguration#transactionManager
     * （@ConditionalOnMissingBean(PlatformTransactionManager)）会退让，
     * 这里以同名 transactionManager bean 补齐并标 @Primary，
     * JPA/Repository 侧行为不变；未限定 transactionManager 的 @Transactional
     * 全部落到本管理器。
     */
    @Bean
    @Primary
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory,
                                                    DataSource dataSource) {
        JpaTransactionManager txm = new JpaTransactionManager(entityManagerFactory);
        txm.setDataSource(dataSource);
        return txm;
    }
}
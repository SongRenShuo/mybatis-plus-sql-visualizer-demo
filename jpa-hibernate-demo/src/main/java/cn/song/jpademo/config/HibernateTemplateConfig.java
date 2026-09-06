package cn.song.jpademo.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.persistence.EntityManagerFactory;

/**
 * HibernateTemplate 手动配置（Spring Boot 2.6.3 不自动创建 HibernateTemplate bean）。\n *\n * 老式 DAO（HibernateDaoSupport / HibernateTemplate）与 JPA 同源：\n * 由容器 EntityManagerFactory 解包出 Hibernate SessionFactory 供模板使用。\n *\n * @author SongRenShuo\n */
@Configuration
public class HibernateTemplateConfig {

    /**
     * 从 JPA EntityManagerFactory 解包 Hibernate SessionFactory。
     */
    @Bean
    public SessionFactory sessionFactory(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    /**
     * HibernateTemplate 模板 bean（老式 DAO 注入用）。
     */
    @Bean
    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
        HibernateTemplate template = new HibernateTemplate(sessionFactory);
        template.setCheckWriteOperations(false);
        return template;
    }
}
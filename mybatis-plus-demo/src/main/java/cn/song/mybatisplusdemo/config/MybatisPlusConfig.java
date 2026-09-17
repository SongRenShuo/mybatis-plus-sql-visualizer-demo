package cn.song.mybatisplusdemo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * MyBatis-Plus 配置类
 * 注册分页插件与乐观锁插件
 *
 * @author SongRenShuo
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * MyBatis-Plus 拦截器链
     * - PaginationInnerInterceptor：分页插件
     * - OptimisticLockerInnerInterceptor：乐观锁插件（配合 @Version）
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor pagination = new PaginationInnerInterceptor(DbType.MYSQL);
        pagination.setMaxLimit(500L);
        pagination.setOverflow(false);
        interceptor.addInnerInterceptor(pagination);
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    /**
     * 自定义 SQL 注入器：在默认方法集外追加 insertBatchSomeColumn
     * 供 Mapper 直接批量插入（对应 MP 自定义 SQL 注入器扩展点）
     */
    @Bean
    public DefaultSqlInjector defaultSqlInjector() {
        return new DefaultSqlInjector() {
            @Override
            public List<AbstractMethod> getMethodList(org.apache.ibatis.session.Configuration configuration,
                                                      Class<?> mapperClass,
                                                      TableInfo tableInfo) {
                List<AbstractMethod> methodList = super.getMethodList(configuration, mapperClass, tableInfo);
                methodList.add(new InsertBatchSomeColumn());
                return methodList;
            }
        };
    }
}

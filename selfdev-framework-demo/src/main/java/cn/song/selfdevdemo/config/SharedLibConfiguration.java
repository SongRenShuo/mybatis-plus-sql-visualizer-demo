package cn.song.selfdevdemo.config;

import cn.song.selfdevdemo.kernel.PlanTreeKernel;
import cn.song.selfdevdemo.util.PlanTreeQueryBuilder;

import com.corp.platform.SqlKernel;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * E 组用例的装配：把数据源/内核交给两个「构建器」的静态入口。
 *
 * <p>目录态 {@link PlanTreeQueryBuilder} 与 JAR 态 {@code com.corp.shared.util.PlanTreeQueryBuilder}
 * 都是静态工具类（对齐真实项目里业务构建器的常见写法），故需要装配期注入；
 * JAR 侧内核 {@link SqlKernel} 直接吃 {@link DataSource}，等价于真实平台工具类自建连接。
 *
 * @author SongRenShuo
 */
@Configuration
public class SharedLibConfiguration {

    private final DataSource dataSource;

    private final PlanTreeKernel planTreeKernel;

    public SharedLibConfiguration(DataSource dataSource, PlanTreeKernel planTreeKernel) {
        this.dataSource = dataSource;
        this.planTreeKernel = planTreeKernel;
    }

    @PostConstruct
    public void initToolEntries() {
        PlanTreeQueryBuilder.init(planTreeKernel);
        SqlKernel.init(dataSource);
    }
}

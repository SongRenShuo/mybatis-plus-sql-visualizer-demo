package cn.song.jarmodeldemo.config;

import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 配置形态 B：**Java 代码式**组件路径命名策略（可切换备选，默认不生效）。
 *
 * <p>为什么要备这一份：插件在「实体来自 JAR」时判命名约定的第 ③ 条工程级信号是
 * 「Java 源码里出现 {@code ImplicitNamingStrategyComponentPathImpl} /
 * {@code DefaultComponentSafeNamingStrategy} 类名」。本类让该信号真实存在于工程源码里，
 * 走查那条信号时把 profile 打开即可（设置键 {@code implicit_naming_strategy} 就不会出现在
 * 任何配置文件里，只剩代码信号）。
 *
 * <p><b>切换方式</b>（两条路同一模块内只能生效一条）：
 * <ol>
 *   <li>把 {@code application.yml} 里的 {@code implicit_naming_strategy: component-path}
 *       一行注释掉（形态 A 退场）；</li>
 *   <li>启动时加 {@code --spring.profiles.active=code-naming}（形态 B 上场）。</li>
 * </ol>
 * 默认（不带该 profile）本类不装配，生效的是 application.yml 那条。
 *
 * <p>注意：若两条同时设置，{@code HibernatePropertiesCustomizer} 在 yml 属性之后应用、
 * 会覆盖同名键——值等价所以行为不变，但「哪条生效」就不可判读了，故切换时务必按上面两步走。
 *
 * @author SongRenShuo
 */
@Configuration
@Profile("code-naming")
public class CodeBasedNamingStrategyConfig {

    /**
     * 代码式把隐式命名策略设成组件路径实现类。
     *
     * <p>这里放的是 {@code Class} 对象（而非 {@code "component-path"} 短名字符串）——
     * 命名策略实现类 {@link ImplicitNamingStrategyComponentPathImpl} 由 Hibernate 直接实例化，
     * 与 yml 里写短名的效果完全一致。
     */
    @Bean
    public HibernatePropertiesCustomizer componentPathImplicitNamingStrategyCustomizer() {
        return props -> props.put(
                "hibernate.implicit_naming_strategy",
                ImplicitNamingStrategyComponentPathImpl.class);
    }
}

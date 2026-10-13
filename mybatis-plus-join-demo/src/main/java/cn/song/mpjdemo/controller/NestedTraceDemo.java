package cn.song.mpjdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 嵌套 Controller 真机走查夹具。
 * <p>
 * 用来验「HTTP 请求路径下追踪树能否匹配嵌套类的类名」：入口点的类名来自插件的扫描模型
 * （PSI 点号名 cn.song.mpjdemo.controller.NestedTraceDemo.Inner），而 agent 回帧的类名来自
 * ByteBuddy @Advice.Origin("#t")，是 JVM 二进制名（...NestedTraceDemo$Inner）——两边必须归一化
 * 才对得上，否则请求发了、帧也回来了，追踪树却是空的。
 * <p>
 * Spring 支持静态嵌套的 @RestController 被组件扫描发现，访问 /nested-trace/ping 即可。
 */
public class NestedTraceDemo {

    @RestController
    @RequestMapping("/nested-trace")
    public static class Inner {

        @GetMapping("/ping")
        public String ping() {
            return "pong-from-nested-controller";
        }
    }
}

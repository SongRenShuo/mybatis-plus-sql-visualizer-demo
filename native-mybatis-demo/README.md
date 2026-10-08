# native-mybatis-demo

原生 MyBatis（非 Spring Boot）语料工程，供插件 **3.25「原生 MyBatis 拦截器自动注入」** 验收。

## 形态要点（与插件判据对齐）

- 无 `@SpringBootApplication`，启动走 `SqlSessionFactoryBuilder` 直读 `mybatis-config.xml`；
- classpath 含 `org.apache.ibatis.session.SqlSessionFactory`（插件 `ProjectTypeDetector` 判 `MYBATIS_NATIVE`）；
- 依赖带 `mybatis-plus-extension`：注入生成物 `SqlSourceInterceptor implements InnerInterceptor` 需要它编译；
- `src/main/resources/mybatis-config.xml` 恰一份（**多处 config 是注入的 fail-closed 边界**，勿再添第二份）。

## 用法

```
mvnd -q -pl native-mybatis-demo -am compile -o -DskipTests     # 离线编译
java -cp target/classes;<deps> cn.song.nativedemo.NativeMyBatisMain   # 或直接在 IDEA 里 Run 本类
```

## 3.25 验收步骤

1. IDEA（或 runIde 沙盒）打开本工程，设置 → SQL 日志 → 勾选「自动注入源码捕获拦截器」；
2. 预期：`cn/song/nativedemo/config/` 生成 `SqlSourceInterceptor.java` 与 `SqlVisualizerNativePlugin.java`，
   `mybatis-config.xml` 出现 `<plugins><plugin interceptor="cn.song.nativedemo.config.SqlVisualizerNativePlugin"/></plugins>`
   （原本无 `<plugins>` 时按 DTD 顺序自动创建），并弹「已生成 X 和 Y…」通知；
3. 运行 `NativeMyBatisMain`，新生成的 SQL 日志应带源码位置（精确跳转）。

## fail-closed 边界（改语料时勿破坏）

- 删掉 `mybatis-config.xml` → 不注入（无 config）；
- 复制一份 `mybatis.xml` → 不注入（多处 config 歧义）；
- 根标签不是 `<configuration>` → 不注入。

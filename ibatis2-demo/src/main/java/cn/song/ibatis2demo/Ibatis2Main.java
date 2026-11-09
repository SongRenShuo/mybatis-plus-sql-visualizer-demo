package cn.song.ibatis2demo;

import cn.song.ibatis2demo.model.User;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.impl.SqlMapExecutorDelegate;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMap;
import com.ibatis.sqlmap.engine.mapping.parameter.ParameterMapping;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.ibatis.sqlmap.engine.scope.SessionScope;
import com.ibatis.sqlmap.engine.scope.StatementScope;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * iBatis 2.x 离线自检：不连数据库，只做「配置解析 + 语句渲染」。
 *
 * <p>价值锚点：{@link SqlMapClientBuilder#buildSqlMapClient(Reader)} 会做 DTD 校验与全量配置解析；
 * 它能跑通，就机器证明了 sqlmap-config.xml / sqlmap/User.xml 的语法合法。随后对每条语句调用
 * {@code MappedStatement#getSql} 拿到真实渲染结果与参数映射序列，覆盖 #x# / #x:JDBC# /
 * #x:JDBC:nullValue# / #x,jdbcType=?# / $x$ / ## / $$ / 动态标签 / iterate / selectKey /
 * parameterMap 手写 ? 等形态。</p>
 *
 * <p>退出码：全部渲染成功为 0；任一语句失败为 1（便于脚本当门禁用）。</p>
 */
public final class Ibatis2Main {

    private static SqlMapClient client;
    private static SqlMapExecutorDelegate delegate;

    private static int rendered;
    private static final List<String> failures = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        Reader reader = Resources.getResourceAsReader("sqlmap-config.xml");
        try {
            client = SqlMapClientBuilder.buildSqlMapClient(reader);
        } finally {
            reader.close();
        }
        delegate = ((SqlMapClientImpl) client).getDelegate();

        System.out.println("== iBatis 2.3.4.726 buildSqlMapClient 成功：DTD 校验 + 配置解析通过 ==");
        printRegisteredStatements();

        User full = new User();
        full.setId(7);
        full.setUsername("alice");
        full.setEmail("alice@example.com");
        full.setAge(30);
        full.setStatus(1);
        full.setDeptId(100);
        full.setIds(Arrays.asList("X1", "X2", "X3"));
        full.setOrderColumn("USER_NAME DESC");

        User partial = new User();
        partial.setId(7);
        partial.setUsername("");
        partial.setStatus(1);

        User forInsert = new User();
        forInsert.setUsername("newbie");

        User byName = new User();
        byName.setUsername("bob");

        // ---- 静态语句 / 无参 ----
        render("User.selectAll", null, "静态无占位符，null 参数");
        render("User.selectEscapes", null, "## 与 $$ 转义字面量，null 参数");
        render("User.selectByInclude", full, "sql 片段 include 配置期内联，片段内无占位符");

        // ---- 占位符各语法档 ----
        render("User.selectById", full, "#id# 简单占位符");
        render("User.selectTwoSegment", full, "#username:VARCHAR# 两段式");
        render("User.selectThreeSegment", full, "#age:INTEGER:0# 三段式（值非空）");
        User nullAge = new User();
        nullAge.setUsername("carol");
        render("User.selectThreeSegment", nullAge, "#age:INTEGER:0# 三段式（age 为 null，观察 nullValue 生效）");
        render("User.selectVarcharNullValue", nullAge, "#email:VARCHAR:0# 三段式 VARCHAR（email 为 null）");
        render("User.selectAdvancedSyntax", full, "#id,jdbcType=INTEGER# 高级语法");
        render("User.selectOrderBy", full, "$orderColumn$ 字符串直替");

        // ---- 动态标签 ----
        render("User.selectByCondition", full, "dynamic 四条件全命中（父 prepend 吃掉第一个 AND）");
        render("User.selectByCondition", partial, "同一语句半填充：只命中 id 与 status");
        render("User.selectPrependNoSpace", full, "prepend 不补空格坑：真实输出 ANDUSER_NAME 粘连");
        render("User.selectByIterate", full, "iterate + #ids[]#");
        render("User.selectNullParamBranch", null, "null 参数：<isNull> 为真 -> USER_NAME IS NULL");
        render("User.selectNullParamBranch", byName, "非 null 参数：<isNotNull> 为真 -> USER_NAME = ?");

        // ---- 写语句 / parameterMap / procedure ----
        render("User.insertUser", forInsert, "insert + selectKey type=pre，email/age 走 nullValue");
        render("User.viaParameterMapRawHash", full, "声明 parameterMap：手写 ? 生效，#username# 原样保留");
        render("User.callUserProcedure", full, "procedure 语法形态");

        // ---- N+1 目标语句 ----
        render("User.selectByDeptId", full, "deptWithUsers 嵌套 result 的 select 目标");

        System.out.println();
        System.out.println("== 渲染成功 " + rendered + " 条，失败 " + failures.size() + " 条 ==");
        if (!failures.isEmpty()) {
            for (String failure : failures) {
                System.out.println("   FAIL " + failure);
            }
            System.exit(1);
        }
    }

    private static void printRegisteredStatements() {
        TreeSet<String> ids = new TreeSet<String>();
        Iterator iterator = delegate.getMappedStatementNames();
        while (iterator.hasNext()) {
            ids.add(String.valueOf(iterator.next()));
        }
        System.out.println("-- 已注册语句（" + ids.size() + "）--");
        for (String id : ids) {
            System.out.println("   " + id);
        }
        System.out.println();
    }

    private static void render(String id, Object parameterObject, String note) {
        System.out.println("--- " + id + "   [" + note + "]");
        System.out.println("    param = " + parameterObject);
        try {
            MappedStatement statement = delegate.getMappedStatement(id);
            if (statement == null) {
                throw new IllegalStateException("语句未注册: " + id);
            }

            SessionScope sessionScope = new SessionScope();
            sessionScope.setSqlMapClient(client);
            StatementScope statementScope = new StatementScope(sessionScope);
            statement.initRequest(statementScope);

            Sql sql = statement.getSql();
            String sqlText = sql.getSql(statementScope, parameterObject);
            ParameterMap parameterMap = sql.getParameterMap(statementScope, parameterObject);
            ParameterMapping[] mappings = parameterMap.getParameterMappings();
            Object[] values = parameterMap.getParameterObjectValues(statementScope, parameterObject);

            System.out.println("    SQL    = " + oneLine(sqlText));
            System.out.println("    params = " + describeMappings(mappings));
            System.out.println("    values = " + describeValues(values));

            sql.cleanup(statementScope);
            rendered++;
            System.out.println("    [OK]");
        } catch (Throwable t) {
            failures.add(id + " -> " + t);
            System.out.println("    [FAIL] " + t);
            t.printStackTrace(System.out);
        }
        System.out.println();
    }

    private static String describeMappings(ParameterMapping[] mappings) {
        if (mappings == null || mappings.length == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < mappings.length; i++) {
            if (i > 0) {
                builder.append(", ");
            }
            ParameterMapping mapping = mappings[i];
            builder.append(mapping.getPropertyName());
            if (mapping.getJdbcTypeName() != null) {
                builder.append(':').append(mapping.getJdbcTypeName());
            }
            if (mapping.getNullValue() != null) {
                builder.append("(nullValue=").append(mapping.getNullValue()).append(')');
            }
        }
        return builder.append(']').toString();
    }

    private static String describeValues(Object[] values) {
        if (values == null || values.length == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                builder.append(", ");
            }
            Object value = values[i];
            if (value == null) {
                builder.append("null");
            } else {
                builder.append(value).append('<').append(value.getClass().getSimpleName()).append('>');
            }
        }
        return builder.append(']').toString();
    }

    private static String oneLine(String text) {
        return text == null ? "null" : text.replaceAll("\\s+", " ").trim();
    }

    private Ibatis2Main() {
    }
}

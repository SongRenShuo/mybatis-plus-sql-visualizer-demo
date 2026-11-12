#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
在 demo 仓中生成 cust-big-demo 微服务多模块大工程（SQL Visualizer 性能复现语料）。

用法（任意目录均可，脚本自己定位 demo 仓根）：
    python tools/gen_big_module.py

生成形态：

    cust-big-demo/                 Maven 聚合 pom（不改 demo 根 pom 的 <modules>）
      cust-common/                 共享 DTO / util / 统一响应体
      cust-center/                 MyBatis-Plus 服务（@TableName / BaseMapper / Wrapper / Page）
      cust-metadata/               原生 MyBatis 服务（40 套 MBG 三件套 + 调用点压力，主战场）
      cust-gateway/                网关服务（过滤器 / 路由 / 代理）

特性：
  - 幂等：每次执行先整体删除 cust-big-demo/，再按固定规则重建，结果逐字节一致；
  - 只用 Python 3 标准库，不联网、不装依赖、不执行 mvn / gradle；
  - 生成的目录结构与 package 声明严格一致，IDEA 可直接当普通源码目录索引。
"""

import os
import re
import shutil
import sys
from pathlib import Path

# ---------------------------------------------------------------------------
# 路径
# ---------------------------------------------------------------------------

DEMO_ROOT = Path(__file__).resolve().parent.parent
PROJECT_NAME = "cust-big-demo"
PROJECT_DIR = DEMO_ROOT / PROJECT_NAME
LEGACY_DIR = DEMO_ROOT / "cust-metadata-big"

MODULES = {
    "cust-common": "cn.song.custcommon",
    "cust-center": "cn.song.custcenter",
    "cust-metadata": "cn.song.custmetadata",
    "cust-gateway": "cn.song.custgateway",
}

# 主战场（原生 MyBatis）沿用原来的路径常量
MODULE_NAME = "cust-metadata"
MODULE_DIR = PROJECT_DIR / MODULE_NAME
SRC_DIR = MODULE_DIR / "src"
JAVA_ROOT = SRC_DIR / "main" / "java"
RES_ROOT = SRC_DIR / "main" / "resources"
BASE_PKG = MODULES[MODULE_NAME]
PKG_ROOT = JAVA_ROOT.joinpath(*BASE_PKG.split("."))

# ---------------------------------------------------------------------------
# 表定义（40 张，全部属于客户主数据域）
# ---------------------------------------------------------------------------

TABLE_DEFS = [
    ("cust_info", "客户信息"),
    ("cust_contact", "客户联系方式"),
    ("cust_address", "客户地址"),
    ("cust_cert", "客户证件"),
    ("cust_tag", "客户标签"),
    ("cust_tag_rel", "客户标签关系"),
    ("cust_group", "客户群组"),
    ("cust_group_rel", "客户群组关系"),
    ("cust_bank_acct", "客户银行账户"),
    ("cust_holder", "客户持有人"),
    ("cust_holder_rel", "客户持有人关系"),
    ("cust_asset", "客户资产"),
    ("cust_asset_detail", "客户资产明细"),
    ("cust_risk_eval", "客户风险评估"),
    ("cust_risk_item", "客户风险项"),
    ("cust_credit_score", "客户信用评分"),
    ("cust_industry", "客户行业"),
    ("cust_industry_rel", "客户行业关系"),
    ("cust_scale", "客户规模"),
    ("cust_source", "客户来源"),
    ("cust_channel", "客户渠道"),
    ("cust_manager", "客户经理"),
    ("cust_manager_rel", "客户经理关系"),
    ("cust_visit_log", "客户拜访记录"),
    ("cust_follow_up", "客户跟进"),
    ("cust_complaint", "客户投诉"),
    ("cust_contract", "客户合同"),
    ("cust_contract_item", "客户合同明细"),
    ("cust_order", "客户订单"),
    ("cust_order_item", "客户订单明细"),
    ("cust_payment", "客户付款"),
    ("cust_refund", "客户退款"),
    ("cust_invoice", "客户发票"),
    ("cust_settlement", "客户结算"),
    ("cust_audit_log", "客户审计日志"),
    ("cust_change_log", "客户变更日志"),
    ("cust_attach", "客户附件"),
    ("cust_note", "客户备注"),
    ("cust_preference", "客户偏好"),
    ("cust_score_log", "客户评分日志"),
]

# 热点表：前 5 张，它们的 selectByExample 各造 200+ 调用点
HOT_TABLE_COUNT = 5

# ---------------------------------------------------------------------------
# 列定义
# ---------------------------------------------------------------------------

COMMON_COLUMNS = [
    ("id", "BIGINT", "Long", "id", "主键ID"),
    ("cust_no", "VARCHAR", "String", "custNo", "客户编号"),
    ("cust_name", "VARCHAR", "String", "custName", "客户名称"),
    ("cust_type", "VARCHAR", "String", "custType", "客户类型"),
    ("cert_type", "VARCHAR", "String", "certType", "证件类型"),
    ("cert_no", "VARCHAR", "String", "certNo", "证件号码"),
    ("mobile_no", "VARCHAR", "String", "mobileNo", "手机号"),
    ("email_addr", "VARCHAR", "String", "emailAddr", "电子邮箱"),
    ("status", "VARCHAR", "String", "status", "状态"),
    ("version_no", "INTEGER", "Integer", "versionNo", "版本号"),
    ("tenant_id", "BIGINT", "Long", "tenantId", "租户ID"),
    ("create_by", "VARCHAR", "String", "createBy", "创建人"),
    ("create_time", "TIMESTAMP", "Date", "createTime", "创建时间"),
    ("update_by", "VARCHAR", "String", "updateBy", "更新人"),
    ("update_time", "TIMESTAMP", "Date", "updateTime", "更新时间"),
    ("remark", "VARCHAR", "String", "remark", "备注"),
    ("del_flag", "CHAR", "String", "delFlag", "删除标记"),
]

EXTRA_COLUMNS = [
    ("biz_code", "VARCHAR", "String", "bizCode", "业务编码"),
    ("region_code", "VARCHAR", "String", "regionCode", "区域编码"),
    ("source_sys", "VARCHAR", "String", "sourceSys", "来源系统"),
    ("sort_no", "INTEGER", "Integer", "sortNo", "排序号"),
    ("data_level", "INTEGER", "Integer", "dataLevel", "数据等级"),
    ("ext_attr", "VARCHAR", "String", "extAttr", "扩展属性"),
]


class Column(object):
    __slots__ = ("column", "jdbc", "java", "prop", "comment")

    def __init__(self, column, jdbc, java, prop, comment):
        self.column = column
        self.jdbc = jdbc
        self.java = java
        self.prop = prop
        self.comment = comment


def columns_for(index):
    """每张表 = 17 个公共列 + 2 个按序号轮换的扩展列，共 19 列。"""
    extras = [
        EXTRA_COLUMNS[index % len(EXTRA_COLUMNS)],
        EXTRA_COLUMNS[(index + 3) % len(EXTRA_COLUMNS)],
    ]
    merged = COMMON_COLUMNS[:4] + extras + COMMON_COLUMNS[4:]
    return [Column(*row) for row in merged]


def cap(text):
    return text[0].upper() + text[1:] if text else text


def camel(table):
    return "".join(part.capitalize() for part in table.split("_"))


def lower_camel(name):
    return name[0].lower() + name[1:]


def snake(upper_camel):
    return re.sub(r"(?<!^)(?=[A-Z])", "_", upper_camel).upper()


# ---------------------------------------------------------------------------
# 基础工具
# ---------------------------------------------------------------------------

def write_file(path, content):
    path.parent.mkdir(parents=True, exist_ok=True)
    with open(str(path), "w", encoding="utf-8", newline="\n") as fh:
        fh.write(content)


def module_roots(name):
    mod = PROJECT_DIR / name
    java = mod / "src" / "main" / "java"
    res = mod / "src" / "main" / "resources"
    pkg = java.joinpath(*MODULES[name].split("."))
    return mod, java, res, pkg


def reset_project():
    if PROJECT_DIR.exists():
        shutil.rmtree(str(PROJECT_DIR))
    if LEGACY_DIR.exists():
        shutil.rmtree(str(LEGACY_DIR))


def simple_pojo(pkg, cls, desc, fields, imports=(), extends=None, annotations=()):
    """生成一个普通 POJO（Serializable + 字段 + getter/setter + toString）。"""
    out = []
    out.append("package %s;\n\n" % pkg)
    out.append("import java.io.Serializable;\n")
    for imp in imports:
        out.append("import %s;\n" % imp)
    out.append("\n")
    out.append("/**\n")
    out.append(" * %s。\n" % desc)
    out.append(" */\n")
    for anno in annotations:
        out.append("%s\n" % anno)
    if extends:
        out.append("public class %s extends %s implements Serializable {\n\n" % (cls, extends))
    else:
        out.append("public class %s implements Serializable {\n\n" % cls)
    out.append("    private static final long serialVersionUID = 1L;\n\n")
    for prop, java_type, cn in fields:
        out.append("    /** %s */\n" % cn)
        out.append("    private %s %s;\n\n" % (java_type, prop))
    for prop, java_type, cn in fields:
        p = cap(prop)
        out.append("    public %s get%s() {\n" % (java_type, p))
        out.append("        return %s;\n" % prop)
        out.append("    }\n\n")
        out.append("    public void set%s(%s %s) {\n" % (p, java_type, prop))
        out.append("        this.%s = %s;\n" % (prop, prop))
        out.append("    }\n\n")
    out.append("    @Override\n")
    out.append("    public String toString() {\n")
    out.append("        StringBuilder sb = new StringBuilder();\n")
    out.append("        sb.append(\"%s{\");\n" % cls)
    for prop, java_type, cn in fields:
        out.append("        sb.append(\"%s=\").append(%s).append(\", \");\n" % (prop, prop))
    out.append("        sb.append('}');\n")
    out.append("        return sb.toString();\n")
    out.append("    }\n")
    out.append("}\n")
    return "".join(out)


# ---------------------------------------------------------------------------
# Entity
# ---------------------------------------------------------------------------

def gen_entity(cls, table, cn_name, cols):
    out = []
    out.append("package %s.entity;\n\n" % BASE_PKG)
    out.append("import java.io.Serializable;\n")
    out.append("import java.util.Date;\n\n")
    out.append("/**\n")
    out.append(" * %s 表实体（MyBatis Generator 生成风格，字段与列一一对应）。\n" % table.upper())
    out.append(" *\n")
    out.append(" * <p>%s。本类只承载列映射需要的 getter/setter，不含业务逻辑。\n" % cn_name)
    out.append(" */\n")
    out.append("public class %s implements Serializable {\n\n" % cls)
    out.append("    private static final long serialVersionUID = 1L;\n\n")

    for c in cols:
        out.append("    /** %s */\n" % c.comment)
        out.append("    private %s %s;\n\n" % (c.java, c.prop))

    for c in cols:
        p = cap(c.prop)
        out.append("    public %s get%s() {\n" % (c.java, p))
        out.append("        return %s;\n" % c.prop)
        out.append("    }\n\n")
        out.append("    public void set%s(%s %s) {\n" % (p, c.java, c.prop))
        out.append("        this.%s = %s;\n" % (c.prop, c.prop))
        out.append("    }\n\n")

    out.append("}\n")
    return "".join(out)


# ---------------------------------------------------------------------------
# MBG Example
# ---------------------------------------------------------------------------

def m_no_value(P, col, suffix, op):
    return ("        public Criteria and%s%s() {\n"
            "            addCriterion(\"%s %s\");\n"
            "            return (Criteria) this;\n"
            "        }\n\n") % (P, suffix, col, op)


def m_value(P, col, prop, suffix, op, jt):
    return ("        public Criteria and%s%s(%s value) {\n"
            "            addCriterion(\"%s %s\", value, \"%s\");\n"
            "            return (Criteria) this;\n"
            "        }\n\n") % (P, suffix, jt, col, op, prop)


def m_list(P, col, prop, suffix, op, jt):
    return ("        public Criteria and%s%s(List<%s> values) {\n"
            "            addCriterion(\"%s %s\", values, \"%s\");\n"
            "            return (Criteria) this;\n"
            "        }\n\n") % (P, suffix, jt, col, op, prop)


def m_between(P, col, prop, jt):
    return ("        public Criteria and%sBetween(%s value1, %s value2) {\n"
            "            addCriterion(\"%s between\", value1, value2, \"%s\");\n"
            "            return (Criteria) this;\n"
            "        }\n\n") % (P, jt, jt, col, prop)


def gen_example_methods(cols):
    out = []
    for c in cols:
        P = cap(c.prop)
        out.append(m_no_value(P, c.column, "IsNull", "is null"))
        out.append(m_no_value(P, c.column, "IsNotNull", "is not null"))
        out.append(m_value(P, c.column, c.prop, "EqualTo", "=", c.java))
        out.append(m_value(P, c.column, c.prop, "NotEqualTo", "<>", c.java))
        out.append(m_value(P, c.column, c.prop, "GreaterThan", ">", c.java))
        out.append(m_value(P, c.column, c.prop, "GreaterThanOrEqualTo", ">=", c.java))
        out.append(m_value(P, c.column, c.prop, "LessThan", "<", c.java))
        out.append(m_value(P, c.column, c.prop, "LessThanOrEqualTo", "<=", c.java))
        if c.java == "String":
            out.append(m_value(P, c.column, c.prop, "Like", "like", c.java))
            out.append(m_value(P, c.column, c.prop, "NotLike", "not like", c.java))
        out.append(m_list(P, c.column, c.prop, "In", "in", c.java))
        out.append(m_list(P, c.column, c.prop, "NotIn", "not in", c.java))
        out.append(m_between(P, c.column, c.prop, c.java))
    return "".join(out)


EXAMPLE_TEMPLATE = """package cn.song.custmetadata.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @@TABLE@@ 表 Example（MyBatis Generator 生成风格）。
 *
 * <p>@@CN@@。四层结构与 MBG 原生输出一致：oredCriteria / GeneratedCriteria /
 * Criteria / Criterion；插件预览 selectByExample 时会从 andXxxYyy 方法体的
 * addCriterion("列名 =", value, "属性名") 常量反推列名，故方法体写法不可简化。
 */
public class @@CLS@@Example implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public @@CLS@@Example() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {

        private static final long serialVersionUID = 1L;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

@@METHODS@@
    }

    public static class Criteria extends GeneratedCriteria {

        private static final long serialVersionUID = 1L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {

        private static final long serialVersionUID = 1L;

        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
"""


def gen_example(cls, table, cn_name, cols):
    body = EXAMPLE_TEMPLATE
    body = body.replace("@@TABLE@@", table.upper())
    body = body.replace("@@CN@@", cn_name)
    body = body.replace("@@CLS@@", cls)
    body = body.replace("@@METHODS@@", gen_example_methods(cols))
    return body


# ---------------------------------------------------------------------------
# Mapper 接口（原生 MyBatis）
# ---------------------------------------------------------------------------

def gen_mapper(cls, table, cn_name):
    out = []
    out.append("package %s.mapper;\n\n" % BASE_PKG)
    out.append("import %s.entity.%s;\n" % (BASE_PKG, cls))
    out.append("import %s.example.%sExample;\n" % (BASE_PKG, cls))
    out.append("import java.util.List;\n")
    out.append("import org.apache.ibatis.annotations.Param;\n\n")
    out.append("/**\n")
    out.append(" * %s 表 Mapper（MyBatis Generator 生成风格）。\n" % table.upper())
    out.append(" *\n")
    out.append(" * <p>%s。Example 查询入口是全仓调用点最密集的方法。\n" % cn_name)
    out.append(" */\n")
    out.append("public interface %sMapper {\n\n" % cls)
    out.append("    int countByExample(%sExample example);\n\n" % cls)
    out.append("    int deleteByExample(%sExample example);\n\n" % cls)
    out.append("    int deleteByPrimaryKey(Long id);\n\n")
    out.append("    int insert(%s record);\n\n" % cls)
    out.append("    int insertSelective(%s record);\n\n" % cls)
    out.append("    List<%s> selectByExample(%sExample example);\n\n" % (cls, cls))
    out.append("    %s selectByPrimaryKey(Long id);\n\n" % cls)
    out.append("    int updateByExampleSelective(@Param(\"record\") %s record, @Param(\"example\") %sExample example);\n\n" % (cls, cls))
    out.append("    int updateByExample(@Param(\"record\") %s record, @Param(\"example\") %sExample example);\n\n" % (cls, cls))
    out.append("    int updateByPrimaryKeySelective(%s record);\n\n" % cls)
    out.append("    int updateByPrimaryKey(%s record);\n\n" % cls)
    out.append("}\n")
    return "".join(out)


# ---------------------------------------------------------------------------
# Mapper XML（原生 MyBatis，MBG 形态）
# ---------------------------------------------------------------------------

def chunked_join(values, sep, per_line):
    lines = []
    for i in range(0, len(values), per_line):
        lines.append(sep.join(values[i:i + per_line]))
    return (",\n    ").join(lines)


def gen_mapper_xml(cls, table, cn_name, cols):
    upper_table = table.upper()

    result_rows = []
    for i, c in enumerate(cols):
        tag = "id" if i == 0 else "result"
        result_rows.append("    <%s column=\"%s\" jdbcType=\"%s\" property=\"%s\" />"
                           % (tag, c.column.upper(), c.jdbc, c.prop))

    upper_cols = [c.column.upper() for c in cols]
    insert_cols = chunked_join(upper_cols, ", ", 6)
    insert_values = chunked_join(["#{%s,jdbcType=%s}" % (c.prop, c.jdbc) for c in cols], ", ", 4)
    select_cols = chunked_join(upper_cols, ", ", 8)

    insert_selective_cols = []
    insert_selective_values = []
    for c in cols:
        insert_selective_cols.append("      <if test=\"%s != null\">\n        %s,\n      </if>"
                                     % (c.prop, c.column.upper()))
        insert_selective_values.append("      <if test=\"%s != null\">\n        #{%s,jdbcType=%s},\n      </if>"
                                       % (c.prop, c.prop, c.jdbc))

    update_selective = []
    update_plain = []
    update_pk_selective = []
    update_pk_plain = []
    for c in cols:
        update_selective.append("      <if test=\"record.%s != null\">\n        %s = #{record.%s,jdbcType=%s},\n      </if>"
                                % (c.prop, c.column.upper(), c.prop, c.jdbc))
        update_plain.append("%s = #{record.%s,jdbcType=%s}" % (c.column.upper(), c.prop, c.jdbc))
        update_pk_selective.append("      <if test=\"%s != null\">\n        %s = #{%s,jdbcType=%s},\n      </if>"
                                   % (c.prop, c.column.upper(), c.prop, c.jdbc))
        update_pk_plain.append("%s = #{%s,jdbcType=%s}" % (c.column.upper(), c.prop, c.jdbc))

    template = """<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.song.custmetadata.mapper.@@CLS@@Mapper">
  <resultMap id="BaseResultMap" type="cn.song.custmetadata.entity.@@CLS@@">
@@RESULT_ROWS@@
  </resultMap>
  <sql id="Example_Where_Clause">
    <where>
      <foreach collection="oredCriteria" item="criteria" separator="or">
        <if test="criteria.valid">
          <trim prefix="(" prefixOverrides="and" suffix=")">
            <foreach collection="criteria.criteria" item="criterion">
              <choose>
                <when test="criterion.noValue">
                  and ${criterion.condition}
                </when>
                <when test="criterion.singleValue">
                  and ${criterion.condition} #{criterion.value}
                </when>
                <when test="criterion.betweenValue">
                  and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}
                </when>
                <when test="criterion.listValue">
                  and ${criterion.condition}
                  <foreach close=")" collection="criterion.value" item="listItem" open="(" separator=",">
                    #{listItem}
                  </foreach>
                </when>
              </choose>
            </foreach>
          </trim>
        </if>
      </foreach>
    </where>
  </sql>
  <sql id="Update_By_Example_Where_Clause">
    <where>
      <foreach collection="example.oredCriteria" item="criteria" separator="or">
        <if test="criteria.valid">
          <trim prefix="(" prefixOverrides="and" suffix=")">
            <foreach collection="criteria.criteria" item="criterion">
              <choose>
                <when test="criterion.noValue">
                  and ${criterion.condition}
                </when>
                <when test="criterion.singleValue">
                  and ${criterion.condition} #{criterion.value}
                </when>
                <when test="criterion.betweenValue">
                  and ${criterion.condition} #{criterion.value} and #{criterion.secondValue}
                </when>
                <when test="criterion.listValue">
                  and ${criterion.condition}
                  <foreach close=")" collection="criterion.value" item="listItem" open="(" separator=",">
                    #{listItem}
                  </foreach>
                </when>
              </choose>
            </foreach>
          </trim>
        </if>
      </foreach>
    </where>
  </sql>
  <sql id="Base_Column_List">
    @@SELECT_COLS@@
  </sql>
  <select id="selectByExample" parameterType="cn.song.custmetadata.example.@@CLS@@Example" resultMap="BaseResultMap">
    select
    <if test="distinct">
      distinct
    </if>
    'false' as QUERYID,
    <include refid="Base_Column_List" />
    from @@TABLE@@
    <if test="_parameter != null">
      <include refid="Example_Where_Clause" />
    </if>
    <if test="orderByClause != null">
      order by ${orderByClause}
    </if>
  </select>
  <select id="selectByPrimaryKey" parameterType="java.lang.Long" resultMap="BaseResultMap">
    select
    <include refid="Base_Column_List" />
    from @@TABLE@@
    where ID = #{id,jdbcType=BIGINT}
  </select>
  <delete id="deleteByPrimaryKey" parameterType="java.lang.Long">
    delete from @@TABLE@@
    where ID = #{id,jdbcType=BIGINT}
  </delete>
  <delete id="deleteByExample" parameterType="cn.song.custmetadata.example.@@CLS@@Example">
    delete from @@TABLE@@
    <if test="_parameter != null">
      <include refid="Example_Where_Clause" />
    </if>
  </delete>
  <insert id="insert" parameterType="cn.song.custmetadata.entity.@@CLS@@">
    insert into @@TABLE@@ (@@INSERT_COLS@@)
    values (@@INSERT_VALUES@@)
  </insert>
  <insert id="insertSelective" parameterType="cn.song.custmetadata.entity.@@CLS@@">
    insert into @@TABLE@@
    <trim prefix="(" suffix=")" suffixOverrides=",">
@@INSERT_SELECTIVE_COLS@@
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides=",">
@@INSERT_SELECTIVE_VALUES@@
    </trim>
  </insert>
  <select id="countByExample" parameterType="cn.song.custmetadata.example.@@CLS@@Example" resultType="java.lang.Long">
    select count(*) from @@TABLE@@
    <if test="_parameter != null">
      <include refid="Example_Where_Clause" />
    </if>
  </select>
  <update id="updateByExampleSelective" parameterType="map">
    update @@TABLE@@
    <set>
@@UPDATE_SELECTIVE@@
    </set>
    <if test="_parameter != null">
      <include refid="Update_By_Example_Where_Clause" />
    </if>
  </update>
  <update id="updateByExample" parameterType="map">
    update @@TABLE@@
    set @@UPDATE_PLAIN@@
    <if test="_parameter != null">
      <include refid="Update_By_Example_Where_Clause" />
    </if>
  </update>
  <update id="updateByPrimaryKeySelective" parameterType="cn.song.custmetadata.entity.@@CLS@@">
    update @@TABLE@@
    <set>
@@UPDATE_PK_SELECTIVE@@
    </set>
    where ID = #{id,jdbcType=BIGINT}
  </update>
  <update id="updateByPrimaryKey" parameterType="cn.song.custmetadata.entity.@@CLS@@">
    update @@TABLE@@
    set @@UPDATE_PK_PLAIN@@
    where ID = #{id,jdbcType=BIGINT}
  </update>
</mapper>
"""

    body = template
    body = body.replace("@@CLS@@", cls)
    body = body.replace("@@TABLE@@", upper_table)
    body = body.replace("@@RESULT_ROWS@@", "\n".join(result_rows))
    body = body.replace("@@SELECT_COLS@@", select_cols)
    body = body.replace("@@INSERT_COLS@@", insert_cols)
    body = body.replace("@@INSERT_VALUES@@", insert_values)
    body = body.replace("@@INSERT_SELECTIVE_COLS@@", "\n".join(insert_selective_cols))
    body = body.replace("@@INSERT_SELECTIVE_VALUES@@", "\n".join(insert_selective_values))
    body = body.replace("@@UPDATE_SELECTIVE@@", "\n".join(update_selective))
    body = body.replace("@@UPDATE_PLAIN@@", ",\n    ".join(update_plain))
    body = body.replace("@@UPDATE_PK_SELECTIVE@@", "\n".join(update_pk_selective))
    body = body.replace("@@UPDATE_PK_PLAIN@@", ",\n    ".join(update_pk_plain))
    return body


# ---------------------------------------------------------------------------
# Service 接口与实现（承载 selectByExample 调用点）
# ---------------------------------------------------------------------------

SERVICE_METHOD_COUNT = 6

SERVICE_METHOD_SIGNATURE = (
    "    List<@@CLS@@> queryByCondition%02d(Long tenantId, String custNo, String custName, "
    "String status, Date startTime, Date endTime);\n\n"
)


def gen_service_interface(cls, cn_name):
    out = []
    out.append("package %s.service;\n\n" % BASE_PKG)
    out.append("import %s.entity.%s;\n" % (BASE_PKG, cls))
    out.append("import java.util.Date;\n")
    out.append("import java.util.List;\n\n")
    out.append("/**\n")
    out.append(" * %s 查询服务契约。\n" % cn_name)
    out.append(" */\n")
    out.append("public interface %sQueryService {\n\n" % cls)
    for i in range(1, SERVICE_METHOD_COUNT + 1):
        out.append(SERVICE_METHOD_SIGNATURE.replace("@@CLS@@", cls) % i)
    out.append("}\n")
    return "".join(out)


def call_block(cls, var_prefix, criteria_chain):
    mapper_var = lower_camel(cls) + "Mapper"
    return ("        %sExample %s = new %sExample();\n"
            "        %s.createCriteria().%s;\n"
            "        result.addAll(%s.selectByExample(%s));\n"
            % (cls, var_prefix, cls, var_prefix, criteria_chain, mapper_var, var_prefix))


def gen_service_impl(cls, cn_name, with_extra, variant=""):
    mapper_var = lower_camel(cls) + "Mapper"
    impl_cls = "%s%sQueryServiceImpl" % (cls, variant)
    out = []
    out.append("package %s.service.impl;\n\n" % BASE_PKG)
    out.append("import %s.entity.%s;\n" % (BASE_PKG, cls))
    out.append("import %s.example.%sExample;\n" % (BASE_PKG, cls))
    out.append("import %s.mapper.%sMapper;\n" % (BASE_PKG, cls))
    out.append("import %s.service.%sQueryService;\n" % (BASE_PKG, cls))
    out.append("import java.util.ArrayList;\n")
    out.append("import java.util.Date;\n")
    out.append("import java.util.List;\n\n")
    out.append("/**\n")
    out.append(" * %s 查询服务实现（%s档）。\n" % (cn_name, "热点表压力" if with_extra else "基础"))
    out.append(" *\n")
    out.append(" * <p>方法体保持真实链式写法：先 new Example，再 createCriteria().andXxxYyy(...)，\n")
    out.append(" * 最后把 example 交给 mapper.selectByExample，便于静态引用搜索形成密集关系。\n")
    out.append(" */\n")
    out.append("public class %s implements %sQueryService {\n\n" % (impl_cls, cls))
    out.append("    private final %sMapper %s;\n\n" % (cls, mapper_var))
    out.append("    public %s(%sMapper %s) {\n" % (impl_cls, cls, mapper_var))
    out.append("        this.%s = %s;\n" % (mapper_var, mapper_var))
    out.append("    }\n\n")

    chain_a = "andTenantIdEqualTo(tenantId).andCustNoEqualTo(custNo)"
    chain_b = "andTenantIdEqualTo(tenantId).andCustNameLike(custName).andStatusEqualTo(status)"
    chain_c = "andTenantIdEqualTo(tenantId).andCreateTimeBetween(startTime, endTime)"
    chain_d = "andCustNoEqualTo(custNo).andDelFlagEqualTo(\"0\")"
    chains = [chain_a, chain_b, chain_c, chain_d]

    for i in range(1, SERVICE_METHOD_COUNT + 1):
        out.append("    public List<%s> queryByCondition%02d(Long tenantId, String custNo, String custName, "
                   "String status, Date startTime, Date endTime) {\n" % (cls, i))
        out.append("        List<%s> result = new ArrayList<%s>();\n" % (cls, cls))
        out.append(call_block(cls, "example%02dA" % i, chains[(i - 1) % len(chains)]))
        out.append(call_block(cls, "example%02dB" % i, chains[i % len(chains)]))
        out.append("        return result;\n")
        out.append("    }\n\n")

    if with_extra:
        for i in range(1, 17):
            out.append("    public List<%s> queryBatch%02d(Long tenantId, String custNo, String custName, "
                       "String status, Date startTime, Date endTime) {\n" % (cls, i))
            out.append("        List<%s> result = new ArrayList<%s>();\n" % (cls, cls))
            for k in range(3):
                out.append(call_block(cls, "batch%02d%02d" % (i, k + 1), chains[(i + k) % len(chains)]))
            out.append("        return result;\n")
            out.append("    }\n\n")

    out.append("}\n")
    return "".join(out)


# ---------------------------------------------------------------------------
# Controller（原生 MyBatis 服务）
# ---------------------------------------------------------------------------

def gen_controller(cls, cn_name):
    out = []
    out.append("package %s.controller;\n\n" % BASE_PKG)
    out.append("import %s.entity.%s;\n" % (BASE_PKG, cls))
    out.append("import %s.service.%sQueryService;\n" % (BASE_PKG, cls))
    out.append("import java.util.Date;\n")
    out.append("import java.util.List;\n\n")
    out.append("/**\n")
    out.append(" * %s查询入口（Controller 层）。\n" % cn_name)
    out.append(" *\n")
    out.append(" * <p>路由约定：\n")
    out.append(" * <ul>\n")
    out.append(" *   <li>GET /api/cust/%s/page</li>\n" % cls.lower())
    out.append(" *   <li>GET /api/cust/%s/detail</li>\n" % cls.lower())
    out.append(" *   <li>POST /api/cust/%s/query</li>\n" % cls.lower())
    out.append(" * </ul>\n")
    out.append(" */\n")
    out.append("public class %sController {\n\n" % cls)
    out.append("    private final %sQueryService queryService;\n\n" % cls)
    out.append("    public %sController(%sQueryService queryService) {\n" % (cls, cls))
    out.append("        this.queryService = queryService;\n")
    out.append("    }\n\n")
    for i in range(1, 5):
        out.append("    public List<%s> page%02d(Long tenantId, String custNo, String custName, "
                   "String status, Date startTime, Date endTime) {\n" % (cls, i))
        out.append("        return queryService.queryByCondition%02d(tenantId, custNo, custName, status, startTime, endTime);\n"
                   % (((i - 1) % SERVICE_METHOD_COUNT) + 1))
        out.append("    }\n\n")
    out.append("}\n")
    return "".join(out)


# ---------------------------------------------------------------------------
# 填充类：dto / convert / util / config / bo / validator
# ---------------------------------------------------------------------------

DOMAINS = [
    ("cust", "客户"), ("cert", "证件"), ("bank", "银行"), ("asset", "资产"), ("risk", "风险"),
    ("credit", "信用"), ("industry", "行业"), ("channel", "渠道"), ("manager", "经理"), ("visit", "拜访"),
    ("contract", "合同"), ("order", "订单"), ("payment", "付款"), ("invoice", "发票"), ("settle", "结算"),
    ("audit", "审计"), ("attach", "附件"), ("note", "备注"), ("prefer", "偏好"), ("score", "评分"),
]

ATTRS = [
    ("No", "编号", "String"), ("Name", "名称", "String"), ("Type", "类型", "String"),
    ("Code", "编码", "String"), ("Level", "级别", "String"), ("Status", "状态", "String"),
    ("Amount", "金额", "BigDecimal"), ("Count", "数量", "Integer"), ("Rate", "比率", "BigDecimal"),
    ("Date", "日期", "Date"), ("Time", "时间", "Date"), ("Flag", "标记", "Boolean"),
    ("Remark", "说明", "String"), ("Source", "来源", "String"), ("Version", "版本", "Integer"),
    ("Region", "区域", "String"), ("Channel", "渠道", "String"), ("Group", "分组", "String"),
    ("Tag", "标签", "String"), ("Owner", "负责人", "String"),
]


def build_attribute_pool():
    pool = []
    for domain, domain_cn in DOMAINS:
        for attr, attr_cn, java_type in ATTRS:
            pool.append((domain + attr, java_type, domain_cn + attr_cn))
    return pool


ATTRIBUTE_POOL = build_attribute_pool()


def take_slice(pool, start, count):
    size = len(pool)
    return [pool[(start + i) % size] for i in range(count)]


def java_imports(types):
    imports = ["java.io.Serializable"]
    if "BigDecimal" in types:
        imports.append("java.math.BigDecimal")
    if "Date" in types:
        imports.append("java.util.Date")
    return imports


def field_block(fields):
    out = []
    for prop, java_type, cn in fields:
        out.append("    /** %s */\n" % cn)
        out.append("    private %s %s;\n\n" % (java_type, prop))
    return "".join(out)


def accessor_block(fields):
    out = []
    for prop, java_type, cn in fields:
        p = cap(prop)
        out.append("    public %s get%s() {\n" % (java_type, p))
        out.append("        return %s;\n" % prop)
        out.append("    }\n\n")
        out.append("    public void set%s(%s %s) {\n" % (p, java_type, prop))
        out.append("        this.%s = %s;\n" % (prop, prop))
        out.append("    }\n\n")
    return "".join(out)


def gen_dto(name, cn_name, fields):
    types = set(f[1] for f in fields)
    out = []
    out.append("package %s.dto;\n\n" % BASE_PKG)
    for imp in java_imports(types):
        out.append("import %s;\n" % imp)
    out.append("\n")
    out.append("/**\n")
    out.append(" * %s 传输对象。\n" % cn_name)
    out.append(" *\n")
    out.append(" * <p>字段为查询/导出场景的扁平投影，仅保留 getter/setter 与 toString。\n")
    out.append(" */\n")
    out.append("public class %s implements Serializable {\n\n" % name)
    out.append("    private static final long serialVersionUID = 1L;\n\n")
    out.append(field_block(fields))
    out.append(accessor_block(fields))
    out.append("    @Override\n")
    out.append("    public String toString() {\n")
    out.append("        StringBuilder sb = new StringBuilder();\n")
    out.append("        sb.append(\"%s{\");\n" % name)
    for prop, java_type, cn in fields:
        out.append("        sb.append(\"%s=\").append(%s).append(\", \");\n" % (prop, prop))
    out.append("        sb.append('}');\n")
    out.append("        return sb.toString();\n")
    out.append("    }\n")
    out.append("}\n")
    return "".join(out)


def gen_bo(name, cn_name, fields):
    types = set(f[1] for f in fields)
    out = []
    out.append("package %s.bo;\n\n" % BASE_PKG)
    for imp in java_imports(types):
        out.append("import %s;\n" % imp)
    out.append("\n")
    out.append("/**\n")
    out.append(" * %s 查询条件对象。\n" % cn_name)
    out.append(" *\n")
    out.append(" * <p>供 Service/Controller 逐层传递筛选条件，字段与查询页面对应。\n")
    out.append(" */\n")
    out.append("public class %s implements Serializable {\n\n" % name)
    out.append("    private static final long serialVersionUID = 1L;\n\n")
    out.append(field_block(fields))
    out.append(accessor_block(fields))
    out.append("    public boolean isEmpty() {\n")
    out.append("        return false;\n")
    out.append("    }\n\n")
    out.append("    @Override\n")
    out.append("    public String toString() {\n")
    out.append("        StringBuilder sb = new StringBuilder();\n")
    out.append("        sb.append(\"%s{\");\n" % name)
    for prop, java_type, cn in fields[:30]:
        out.append("        sb.append(\"%s=\").append(%s).append(\", \");\n" % (prop, prop))
    out.append("        sb.append('}');\n")
    out.append("        return sb.toString();\n")
    out.append("    }\n")
    out.append("}\n")
    return "".join(out)


def converter_method(prop, java_type, cn):
    p = cap(prop)
    if java_type == "String":
        return ("    /** 归一化%s。 */\n"
                "    public static String adapt%s(String value, String defaultValue) {\n"
                "        if (value == null) {\n"
                "            return defaultValue;\n"
                "        }\n"
                "        String text = value.trim();\n"
                "        if (text.length() == 0) {\n"
                "            return defaultValue;\n"
                "        }\n"
                "        return text;\n"
                "    }\n\n") % (cn, p)
    if java_type == "Integer":
        return ("    /** 归一化%s。 */\n"
                "    public static Integer adapt%s(Integer value, Integer defaultValue) {\n"
                "        if (value == null) {\n"
                "            return defaultValue;\n"
                "        }\n"
                "        if (value.intValue() < 0) {\n"
                "            return defaultValue;\n"
                "        }\n"
                "        return value;\n"
                "    }\n\n") % (cn, p)
    if java_type == "BigDecimal":
        return ("    /** 归一化%s（保留两位小数）。 */\n"
                "    public static BigDecimal adapt%s(BigDecimal value, BigDecimal defaultValue) {\n"
                "        if (value == null) {\n"
                "            return defaultValue;\n"
                "        }\n"
                "        if (value.signum() < 0) {\n"
                "            return defaultValue;\n"
                "        }\n"
                "        return value.setScale(2, RoundingMode.HALF_UP);\n"
                "    }\n\n") % (cn, p)
    if java_type == "Date":
        return ("    /** 复制%s（防御 Date 可变性）。 */\n"
                "    public static Date adapt%s(Date value, Date defaultValue) {\n"
                "        if (value == null) {\n"
                "            return defaultValue;\n"
                "        }\n"
                "        return new Date(value.getTime());\n"
                "    }\n\n") % (cn, p)
    return ("    /** 归一化%s。 */\n"
            "    public static Boolean adapt%s(Boolean value, Boolean defaultValue) {\n"
            "        if (value == null) {\n"
            "            return defaultValue;\n"
            "        }\n"
            "        return value;\n"
            "    }\n\n") % (cn, p)


def gen_converter(name, cn_name, items):
    out = []
    out.append("package %s.convert;\n\n" % BASE_PKG)
    out.append("import java.math.BigDecimal;\n")
    out.append("import java.math.RoundingMode;\n")
    out.append("import java.util.Date;\n\n")
    out.append("/**\n")
    out.append(" * %s 字段适配器。\n" % cn_name)
    out.append(" *\n")
    out.append(" * <p>把上游系统的宽松入参收敛成统一形态，空值与非法值一律回落到默认值。\n")
    out.append(" */\n")
    out.append("public final class %s {\n\n" % name)
    out.append("    private %s() {\n" % name)
    out.append("    }\n\n")
    for prop, java_type, cn in items:
        out.append(converter_method(prop, java_type, cn))
    out.append("}\n")
    return "".join(out)


UTIL_VERBS = [
    ("normalize", "归一化"), ("sanitize", "清洗"), ("parse", "解析"), ("format", "格式化"),
    ("validate", "校验"), ("merge", "合并"), ("extract", "提取"), ("append", "追加"),
    ("resolve", "推导"), ("convert", "转换"),
]


def util_method(verb, cn_verb, prop, java_type, cn):
    p = cap(prop)
    name = verb + p
    if java_type == "String":
        return ("    /** %s%s。 */\n"
                "    public static String %s(String value) {\n"
                "        if (value == null) {\n"
                "            return \"\";\n"
                "        }\n"
                "        return value.trim().toUpperCase(Locale.ROOT);\n"
                "    }\n\n") % (cn_verb, cn, name)
    if java_type == "Integer":
        return ("    /** %s%s。 */\n"
                "    public static Integer %s(String value) {\n"
                "        if (value == null || value.trim().length() == 0) {\n"
                "            return Integer.valueOf(0);\n"
                "        }\n"
                "        try {\n"
                "            return Integer.valueOf(value.trim());\n"
                "        } catch (NumberFormatException ex) {\n"
                "            return Integer.valueOf(0);\n"
                "        }\n"
                "    }\n\n") % (cn_verb, cn, name)
    if java_type == "BigDecimal":
        return ("    /** %s%s。 */\n"
                "    public static BigDecimal %s(String value) {\n"
                "        if (value == null || value.trim().length() == 0) {\n"
                "            return BigDecimal.ZERO;\n"
                "        }\n"
                "        try {\n"
                "            return new BigDecimal(value.trim());\n"
                "        } catch (NumberFormatException ex) {\n"
                "            return BigDecimal.ZERO;\n"
                "        }\n"
                "    }\n\n") % (cn_verb, cn, name)
    if java_type == "Date":
        return ("    /** %s%s。 */\n"
                "    public static Date %s(String value) {\n"
                "        if (value == null || value.trim().length() == 0) {\n"
                "            return new Date(0L);\n"
                "        }\n"
                "        try {\n"
                "            return new SimpleDateFormat(\"yyyy-MM-dd\").parse(value.trim());\n"
                "        } catch (ParseException ex) {\n"
                "            return new Date(0L);\n"
                "        }\n"
                "    }\n\n") % (cn_verb, cn, name)
    return ("    /** %s%s。 */\n"
            "    public static Boolean %s(String value) {\n"
            "        if (value == null) {\n"
            "            return Boolean.FALSE;\n"
            "        }\n"
            "        String text = value.trim();\n"
            "        return Boolean.valueOf(\"1\".equals(text) || \"true\".equalsIgnoreCase(text));\n"
            "    }\n\n") % (cn_verb, cn, name)


def gen_util(name, cn_name, items):
    out = []
    out.append("package %s.util;\n\n" % BASE_PKG)
    out.append("import java.math.BigDecimal;\n")
    out.append("import java.text.ParseException;\n")
    out.append("import java.text.SimpleDateFormat;\n")
    out.append("import java.util.Date;\n")
    out.append("import java.util.Locale;\n\n")
    out.append("/**\n")
    out.append(" * %s 相关字符串/数值工具。\n" % cn_name)
    out.append(" */\n")
    out.append("public final class %s {\n\n" % name)
    out.append("    private %s() {\n" % name)
    out.append("    }\n\n")
    for verb, cn_verb, prop, java_type, cn in items:
        out.append(util_method(verb, cn_verb, prop, java_type, cn))
    out.append("}\n")
    return "".join(out)


CONFIG_PREFIXES = [
    ("LIMIT", "单次查询上限"), ("TIMEOUT", "超时毫秒数"), ("RETRY", "重试次数"),
    ("CACHE", "缓存秒数"), ("BATCH", "批处理条数"), ("EXPIRED", "过期天数"),
]


def gen_config(name, cn_name, constants, methods):
    out = []
    out.append("package %s.config;\n\n" % BASE_PKG)
    out.append("/**\n")
    out.append(" * %s 模块参数。\n" % cn_name)
    out.append(" *\n")
    out.append(" * <p>常量集中在此，避免各 Service 里散落魔法值。\n")
    out.append(" */\n")
    out.append("public final class %s {\n\n" % name)
    out.append("    public static final String MODULE_CODE = \"%s\";\n\n"
               % snake(name).replace("_MODULE_CONFIG", ""))
    for const_name, value, comment in constants:
        out.append("    /** %s */\n" % comment)
        out.append("    public static final long %s = %dL;\n\n" % (const_name, value))
    out.append("    private %s() {\n" % name)
    out.append("    }\n\n")
    for const_name, comment in methods:
        method_name = cap(const_name.lower().replace("_", " ").title().replace(" ", ""))
        out.append("    /** %s。 */\n" % comment)
        out.append("    public static long resolve%s(long requested) {\n" % method_name)
        out.append("        if (requested <= 0L) {\n")
        out.append("            return %s;\n" % const_name)
        out.append("        }\n")
        out.append("        if (requested > %s) {\n" % const_name)
        out.append("            return %s;\n" % const_name)
        out.append("        }\n")
        out.append("        return requested;\n")
        out.append("    }\n\n")
    out.append("}\n")
    return "".join(out)


def gen_validator(name, cn_name, fields):
    out = []
    out.append("package %s.validator;\n\n" % BASE_PKG)
    out.append("import java.util.List;\n\n")
    out.append("/**\n")
    out.append(" * %s 字段校验器。\n" % cn_name)
    out.append(" *\n")
    out.append(" * <p>错误信息追加到调用方传入的 errors，便于一次返回全部问题。\n")
    out.append(" */\n")
    out.append("public final class %s {\n\n" % name)
    out.append("    private %s() {\n" % name)
    out.append("    }\n\n")
    for prop, java_type, cn in fields:
        p = cap(prop)
        out.append("    /** 校验%s。 */\n" % cn)
        out.append("    public static void validate%s(Object value, List<String> errors) {\n" % p)
        out.append("        if (value == null) {\n")
        out.append("            errors.add(\"%s 不能为空\");\n" % prop)
        out.append("            return;\n")
        out.append("        }\n")
        out.append("        String text = String.valueOf(value).trim();\n")
        out.append("        if (text.length() == 0) {\n")
        out.append("            errors.add(\"%s 不能为空白\");\n" % prop)
        out.append("            return;\n")
        out.append("        }\n")
        out.append("        if (text.length() > 128) {\n")
        out.append("            errors.add(\"%s 长度不能超过 128\");\n" % prop)
        out.append("        }\n")
        out.append("    }\n\n")
    out.append("}\n")
    return "".join(out)


# ---------------------------------------------------------------------------
# 工程级 pom
# ---------------------------------------------------------------------------

AGGREGATOR_POM = """<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>cn.song</groupId>
  <artifactId>cust-big-demo</artifactId>
  <version>1.0.0</version>
  <packaging>pom</packaging>
  <name>cust-big-demo</name>
  <description>
    微服务多模块大工程语料，用于复现 SQL Visualizer 在真实客户主数据项目中的性能问题。
    cust-metadata 为原生 MyBatis（MBG 生成风格）主战场，cust-center 为 MyBatis-Plus 服务，
    cust-common 为共享库，cust-gateway 为网关。本工程独立聚合，不改 demo 根 pom。
  </description>

  <modules>
    <module>cust-common</module>
    <module>cust-center</module>
    <module>cust-metadata</module>
    <module>cust-gateway</module>
  </modules>

  <properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>
</project>
"""

CHILD_POM_TEMPLATE = """<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <parent>
    <groupId>cn.song</groupId>
    <artifactId>cust-big-demo</artifactId>
    <version>1.0.0</version>
    <relativePath>../pom.xml</relativePath>
  </parent>

  <artifactId>@@ARTIFACT@@</artifactId>
  <packaging>jar</packaging>
  <name>@@ARTIFACT@@</name>
  <description>
@@DESC@@
  </description>

  <properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
@@DEPS@@
    <!--
      外部依赖坐标故意注释：本工程只用于造语料，不参与构建，也不要求能编译通过。
      取消注释即可还原真实工程依赖（离线环境请先自备本地仓库）。
    -->
  </dependencies>
</project>
"""

COMMON_DEP = """    <dependency>
      <groupId>cn.song</groupId>
      <artifactId>cust-common</artifactId>
      <version>${project.version}</version>
    </dependency>
"""

COMMENTED_MYBATIS = """    <!--
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>3.5.19</version>
    </dependency>
    <dependency>
      <groupId>org.mybatis.generator</groupId>
      <artifactId>mybatis-generator-core</artifactId>
      <version>1.4.2</version>
    </dependency>
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.33</version>
    </dependency>
    -->
"""

COMMENTED_MYBATIS_PLUS = """    <!--
    <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-boot-starter</artifactId>
      <version>3.5.7</version>
    </dependency>
    <dependency>
      <groupId>com.mysql</groupId>
      <artifactId>mysql-connector-j</artifactId>
      <version>8.4.0</version>
    </dependency>
    -->
"""

COMMENTED_GATEWAY = """    <!--
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <version>3.2.5</version>
    </dependency>
    -->
"""


def child_pom(artifact, description, deps):
    body = CHILD_POM_TEMPLATE
    body = body.replace("@@ARTIFACT@@", artifact)
    body = body.replace("@@DESC@@", description)
    body = body.replace("@@DEPS@@", deps.rstrip())
    return body


# ---------------------------------------------------------------------------
# cust-common
# ---------------------------------------------------------------------------

def gen_common_module():
    _, java_root, _, pkg = module_roots("cust-common")

    write_file(PROJECT_DIR / "cust-common" / "pom.xml",
               child_pom("cust-common",
                         "    共享模块：统一响应体、常量、异常、工具类与跨服务 DTO。",
                         ""))

    api_dir = pkg / "api"
    write_file(api_dir / "ApiResult.java", '''package cn.song.custcommon.api;

import java.io.Serializable;

/**
 * 统一响应体。
 */
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int CODE_OK = 0;

    public static final int CODE_FAIL = 500;

    private int code;

    private String message;

    private T data;

    public ApiResult() {
    }

    public ApiResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResult<T> ok(T data) {
        return new ApiResult<T>(CODE_OK, "OK", data);
    }

    public static <T> ApiResult<T> fail(int code, String message) {
        return new ApiResult<T>(code, message, null);
    }

    public boolean isSuccess() {
        return code == CODE_OK;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
''')

    write_file(api_dir / "ApiPage.java", '''package cn.song.custcommon.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页响应载荷。
 */
public class ApiPage<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private long pageNo = 1L;

    private long pageSize = 20L;

    private long total;

    private List<T> records = new ArrayList<T>();

    public ApiPage() {
    }

    public ApiPage(long pageNo, long pageSize, long total, List<T> records) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
        this.records = records;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
''')

    write_file(pkg / "constant" / "CommonConstants.java", '''package cn.song.custcommon.constant;

/**
 * 跨服务共享常量。
 */
public final class CommonConstants {

    public static final String DEFAULT_TENANT = "000000";

    public static final String DEL_FLAG_NORMAL = "0";

    public static final String DEL_FLAG_DELETED = "1";

    public static final String STATUS_ENABLED = "1";

    public static final String STATUS_DISABLED = "0";

    public static final int PAGE_SIZE_DEFAULT = 20;

    public static final int PAGE_SIZE_MAX = 500;

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String TRACE_HEADER = "X-Trace-Id";

    private CommonConstants() {
    }
}
''')

    write_file(pkg / "constant" / "ErrorCode.java", '''package cn.song.custcommon.constant;

/**
 * 错误码。
 */
public final class ErrorCode {

    public static final int SUCCESS = 0;

    public static final int PARAM_INVALID = 40001;

    public static final int UNAUTHORIZED = 40101;

    public static final int FORBIDDEN = 40301;

    public static final int NOT_FOUND = 40401;

    public static final int CONFLICT = 40901;

    public static final int SYSTEM_ERROR = 50001;

    private ErrorCode() {
    }

    public static String messageOf(int code) {
        switch (code) {
            case SUCCESS:
                return "成功";
            case PARAM_INVALID:
                return "参数不合法";
            case UNAUTHORIZED:
                return "未认证";
            case FORBIDDEN:
                return "无权限";
            case NOT_FOUND:
                return "资源不存在";
            case CONFLICT:
                return "资源冲突";
            default:
                return "系统异常";
        }
    }
}
''')

    write_file(pkg / "exception" / "BizException.java", '''package cn.song.custcommon.exception;

import cn.song.custcommon.constant.ErrorCode;

/**
 * 业务异常。
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final int code;

    public BizException(String message) {
        super(message);
        this.code = ErrorCode.PARAM_INVALID;
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
''')

    write_file(pkg / "exception" / "SystemException.java", '''package cn.song.custcommon.exception;

/**
 * 系统级异常。
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
''')

    write_file(pkg / "util" / "StringUtils.java", '''package cn.song.custcommon.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串工具。
 */
public final class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String value) {
        return value == null || value.trim().length() == 0;
    }

    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }

    public static String trimToEmpty(String value) {
        return value == null ? "" : value.trim();
    }

    public static String defaultIfBlank(String value, String defaultValue) {
        return isBlank(value) ? defaultValue : value;
    }

    public static String upper(String value) {
        return value == null ? null : value.trim().toUpperCase();
    }

    public static String lower(String value) {
        return value == null ? null : value.trim().toLowerCase();
    }

    public static String join(List<String> values, String separator) {
        if (values == null || values.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) {
                sb.append(separator);
            }
            sb.append(values.get(i));
        }
        return sb.toString();
    }

    public static List<String> split(String value, String separator) {
        List<String> result = new ArrayList<String>();
        if (isBlank(value)) {
            return result;
        }
        String[] parts = value.split(separator);
        for (String part : parts) {
            if (isNotBlank(part)) {
                result.add(part.trim());
            }
        }
        return result;
    }

    public static String leftPad(String value, int length, char pad) {
        String text = trimToEmpty(value);
        StringBuilder sb = new StringBuilder();
        for (int i = text.length(); i < length; i++) {
            sb.append(pad);
        }
        sb.append(text);
        return sb.toString();
    }
}
''')

    write_file(pkg / "util" / "DateUtils.java", '''package cn.song.custcommon.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具。
 */
public final class DateUtils {

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private DateUtils() {
    }

    public static Date parse(String value, String pattern) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        try {
            return new SimpleDateFormat(pattern).parse(value.trim());
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String format(Date value, String pattern) {
        if (value == null) {
            return "";
        }
        return new SimpleDateFormat(pattern).format(value);
    }

    public static Date addDays(Date value, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    public static Date startOfDay(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date endOfDay(Date value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static long daysBetween(Date start, Date end) {
        if (start == null || end == null) {
            return 0L;
        }
        long millis = end.getTime() - start.getTime();
        return millis / (24L * 60L * 60L * 1000L);
    }
}
''')

    write_file(pkg / "util" / "IdUtils.java", '''package cn.song.custcommon.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 简单 ID 生成器（演示用）。
 */
public final class IdUtils {

    private static final AtomicLong SEQUENCE = new AtomicLong(1000L);

    private IdUtils() {
    }

    public static long nextId() {
        return System.currentTimeMillis() * 1000L + SEQUENCE.incrementAndGet() % 1000L;
    }

    public static String nextBizNo(String prefix) {
        return StringUtils.trimToEmpty(prefix) + nextId();
    }

    public static Long parseLong(String value) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        try {
            return Long.valueOf(value.trim());
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
''')

    write_file(pkg / "util" / "CollectionUtils.java", '''package cn.song.custcommon.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 集合工具。
 */
public final class CollectionUtils {

    private CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> values) {
        return values == null || values.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> values) {
        return !isEmpty(values);
    }

    public static <T> List<T> emptyIfNull(List<T> values) {
        return values == null ? new ArrayList<T>() : values;
    }

    public static <T> Set<T> distinct(List<T> values) {
        Set<T> result = new LinkedHashSet<T>();
        if (values != null) {
            result.addAll(values);
        }
        return result;
    }

    public static <T> List<T> limit(List<T> values, int maxSize) {
        List<T> result = new ArrayList<T>();
        if (values == null || maxSize <= 0) {
            return result;
        }
        for (int i = 0; i < values.size() && i < maxSize; i++) {
            result.add(values.get(i));
        }
        return result;
    }

    public static <T> List<List<T>> partition(List<T> values, int size) {
        List<List<T>> result = new ArrayList<List<T>>();
        if (values == null || size <= 0) {
            return result;
        }
        List<T> bucket = new ArrayList<T>();
        for (T value : values) {
            bucket.add(value);
            if (bucket.size() == size) {
                result.add(bucket);
                bucket = new ArrayList<T>();
            }
        }
        if (!bucket.isEmpty()) {
            result.add(bucket);
        }
        return result;
    }
}
''')

    write_file(pkg / "util" / "BeanUtils.java", '''package cn.song.custcommon.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射工具（仅用于演示页面的字段投影）。
 */
public final class BeanUtils {

    private BeanUtils() {
    }

    public static Map<String, Object> toMap(Object bean) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (bean == null) {
            return result;
        }
        Class<?> type = bean.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                result.put(field.getName(), field.get(bean));
            } catch (IllegalAccessException ex) {
                result.put(field.getName(), null);
            }
        }
        return result;
    }

    public static void copy(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        Map<String, Object> values = toMap(source);
        Field[] fields = target.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!values.containsKey(field.getName())) {
                continue;
            }
            field.setAccessible(true);
            try {
                field.set(target, values.get(field.getName()));
            } catch (IllegalAccessException ex) {
                // 忽略不可写字段
            }
        }
    }
}
''')

    write_file(pkg / "util" / "CryptoUtils.java", '''package cn.song.custcommon.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 摘要工具。
 */
public final class CryptoUtils {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private CryptoUtils() {
    }

    public static String md5Hex(String value) {
        if (value == null) {
            return "";
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(value.getBytes(UTF8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

    public static String maskMobile(String mobile) {
        if (StringUtils.isBlank(mobile) || mobile.length() < 7) {
            return mobile;
        }
        return mobile.substring(0, 3) + "****" + mobile.substring(mobile.length() - 4);
    }

    public static String maskCertNo(String certNo) {
        if (StringUtils.isBlank(certNo) || certNo.length() < 8) {
            return certNo;
        }
        return certNo.substring(0, 4) + "**********" + certNo.substring(certNo.length() - 4);
    }
}
''')

    write_file(pkg / "dto" / "OperatorDTO.java",
               simple_pojo("cn.song.custcommon.dto", "OperatorDTO", "操作人信息",
                           [("operatorId", "Long", "操作人ID"),
                            ("operatorName", "String", "操作人姓名"),
                            ("tenantId", "Long", "租户ID"),
                            ("roles", "java.util.List<String>", "角色集合")],
                           imports=["java.util.List"]))

    write_file(pkg / "dto" / "DictItemDTO.java",
               simple_pojo("cn.song.custcommon.dto", "DictItemDTO", "字典项",
                           [("dictType", "String", "字典类型"),
                            ("dictLabel", "String", "字典标签"),
                            ("dictValue", "String", "字典值"),
                            ("sortNo", "Integer", "排序号")]))

    write_file(pkg / "dto" / "OrgDTO.java",
               simple_pojo("cn.song.custcommon.dto", "OrgDTO", "组织节点",
                           [("orgId", "Long", "组织ID"),
                            ("orgCode", "String", "组织编码"),
                            ("orgName", "String", "组织名称"),
                            ("parentId", "Long", "父组织ID"),
                            ("orgPath", "String", "组织路径")]))

    write_file(pkg / "dto" / "RegionDTO.java",
               simple_pojo("cn.song.custcommon.dto", "RegionDTO", "行政区划",
                           [("regionCode", "String", "区划编码"),
                            ("regionName", "String", "区划名称"),
                            ("parentCode", "String", "上级区划"),
                            ("regionLevel", "Integer", "区划层级")]))

    write_file(pkg / "enums" / "StatusEnum.java", '''package cn.song.custcommon.enums;

/**
 * 启停状态。
 */
public enum StatusEnum {

    DISABLED("0", "停用"),

    ENABLED("1", "启用");

    private final String code;

    private final String label;

    StatusEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static StatusEnum fromCode(String code) {
        for (StatusEnum item : values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        return DISABLED;
    }
}
''')

    write_file(pkg / "enums" / "YesNoEnum.java", '''package cn.song.custcommon.enums;

/**
 * 是否枚举。
 */
public enum YesNoEnum {

    NO("0", "否"),

    YES("1", "是");

    private final String code;

    private final String label;

    YesNoEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}
''')


# ---------------------------------------------------------------------------
# cust-center（MyBatis-Plus）
# ---------------------------------------------------------------------------

CENTER_COMMON_FIELDS = [
    ("tenantId", "Long", "租户ID"),
    ("status", "String", "状态"),
    ("delFlag", "String", "删除标记"),
    ("createTime", "Date", "创建时间"),
    ("updateTime", "Date", "更新时间"),
]

# (类名, 表名, 中文名, 关键字属性, 关键字列, 编码属性, 编码列, 扩展字段)
CENTER_ENTITIES = [
    ("User", "sys_user", "用户", "userName", "user_name", "userName", "user_name", [
        ("userName", "String", "用户名"), ("nickName", "String", "昵称"),
        ("mobileNo", "String", "手机号"), ("emailAddr", "String", "邮箱"),
        ("passwordHash", "String", "密码摘要"), ("lastLoginTime", "Date", "最后登录时间"),
    ]),
    ("CustInfo", "cust_info", "客户信息", "custName", "cust_name", "custNo", "cust_no", [
        ("custNo", "String", "客户编号"), ("custName", "String", "客户名称"),
        ("custType", "String", "客户类型"), ("certNo", "String", "证件号码"),
        ("mobileNo", "String", "手机号"), ("managerId", "Long", "客户经理ID"),
    ]),
    ("CustTag", "cust_tag", "客户标签", "tagName", "tag_name", "tagCode", "tag_code", [
        ("tagCode", "String", "标签编码"), ("tagName", "String", "标签名称"),
        ("tagLevel", "Integer", "标签层级"), ("tagColor", "String", "标签颜色"),
    ]),
    ("SysRole", "sys_role", "角色", "roleName", "role_name", "roleCode", "role_code", [
        ("roleCode", "String", "角色编码"), ("roleName", "String", "角色名称"),
        ("roleSort", "Integer", "排序号"),
    ]),
    ("SysDept", "sys_dept", "部门", "deptName", "dept_name", "deptCode", "dept_code", [
        ("deptCode", "String", "部门编码"), ("deptName", "String", "部门名称"),
        ("parentId", "Long", "父部门ID"), ("deptPath", "String", "部门路径"),
    ]),
    ("SysMenu", "sys_menu", "菜单", "menuName", "menu_name", "menuCode", "menu_code", [
        ("menuCode", "String", "菜单编码"), ("menuName", "String", "菜单名称"),
        ("menuPath", "String", "菜单路径"), ("menuType", "String", "菜单类型"),
    ]),
    ("SysDict", "sys_dict", "字典", "dictLabel", "dict_label", "dictType", "dict_type", [
        ("dictType", "String", "字典类型"), ("dictLabel", "String", "字典标签"),
        ("dictValue", "String", "字典值"), ("dictSort", "Integer", "排序号"),
    ]),
    ("SysConfig", "sys_config", "参数配置", "configDesc", "config_desc", "configKey", "config_key", [
        ("configKey", "String", "参数键"), ("configValue", "String", "参数值"),
        ("configDesc", "String", "参数说明"),
    ]),
    ("SysNotice", "sys_notice", "通知公告", "noticeTitle", "notice_title", "noticeType", "notice_type", [
        ("noticeTitle", "String", "标题"), ("noticeContent", "String", "内容"),
        ("noticeType", "String", "类型"),
    ]),
    ("OperLog", "sys_oper_log", "操作日志", "operModule", "oper_module", "operModule", "oper_module", [
        ("operModule", "String", "模块"), ("operAction", "String", "动作"),
        ("operUser", "String", "操作人"), ("operIp", "String", "操作IP"),
        ("operResult", "String", "结果"),
    ]),
    ("LoginLog", "sys_login_log", "登录日志", "loginUser", "login_user", "loginUser", "login_user", [
        ("loginUser", "String", "登录账号"), ("loginIp", "String", "登录IP"),
        ("loginResult", "String", "登录结果"), ("loginTime", "Date", "登录时间"),
    ]),
    ("TenantInfo", "sys_tenant", "租户", "tenantName", "tenant_name", "tenantCode", "tenant_code", [
        ("tenantCode", "String", "租户编码"), ("tenantName", "String", "租户名称"),
        ("tenantLevel", "Integer", "租户等级"), ("expireTime", "Date", "到期时间"),
    ]),
]


def gen_mp_entity(cls, table, cn_name, extras):
    fields = [("id", "Long", "主键ID")] + extras + CENTER_COMMON_FIELDS + [("extInfo", "String", "扩展信息（非表字段）")]
    out = []
    out.append("package %s.entity;\n\n" % MODULES["cust-center"])
    out.append("import com.baomidou.mybatisplus.annotation.IdType;\n")
    out.append("import com.baomidou.mybatisplus.annotation.TableField;\n")
    out.append("import com.baomidou.mybatisplus.annotation.TableId;\n")
    out.append("import com.baomidou.mybatisplus.annotation.TableName;\n")
    out.append("import java.io.Serializable;\n")
    out.append("import java.util.Date;\n\n")
    out.append("/**\n")
    out.append(" * %s 实体（MyBatis-Plus）。\n" % cn_name)
    out.append(" */\n")
    out.append("@TableName(\"%s\")\n" % table)
    out.append("public class %s implements Serializable {\n\n" % cls)
    out.append("    private static final long serialVersionUID = 1L;\n\n")
    for prop, java_type, cn in fields:
        out.append("    /** %s */\n" % cn)
        if prop == "id":
            out.append("    @TableId(value = \"id\", type = IdType.AUTO)\n")
        elif prop == "extInfo":
            out.append("    @TableField(exist = false)\n")
        elif prop in ("tenantId", "delFlag", "createTime", "updateTime"):
            out.append("    @TableField(\"%s\")\n" % snake(cap(prop)).lower())
        out.append("    private %s %s;\n\n" % (java_type, prop))
    for prop, java_type, cn in fields:
        p = cap(prop)
        out.append("    public %s get%s() {\n" % (java_type, p))
        out.append("        return %s;\n" % prop)
        out.append("    }\n\n")
        out.append("    public void set%s(%s %s) {\n" % (p, java_type, prop))
        out.append("        this.%s = %s;\n" % (prop, prop))
        out.append("    }\n\n")
    out.append("}\n")
    return "".join(out)


def gen_mp_mapper(cls, cn_name, extra_methods=None):
    pkg = MODULES["cust-center"]
    out = []
    out.append("package %s.mapper;\n\n" % pkg)
    out.append("import %s.entity.%s;\n" % (pkg, cls))
    out.append("import com.baomidou.mybatisplus.core.mapper.BaseMapper;\n")
    if extra_methods:
        out.append("import java.util.List;\n")
        out.append("import org.apache.ibatis.annotations.Param;\n")
    out.append("\n")
    out.append("/**\n")
    out.append(" * %s Mapper（MyBatis-Plus BaseMapper + 少量自定义 SQL）。\n" % cn_name)
    out.append(" */\n")
    out.append("public interface %sMapper extends BaseMapper<%s> {\n" % (cls, cls))
    if extra_methods:
        out.append("\n")
        for sig, comment in extra_methods:
            out.append("    /** %s */\n" % comment)
            out.append("    %s\n\n" % sig)
    out.append("}\n")
    return "".join(out)


def gen_mp_service_interface(cls, cn_name):
    pkg = MODULES["cust-center"]
    out = []
    out.append("package %s.service;\n\n" % pkg)
    out.append("import %s.entity.%s;\n" % (pkg, cls))
    out.append("import com.baomidou.mybatisplus.core.metadata.IPage;\n")
    out.append("import com.baomidou.mybatisplus.extension.plugins.pagination.Page;\n")
    out.append("import java.util.List;\n\n")
    out.append("/**\n")
    out.append(" * %s 服务契约（MyBatis-Plus Wrapper / Page 形态）。\n" % cn_name)
    out.append(" */\n")
    out.append("public interface %sService {\n\n" % cls)
    out.append("    List<%s> listByTenant(Long tenantId);\n\n" % cls)
    out.append("    IPage<%s> pageByCondition(Page<%s> page, Long tenantId, String keyword);\n\n" % (cls, cls))
    out.append("    int updateStatus(Long id, String status);\n\n")
    out.append("    long countByKeyword(Long tenantId, String keyword);\n\n")
    out.append("    %s getOneByCode(Long tenantId, String code);\n\n" % cls)
    out.append("}\n")
    return "".join(out)


def gen_mp_service_impl(cls, keyword_column, code_column):
    pkg = MODULES["cust-center"]
    mapper_var = lower_camel(cls) + "Mapper"
    out = []
    out.append("package %s.service.impl;\n\n" % pkg)
    out.append("import %s.entity.%s;\n" % (pkg, cls))
    out.append("import %s.mapper.%sMapper;\n" % (pkg, cls))
    out.append("import %s.service.%sService;\n" % (pkg, cls))
    out.append("import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;\n")
    out.append("import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;\n")
    out.append("import com.baomidou.mybatisplus.core.metadata.IPage;\n")
    out.append("import com.baomidou.mybatisplus.extension.plugins.pagination.Page;\n")
    out.append("import java.util.Date;\n")
    out.append("import java.util.List;\n\n")
    out.append("/**\n")
    out.append(" * %s 服务实现（Wrapper / Page 压力档）。\n" % cls)
    out.append(" */\n")
    out.append("public class %sServiceImpl implements %sService {\n\n" % (cls, cls))
    out.append("    private final %sMapper %s;\n\n" % (cls, mapper_var))
    out.append("    public %sServiceImpl(%sMapper %s) {\n" % (cls, cls, mapper_var))
    out.append("        this.%s = %s;\n" % (mapper_var, mapper_var))
    out.append("    }\n\n")

    out.append("    public List<%s> listByTenant(Long tenantId) {\n" % cls)
    out.append("        LambdaQueryWrapper<%s> wrapper = new LambdaQueryWrapper<%s>();\n" % (cls, cls))
    out.append("        wrapper.eq(%s::getTenantId, tenantId)\n" % cls)
    out.append("                .eq(%s::getDelFlag, \"0\")\n" % cls)
    out.append("                .orderByDesc(%s::getCreateTime);\n" % cls)
    out.append("        return %s.selectList(wrapper);\n" % mapper_var)
    out.append("    }\n\n")

    out.append("    public IPage<%s> pageByCondition(Page<%s> page, Long tenantId, String keyword) {\n" % (cls, cls))
    out.append("        QueryWrapper<%s> wrapper = new QueryWrapper<%s>();\n" % (cls, cls))
    out.append("        wrapper.eq(\"tenant_id\", tenantId)\n")
    out.append("                .eq(\"del_flag\", \"0\")\n")
    out.append("                .like(\"%s\", keyword)\n" % keyword_column)
    out.append("                .orderByDesc(\"create_time\");\n")
    out.append("        return %s.selectPage(page, wrapper);\n" % mapper_var)
    out.append("    }\n\n")

    out.append("    public int updateStatus(Long id, String status) {\n")
    out.append("        %s entity = new %s();\n" % (cls, cls))
    out.append("        entity.setStatus(status);\n")
    out.append("        entity.setUpdateTime(new Date());\n")
    out.append("        LambdaQueryWrapper<%s> wrapper = new LambdaQueryWrapper<%s>();\n" % (cls, cls))
    out.append("        wrapper.eq(%s::getId, id);\n" % cls)
    out.append("        return %s.update(entity, wrapper);\n" % mapper_var)
    out.append("    }\n\n")

    out.append("    public long countByKeyword(Long tenantId, String keyword) {\n")
    out.append("        QueryWrapper<%s> wrapper = new QueryWrapper<%s>();\n" % (cls, cls))
    out.append("        wrapper.eq(\"tenant_id\", tenantId)\n")
    out.append("                .like(\"%s\", keyword);\n" % keyword_column)
    out.append("        Long total = %s.selectCount(wrapper);\n" % mapper_var)
    out.append("        return total == null ? 0L : total.longValue();\n")
    out.append("    }\n\n")

    out.append("    public %s getOneByCode(Long tenantId, String code) {\n" % cls)
    out.append("        QueryWrapper<%s> wrapper = new QueryWrapper<%s>();\n" % (cls, cls))
    out.append("        wrapper.eq(\"tenant_id\", tenantId)\n")
    out.append("                .eq(\"%s\", code)\n" % code_column)
    out.append("                .last(\"limit 1\");\n")
    out.append("        return %s.selectOne(wrapper);\n" % mapper_var)
    out.append("    }\n\n")
    out.append("}\n")
    return "".join(out)


def gen_mp_controller(cls, cn_name):
    pkg = MODULES["cust-center"]
    out = []
    out.append("package %s.controller;\n\n" % pkg)
    out.append("import cn.song.custcommon.api.ApiResult;\n")
    out.append("import cn.song.custcenter.entity.%s;\n" % cls)
    out.append("import cn.song.custcenter.service.%sService;\n" % cls)
    out.append("import com.baomidou.mybatisplus.core.metadata.IPage;\n")
    out.append("import com.baomidou.mybatisplus.extension.plugins.pagination.Page;\n")
    out.append("import java.util.List;\n\n")
    out.append("/**\n")
    out.append(" * %s 接口层（MyBatis-Plus 服务）。\n" % cn_name)
    out.append(" */\n")
    out.append("public class %sController {\n\n" % cls)
    out.append("    private final %sService %sService;\n\n" % (cls, lower_camel(cls)))
    out.append("    public %sController(%sService %sService) {\n" % (cls, cls, lower_camel(cls)))
    out.append("        this.%sService = %sService;\n" % (lower_camel(cls), lower_camel(cls)))
    out.append("    }\n\n")
    out.append("    public ApiResult<List<%s>> list(Long tenantId) {\n" % cls)
    out.append("        return ApiResult.ok(%sService.listByTenant(tenantId));\n" % lower_camel(cls))
    out.append("    }\n\n")
    out.append("    public ApiResult<IPage<%s>> page(long pageNo, long pageSize, Long tenantId, String keyword) {\n" % cls)
    out.append("        Page<%s> page = new Page<%s>(pageNo, pageSize);\n" % (cls, cls))
    out.append("        return ApiResult.ok(%sService.pageByCondition(page, tenantId, keyword));\n" % lower_camel(cls))
    out.append("    }\n\n")
    out.append("    public ApiResult<Integer> updateStatus(Long id, String status) {\n")
    out.append("        return ApiResult.ok(Integer.valueOf(%sService.updateStatus(id, status)));\n" % lower_camel(cls))
    out.append("    }\n")
    out.append("}\n")
    return "".join(out)


CENTER_XML_USER = """<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.song.custcenter.mapper.UserMapper">
  <select id="selectActiveUsers" resultType="cn.song.custcenter.entity.User">
    select id, tenant_id, user_name, nick_name, mobile_no, email_addr, status, create_time
    from sys_user
    where del_flag = '0'
      and status = '1'
    order by create_time desc
  </select>
</mapper>
"""

CENTER_XML_CUST_INFO = """<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="cn.song.custcenter.mapper.CustInfoMapper">
  <select id="selectTopCustomers" resultType="cn.song.custcenter.entity.CustInfo">
    select id, tenant_id, cust_no, cust_name, cust_type, cert_no, mobile_no, manager_id, status, create_time
    from cust_info
    where del_flag = '0'
      and tenant_id = #{tenantId}
    order by create_time desc
    limit #{limit}
  </select>
</mapper>
"""


def gen_center_module():
    _, java_root, res, pkg = module_roots("cust-center")
    write_file(PROJECT_DIR / "cust-center" / "pom.xml",
               child_pom("cust-center",
                         "    MyBatis-Plus 服务：@TableName 实体、BaseMapper、Wrapper/Page 调用压力。",
                         COMMON_DEP + COMMENTED_MYBATIS_PLUS))

    write_file(res / "application.yml", """server:
  port: 18081

spring:
  application:
    name: cust-center
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/cust_center?useUnicode=true&characterEncoding=utf8
    username: center_reader
    password: center_reader
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis-plus:
  mapper-locations: classpath*:mapper/*.xml
  global-config:
    db-config:
      logic-delete-field: delFlag
      logic-delete-value: 1
      logic-not-delete-value: 0
""")

    write_file(res / "mapper" / "UserMapper.xml", CENTER_XML_USER)
    write_file(res / "mapper" / "CustInfoMapper.xml", CENTER_XML_CUST_INFO)

    for cls, table, cn_name, keyword_prop, keyword_column, code_prop, code_column, extras in CENTER_ENTITIES:
        write_file(pkg / "entity" / ("%s.java" % cls), gen_mp_entity(cls, table, cn_name, extras))
        extra_methods = None
        if cls == "User":
            extra_methods = [("List<User> selectActiveUsers();", "查询启用中的用户（自定义 SQL）")]
        elif cls == "CustInfo":
            extra_methods = [("List<CustInfo> selectTopCustomers(@Param(\"tenantId\") Long tenantId, @Param(\"limit\") Integer limit);",
                              "查询租户下最近的客户（自定义 SQL）")]
        write_file(pkg / "mapper" / ("%sMapper.java" % cls), gen_mp_mapper(cls, cn_name, extra_methods))
        write_file(pkg / "service" / ("%sService.java" % cls), gen_mp_service_interface(cls, cn_name))
        write_file(pkg / "service" / "impl" / ("%sServiceImpl.java" % cls),
                   gen_mp_service_impl(cls, keyword_column, code_column))
        write_file(pkg / "controller" / ("%sController.java" % cls), gen_mp_controller(cls, cn_name))

        write_file(pkg / "vo" / ("%sVO.java" % cls),
                   simple_pojo("cn.song.custcenter.vo", "%sVO" % cls, "%s 视图对象" % cn_name,
                               [(keyword_prop, "String", "关键字"),
                                ("status", "String", "状态"),
                                ("createTime", "Date", "创建时间")],
                               imports=["java.util.Date"]))

    config_templates = [
        ("MybatisPlusConfig", "MyBatis-Plus 插件配置", [
            "    /** 分页插件（示意）。 */",
            "    public Object paginationInterceptor() {",
            "        return new Object();",
            "    }",
        ]),
        ("LogicDeleteConfig", "逻辑删除配置", [
            "    /** 逻辑删除字段。 */",
            "    public String logicDeleteField() {",
            "        return \"delFlag\";",
            "    }",
        ]),
        ("TenantConfig", "租户隔离配置", [
            "    /** 默认租户。 */",
            "    public Long defaultTenantId() {",
            "        return Long.valueOf(1L);",
            "    }",
        ]),
        ("WrapperConfig", "Wrapper 参数上限配置", [
            "    /** like 通配符位置。 */",
            "    public String likePosition() {",
            "        return \"BOTH\";",
            "    }",
        ]),
        ("PageConfig", "分页默认值", [
            "    /** 默认页大小。 */",
            "    public long defaultPageSize() {",
            "        return 20L;",
            "    }",
        ]),
        ("BatchConfig", "批处理配置", [
            "    /** 单批条数。 */",
            "    public int batchSize() {",
            "        return 200;",
            "    }",
        ]),
    ]
    for cls, cn_name, body in config_templates:
        write_file(pkg / "config" / ("%s.java" % cls), (
            "package cn.song.custcenter.config;\n\n"
            "/**\n * %s。\n */\n"
            "public class %s {\n\n%s\n}\n" % (cn_name, cls, "\n".join(body))
        ))


# ---------------------------------------------------------------------------
# cust-gateway
# ---------------------------------------------------------------------------

def gen_gateway_module():
    _, java_root, res, pkg = module_roots("cust-gateway")
    write_file(PROJECT_DIR / "cust-gateway" / "pom.xml",
               child_pom("cust-gateway",
                         "    网关服务：路由注册、鉴权/限流/签名过滤器与代理入口。",
                         COMMON_DEP + COMMENTED_GATEWAY))

    write_file(res / "application.yml", """server:
  port: 18080

spring:
  application:
    name: cust-gateway

gateway:
  routes:
    - id: cust-center
      uri: http://127.0.0.1:18081
      predicates:
        - Path=/api/center/**
    - id: cust-metadata
      uri: http://127.0.0.1:18082
      predicates:
        - Path=/api/metadata/**
  default-timeout: 3000
""")

    write_file(pkg / "filter" / "GatewayFilter.java", '''package cn.song.custgateway.filter;

/**
 * 网关过滤器契约。
 */
public interface GatewayFilter {

    int order();

    boolean accept(String path, String token);
}
''')

    filters = {
        "AuthFilter": ("鉴权过滤器", "public boolean accept(String path, String token) {\n"
                                   "        if (path == null || path.length() == 0) {\n"
                                   "            return false;\n"
                                   "        }\n"
                                   "        if (path.startsWith(\"/public/\")) {\n"
                                   "            return true;\n"
                                   "        }\n"
                                   "        return token != null && token.length() > 8;\n"
                                   "    }", 10),
        "TraceFilter": ("链路追踪过滤器", "public boolean accept(String path, String token) {\n"
                                        "        return path != null && path.startsWith(\"/api/\");\n"
                                        "    }", 20),
        "RateLimitFilter": ("限流过滤器", "public boolean accept(String path, String token) {\n"
                                          "        if (path == null) {\n"
                                          "            return false;\n"
                                          "        }\n"
                                          "        return path.length() < 512;\n"
                                          "    }", 30),
        "SignFilter": ("签名校验过滤器", "public boolean accept(String path, String token) {\n"
                                         "        if (path == null || token == null) {\n"
                                         "            return false;\n"
                                         "        }\n"
                                         "        return token.indexOf('.') > 0;\n"
                                         "    }", 40),
        "LogFilter": ("访问日志过滤器", "public boolean accept(String path, String token) {\n"
                                        "        return true;\n"
                                        "    }", 50),
    }
    for cls, (cn_name, body, order) in filters.items():
        write_file(pkg / "filter" / ("%s.java" % cls), (
            "package cn.song.custgateway.filter;\n\n"
            "/**\n * %s。\n */\n"
            "public class %s implements GatewayFilter {\n\n"
            "    public int order() {\n        return %d;\n    }\n\n"
            "    %s\n}\n" % (cn_name, cls, order, body)
        ))

    write_file(pkg / "route" / "RouteDefinition.java",
               simple_pojo("cn.song.custgateway.route", "RouteDefinition", "路由定义",
                           [("routeId", "String", "路由ID"),
                            ("pathPattern", "String", "路径模式"),
                            ("targetUri", "String", "目标地址"),
                            ("enabled", "Boolean", "是否启用")]))

    write_file(pkg / "route" / "RouteRegistry.java", '''package cn.song.custgateway.route;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 内存路由表。
 */
public class RouteRegistry {

    private final Map<String, RouteDefinition> routes = new LinkedHashMap<String, RouteDefinition>();

    public void register(RouteDefinition definition) {
        if (definition != null && definition.getRouteId() != null) {
            routes.put(definition.getRouteId(), definition);
        }
    }

    public RouteDefinition find(String routeId) {
        return routes.get(routeId);
    }

    public List<RouteDefinition> listAll() {
        return new ArrayList<RouteDefinition>(routes.values());
    }

    public int size() {
        return routes.size();
    }
}
''')

    write_file(pkg / "route" / "RouteMatcher.java", '''package cn.song.custgateway.route;

/**
 * 路径匹配器。
 */
public class RouteMatcher {

    public boolean matches(RouteDefinition definition, String path) {
        if (definition == null || path == null) {
            return false;
        }
        if (!Boolean.TRUE.equals(definition.getEnabled())) {
            return false;
        }
        String pattern = definition.getPathPattern();
        if (pattern == null || pattern.length() == 0) {
            return false;
        }
        if (pattern.endsWith("/**")) {
            return path.startsWith(pattern.substring(0, pattern.length() - 3));
        }
        return pattern.equals(path);
    }
}
''')

    write_file(pkg / "route" / "RouteLocatorImpl.java", '''package cn.song.custgateway.route;

import java.util.ArrayList;
import java.util.List;

/**
 * 路由定位器。
 */
public class RouteLocatorImpl {

    private final RouteRegistry registry;

    private final RouteMatcher matcher = new RouteMatcher();

    public RouteLocatorImpl(RouteRegistry registry) {
        this.registry = registry;
    }

    public RouteDefinition locate(String path) {
        List<RouteDefinition> definitions = registry.listAll();
        for (RouteDefinition definition : definitions) {
            if (matcher.matches(definition, path)) {
                return definition;
            }
        }
        return null;
    }

    public List<String> locateAll(List<String> paths) {
        List<String> result = new ArrayList<String>();
        for (String path : paths) {
            RouteDefinition definition = locate(path);
            if (definition != null) {
                result.add(definition.getRouteId());
            }
        }
        return result;
    }
}
''')

    write_file(pkg / "config" / "GatewayProperties.java", '''package cn.song.custgateway.config;

/**
 * 网关参数。
 */
public class GatewayProperties {

    public static final int DEFAULT_TIMEOUT = 3000;

    public static final int MAX_RETRY = 2;

    public static final int MAX_BODY_SIZE = 1024 * 1024;

    private int timeout = DEFAULT_TIMEOUT;

    private int retry = MAX_RETRY;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }
}
''')

    write_file(pkg / "config" / "CorsProperties.java", '''package cn.song.custgateway.config;

/**
 * 跨域参数。
 */
public class CorsProperties {

    private String allowedOrigin = "*";

    private String allowedMethod = "GET,POST,PUT,DELETE,OPTIONS";

    public String getAllowedOrigin() {
        return allowedOrigin;
    }

    public void setAllowedOrigin(String allowedOrigin) {
        this.allowedOrigin = allowedOrigin;
    }

    public String getAllowedMethod() {
        return allowedMethod;
    }

    public void setAllowedMethod(String allowedMethod) {
        this.allowedMethod = allowedMethod;
    }
}
''')

    write_file(pkg / "config" / "TimeoutProperties.java", '''package cn.song.custgateway.config;

/**
 * 超时参数。
 */
public class TimeoutProperties {

    private int connectTimeout = 1000;

    private int readTimeout = 3000;

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
}
''')

    write_file(pkg / "dto" / "ProxyRequest.java",
               simple_pojo("cn.song.custgateway.dto", "ProxyRequest", "代理请求",
                           [("method", "String", "HTTP 方法"),
                            ("path", "String", "请求路径"),
                            ("token", "String", "访问令牌"),
                            ("body", "String", "请求体")]))

    write_file(pkg / "dto" / "ProxyResponse.java",
               simple_pojo("cn.song.custgateway.dto", "ProxyResponse", "代理响应",
                           [("status", "Integer", "状态码"),
                            ("body", "String", "响应体"),
                            ("costMillis", "Long", "耗时毫秒")]))

    write_file(pkg / "dto" / "RouteView.java",
               simple_pojo("cn.song.custgateway.dto", "RouteView", "路由视图",
                           [("routeId", "String", "路由ID"),
                            ("pathPattern", "String", "路径模式"),
                            ("targetUri", "String", "目标地址")]))

    write_file(pkg / "util" / "SignUtils.java", '''package cn.song.custgateway.util;

/**
 * 签名工具。
 */
public final class SignUtils {

    private SignUtils() {
    }

    public static String sign(String appId, String timestamp, String secret) {
        String raw = String.valueOf(appId) + "|" + String.valueOf(timestamp) + "|" + String.valueOf(secret);
        return Integer.toHexString(raw.hashCode());
    }

    public static boolean verify(String appId, String timestamp, String secret, String sign) {
        return sign(appId, timestamp, secret).equals(sign);
    }
}
''')

    write_file(pkg / "util" / "UrlUtils.java", '''package cn.song.custgateway.util;

/**
 * URL 工具。
 */
public final class UrlUtils {

    private UrlUtils() {
    }

    public static String join(String base, String path) {
        if (base == null) {
            return path;
        }
        if (path == null) {
            return base;
        }
        if (base.endsWith("/") && path.startsWith("/")) {
            return base + path.substring(1);
        }
        if (!base.endsWith("/") && !path.startsWith("/")) {
            return base + "/" + path;
        }
        return base + path;
    }

    public static String pathOf(String url) {
        if (url == null) {
            return "";
        }
        int index = url.indexOf("://");
        if (index < 0) {
            return url;
        }
        int slash = url.indexOf('/', index + 3);
        return slash < 0 ? "/" : url.substring(slash);
    }
}
''')

    write_file(pkg / "util" / "IpUtils.java", '''package cn.song.custgateway.util;

/**
 * IP 工具。
 */
public final class IpUtils {

    private IpUtils() {
    }

    public static boolean isInternal(String ip) {
        if (ip == null) {
            return false;
        }
        return ip.startsWith("127.")
                || ip.startsWith("10.")
                || ip.startsWith("192.168.")
                || ip.startsWith("172.16.");
    }

    public static String normalize(String forwardedFor) {
        if (forwardedFor == null) {
            return "";
        }
        int comma = forwardedFor.indexOf(',');
        return comma < 0 ? forwardedFor.trim() : forwardedFor.substring(0, comma).trim();
    }
}
''')

    write_file(pkg / "handler" / "FallbackHandler.java", '''package cn.song.custgateway.handler;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcommon.constant.ErrorCode;

/**
 * 降级处理器。
 */
public class FallbackHandler {

    public ApiResult<String> fallback(String routeId) {
        return ApiResult.fail(ErrorCode.SYSTEM_ERROR, "route " + routeId + " is unavailable");
    }
}
''')

    write_file(pkg / "handler" / "GlobalExceptionHandler.java", '''package cn.song.custgateway.handler;

import cn.song.custcommon.api.ApiResult;
import cn.song.custcommon.constant.ErrorCode;

/**
 * 全局异常处理。
 */
public class GlobalExceptionHandler {

    public ApiResult<String> handle(Throwable error) {
        if (error == null) {
            return ApiResult.fail(ErrorCode.SYSTEM_ERROR, "unknown error");
        }
        return ApiResult.fail(ErrorCode.SYSTEM_ERROR, error.getMessage());
    }
}
''')

    write_file(pkg / "controller" / "GatewayProxyController.java", '''package cn.song.custgateway.controller;

import cn.song.custcommon.api.ApiResult;
import cn.song.custgateway.dto.ProxyRequest;
import cn.song.custgateway.dto.ProxyResponse;
import cn.song.custgateway.filter.GatewayFilter;
import cn.song.custgateway.route.RouteDefinition;
import cn.song.custgateway.route.RouteLocatorImpl;
import java.util.List;

/**
 * 网关代理入口。
 */
public class GatewayProxyController {

    private final RouteLocatorImpl routeLocator;

    private final List<GatewayFilter> filters;

    public GatewayProxyController(RouteLocatorImpl routeLocator, List<GatewayFilter> filters) {
        this.routeLocator = routeLocator;
        this.filters = filters;
    }

    public ApiResult<ProxyResponse> proxy(ProxyRequest request) {
        RouteDefinition definition = routeLocator.locate(request.getPath());
        if (definition == null) {
            return ApiResult.fail(404, "route not found");
        }
        for (GatewayFilter filter : filters) {
            if (!filter.accept(request.getPath(), request.getToken())) {
                return ApiResult.fail(403, "blocked by " + filter.getClass().getSimpleName());
            }
        }
        ProxyResponse response = new ProxyResponse();
        response.setStatus(Integer.valueOf(200));
        response.setBody(definition.getTargetUri());
        response.setCostMillis(Long.valueOf(0L));
        return ApiResult.ok(response);
    }
}
''')


# ---------------------------------------------------------------------------
# cust-metadata（原生 MyBatis 主战场）
# ---------------------------------------------------------------------------

METADATA_EXTRA_USER = '''package cn.song.custmetadata.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台登录用户实体（与 cust-center 的 User 同名，用于短名解析歧义复现）。
 *
 * <p>本类只作为跨模块同名类存在，不参与 MBG 三件套统计。
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String userName;

    private String nickName;

    private String mobileNo;

    private String emailAddr;

    private String status;

    private Long tenantId;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
'''

METADATA_APPLICATION_YML = """server:
  port: 18082

spring:
  application:
    name: cust-metadata
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/cust_metadata?useUnicode=true&characterEncoding=utf8
    username: cust_reader
    password: cust_reader
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis:
  mapper-locations: classpath*:mapper/*.xml
  configuration:
    map-underscore-to-camel-case: true
    default-statement-timeout: 30
"""

METADATA_LOGBACK_XML = """<?xml version="1.0" encoding="UTF-8"?>
<configuration>
  <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
      <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
    </encoder>
  </appender>

  <logger name="cn.song.custmetadata.mapper" level="DEBUG" />

  <root level="INFO">
    <appender-ref ref="CONSOLE" />
  </root>
</configuration>
"""


# ---------------------------------------------------------------------------
# 填充类配置
# ---------------------------------------------------------------------------

DTO_SUFFIXES = ["DTO", "SummaryDTO", "DetailDTO", "PageDTO", "ExportDTO", "ImportDTO", "OptionDTO"]
CONVERTER_SUFFIXES = ["Converter", "BeanConverter", "Assembler", "ViewAssembler", "SnapshotConverter"]
UTIL_SUFFIXES = ["Codec", "Formatter", "Checker", "Helper"]
CONFIG_SUFFIXES = ["ModuleConfig", "CacheConfig", "JobConfig"]
BO_SUFFIXES = ["QueryBO", "SaveBO", "UpdateBO"]
VALIDATOR_SUFFIXES = ["Validator", "ImportValidator", "ExportValidator"]

DTO_FIELD_COUNT = 60
BO_FIELD_COUNT = 50
CONVERTER_METHOD_COUNT = 35
UTIL_METHOD_COUNT = 40
CONFIG_CONSTANT_COUNT = 60
CONFIG_METHOD_COUNT = 20
VALIDATOR_METHOD_COUNT = 30


def gen_metadata_module():
    write_file(MODULE_DIR / "pom.xml",
               child_pom("cust-metadata",
                         "    原生 MyBatis 服务（MBG 生成风格）：40 套三件套 + selectByExample 调用点压力，\n"
                         "    是 SQL Visualizer 性能复现的主战场。",
                         COMMON_DEP + COMMENTED_MYBATIS))

    write_file(RES_ROOT / "application.yml", METADATA_APPLICATION_YML)
    write_file(RES_ROOT / "logback-spring.xml", METADATA_LOGBACK_XML)

    # 40 套三件套 + XML
    for index, (table, cn_name) in enumerate(TABLE_DEFS):
        cls = camel(table)
        cols = columns_for(index)
        write_file(PKG_ROOT / "entity" / ("%s.java" % cls),
                   gen_entity(cls, table, cn_name, cols))
        write_file(PKG_ROOT / "example" / ("%sExample.java" % cls),
                   gen_example(cls, table, cn_name, cols))
        write_file(PKG_ROOT / "mapper" / ("%sMapper.java" % cls),
                   gen_mapper(cls, table, cn_name))
        write_file(RES_ROOT / "mapper" / ("%sMapper.xml" % cls),
                   gen_mapper_xml(cls, table, cn_name, cols))

    # 跨模块同名类：metadata 侧 User
    write_file(PKG_ROOT / "entity" / "User.java", METADATA_EXTRA_USER)

    # Service 接口 + 基础实现 + 热点压力实现 + Controller
    for index, (table, cn_name) in enumerate(TABLE_DEFS):
        cls = camel(table)
        write_file(PKG_ROOT / "service" / ("%sQueryService.java" % cls),
                   gen_service_interface(cls, cn_name))
        write_file(PKG_ROOT / "service" / "impl" / ("%sQueryServiceImpl.java" % cls),
                   gen_service_impl(cls, cn_name, with_extra=False))
        write_file(PKG_ROOT / "controller" / ("%sController.java" % cls),
                   gen_controller(cls, cn_name))

        if index < HOT_TABLE_COUNT:
            for variant in ("Page", "Search", "Export", "Sync"):
                write_file(
                    PKG_ROOT / "service" / "impl" / ("%s%sQueryServiceImpl.java" % (cls, variant)),
                    gen_service_impl(cls, cn_name, with_extra=True, variant=variant)
                )

    # 填充类
    start = 0
    for index, (table, cn_name) in enumerate(TABLE_DEFS):
        cls = camel(table)
        for suffix in DTO_SUFFIXES:
            fields = take_slice(ATTRIBUTE_POOL, (index * 13 + start) % len(ATTRIBUTE_POOL), DTO_FIELD_COUNT)
            write_file(PKG_ROOT / "dto" / ("%s%s.java" % (cls, suffix)),
                       gen_dto("%s%s" % (cls, suffix), "%s%s" % (cn_name, suffix), fields))
            start += 7

    start = 0
    for index, (table, cn_name) in enumerate(TABLE_DEFS):
        cls = camel(table)
        for suffix in BO_SUFFIXES:
            fields = take_slice(ATTRIBUTE_POOL, (index * 17 + start) % len(ATTRIBUTE_POOL), BO_FIELD_COUNT)
            write_file(PKG_ROOT / "bo" / ("%s%s.java" % (cls, suffix)),
                       gen_bo("%s%s" % (cls, suffix), "%s%s" % (cn_name, suffix), fields))
            start += 5

    start = 0
    for index, (table, cn_name) in enumerate(TABLE_DEFS):
        cls = camel(table)
        for suffix in CONVERTER_SUFFIXES:
            items = take_slice(ATTRIBUTE_POOL, (index * 11 + start) % len(ATTRIBUTE_POOL),
                               CONVERTER_METHOD_COUNT)
            write_file(PKG_ROOT / "convert" / ("%s%s.java" % (cls, suffix)),
                       gen_converter("%s%s" % (cls, suffix), "%s%s" % (cn_name, suffix), items))
            start += 3

    util_pool = []
    for verb, cn_verb in UTIL_VERBS:
        for prop, java_type, cn in ATTRIBUTE_POOL:
            util_pool.append((verb, cn_verb, prop, java_type, cn))

    start = 0
    for index, (table, cn_name) in enumerate(TABLE_DEFS):
        cls = camel(table)
        for suffix in UTIL_SUFFIXES:
            items = take_slice(util_pool, (index * 7 + start) % len(util_pool), UTIL_METHOD_COUNT)
            write_file(PKG_ROOT / "util" / ("%s%s.java" % (cls, suffix)),
                       gen_util("%s%s" % (cls, suffix), "%s%s" % (cn_name, suffix), items))
            start += 11

    config_pool = []
    for prefix, cn_prefix in CONFIG_PREFIXES:
        for prop, java_type, cn in ATTRIBUTE_POOL:
            config_pool.append((prefix, cn_prefix, prop, cn))

    start = 0
    for index, (table, cn_name) in enumerate(TABLE_DEFS):
        cls = camel(table)
        for suffix in CONFIG_SUFFIXES:
            chunk = take_slice(config_pool, (index * 19 + start) % len(config_pool), CONFIG_CONSTANT_COUNT)
            constants = []
            for j, (prefix, cn_prefix, prop, cn) in enumerate(chunk):
                const_name = "%s_%s" % (prefix, snake(cap(prop)))
                constants.append((const_name, (j + 1) * 5, "%s（%s）" % (cn_prefix, cn)))
            methods = [(constants[j % len(constants)][0], constants[j % len(constants)][2])
                       for j in range(CONFIG_METHOD_COUNT)]
            write_file(PKG_ROOT / "config" / ("%s%s.java" % (cls, suffix)),
                       gen_config("%s%s" % (cls, suffix), "%s%s" % (cn_name, suffix),
                                  constants, methods))
            start += 13

    start = 0
    for index, (table, cn_name) in enumerate(TABLE_DEFS):
        cls = camel(table)
        for suffix in VALIDATOR_SUFFIXES:
            fields = take_slice(ATTRIBUTE_POOL, (index * 23 + start) % len(ATTRIBUTE_POOL),
                                VALIDATOR_METHOD_COUNT)
            write_file(PKG_ROOT / "validator" / ("%s%s.java" % (cls, suffix)),
                       gen_validator("%s%s" % (cls, suffix), "%s%s" % (cn_name, suffix), fields))
            start += 9


# ---------------------------------------------------------------------------
# 主流程
# ---------------------------------------------------------------------------

def generate():
    reset_project()
    write_file(PROJECT_DIR / "pom.xml", AGGREGATOR_POM)
    gen_common_module()
    gen_metadata_module()
    gen_center_module()
    gen_gateway_module()


# ---------------------------------------------------------------------------
# 自检与读数
# ---------------------------------------------------------------------------

def read_module_stats(name):
    src = PROJECT_DIR / name / "src"
    files = [p for p in src.rglob("*") if p.is_file()] if src.exists() else []
    size = sum(p.stat().st_size for p in files)
    return len(files), size


def summarize():
    print("")
    print("工程目录 : %s" % PROJECT_DIR)
    print("")
    print("各子模块 src 读数：")
    stats = {}
    for name in ("cust-common", "cust-center", "cust-metadata", "cust-gateway"):
        count, size = read_module_stats(name)
        stats[name] = (count, size)
        print("  %-14s files=%5d  bytes=%9d  (%.2f MB)" % (name, count, size, size / 1024.0 / 1024.0))

    meta_files, meta_size = stats["cust-metadata"]
    print("")
    print("cust-metadata 三件套: %d 套" % len(TABLE_DEFS))

    per_mapper = {}
    total_calls = 0
    for path in (PKG_ROOT / "service").rglob("*.java"):
        text = path.read_text(encoding="utf-8")
        for match in re.finditer(r"(\w+Mapper)\.selectByExample\(", text):
            key = match.group(1)
            per_mapper[key] = per_mapper.get(key, 0) + 1
            total_calls += 1
    hot = dict((k, v) for k, v in per_mapper.items() if v >= 200)

    print("selectByExample 调用点总数: %d" % total_calls)
    print("其中 >= 200 的方法:")
    for key in sorted(hot):
        print("  %-28s %d" % (key, hot[key]))

    center_wrappers = 0
    center_table_names = 0
    center_java = PROJECT_DIR / "cust-center" / "src" / "main" / "java"
    for path in center_java.rglob("*.java"):
        text = path.read_text(encoding="utf-8")
        center_wrappers += len(re.findall(r"new (?:QueryWrapper|LambdaQueryWrapper)<", text))
        center_table_names += len(re.findall(r"@TableName\(", text))
    print("")
    print("cust-center Wrapper 调用点: %d" % center_wrappers)
    print("cust-center @TableName 实体 : %d" % center_table_names)

    class_map = {}
    for name in MODULES:
        java_root = PROJECT_DIR / name / "src" / "main" / "java"
        if not java_root.exists():
            continue
        for path in java_root.rglob("*.java"):
            class_map.setdefault(path.stem, set()).add(name)
    duplicates = dict((k, v) for k, v in class_map.items() if len(v) > 1)
    print("")
    print("跨模块同名类（模块 -> 类名）：")
    for stem in sorted(duplicates):
        print("  %-26s %s" % (stem, ", ".join(sorted(duplicates[stem]))))

    ok = True
    if meta_files < 800:
        print("!! cust-metadata 文件数未达标（< 800）")
        ok = False
    if meta_size < 15 * 1024 * 1024:
        print("!! cust-metadata 体积未达标（< 15 MB）")
        ok = False
    if len(TABLE_DEFS) < 40:
        print("!! 三件套不足 40 套")
        ok = False
    if total_calls < 1000:
        print("!! 调用点总数不足 1000")
        ok = False
    if len(hot) < 5:
        print("!! 调用点 >= 200 的 selectByExample 方法不足 5 个")
        ok = False
    if center_wrappers < 30:
        print("!! cust-center Wrapper 调用点不足 30")
        ok = False
    if center_table_names < 10:
        print("!! cust-center @TableName 实体不足 10")
        ok = False
    if len(duplicates) < 2:
        print("!! 跨模块同名类组数不足 2")
        ok = False

    print("")
    print("判定      : %s" % ("PASS" if ok else "FAIL"))
    return 0 if ok else 1


def main():
    generate()
    return summarize()


if __name__ == "__main__":
    sys.exit(main())

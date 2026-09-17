-- =============================================================
-- mybatis-plus-join-demo 初始化脚本（MPJ 多表联查用例数据）——达梦 DM8 版
-- 对应 MySQL 版：db/schema.sql（表结构、初始数据与其完全一致）
--
-- 适配实例参数：CASE_SENSITIVE=0（大小写不敏感）、LENGTH_IN_CHAR=1、COMPATIBLE_MODE=0
-- 与 MySQL 版的差异：
--   1. user 是达梦保留字，所有引用处统一写作 "user"（双引号）；
--      应用侧实体 @TableName("\"user\"")，MySQL 侧由 jdbc url 的
--      sessionVariables=sql_mode=ANSI_QUOTES 保证双引号同样按标识符解析
--   2. AUTO_INCREMENT 改 IDENTITY(1,1)，初始数据用 SET IDENTITY_INSERT 包裹
--   3. 无 ENGINE/USE 语句；列注释改 COMMENT ON；
--      达梦索引名在模式内全局唯一，两表的 idx_station_id 改为
--      idx_cdi_station_id / idx_si_station_id
--   4. 建用户（以 SYSDBA/DBA 执行，仅首次需要）：
--        CREATE USER MPJ_DEMO IDENTIFIED BY "Mpj_demo_2026";
--        GRANT RESOURCE TO MPJ_DEMO;
--        GRANT UNLIMITED TABLESPACE TO MPJ_DEMO;
--   5. 应用连接串：jdbc:dm://<host>:<port>?schema=MPJ_DEMO
--
-- 执行：以 MPJ_DEMO 登录后整体执行；或以 DBA 登录先执行 SET SCHEMA MPJ_DEMO
-- =============================================================

SET SCHEMA MPJ_DEMO;

DROP TABLE IF EXISTS car_device_info;
DROP TABLE IF EXISTS station_info;
DROP TABLE IF EXISTS user_address;
DROP TABLE IF EXISTS area;
DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS user_2026;

-- 用户表（MPJ 主表）
CREATE TABLE "user" (
    id       INT IDENTITY(1,1) NOT NULL,
    name     VARCHAR(64)  NOT NULL,
    age      INT          DEFAULT NULL,
    sex      TINYINT      DEFAULT 1,
    head_img VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id)
);
COMMENT ON TABLE "user" IS '用户表';
COMMENT ON COLUMN "user".id IS '主键';
COMMENT ON COLUMN "user".name IS '姓名';
COMMENT ON COLUMN "user".age IS '年龄';
COMMENT ON COLUMN "user".sex IS '性别（1男 2女）';
COMMENT ON COLUMN "user".head_img IS '头像';

-- 用户表 2026（setTableName 动态表名演示：/mpj/user/page 使用 setTableName(name -> name + "_2026")）
CREATE TABLE user_2026 (
    id       INT IDENTITY(1,1) NOT NULL,
    name     VARCHAR(64)  NOT NULL,
    age      INT          DEFAULT NULL,
    sex      TINYINT      DEFAULT 1,
    head_img VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id)
);
COMMENT ON TABLE user_2026 IS '用户表2026';
COMMENT ON COLUMN user_2026.id IS '主键';
COMMENT ON COLUMN user_2026.name IS '姓名';
COMMENT ON COLUMN user_2026.age IS '年龄';
COMMENT ON COLUMN user_2026.sex IS '性别（1男 2女）';
COMMENT ON COLUMN user_2026.head_img IS '头像';

-- 用户地址表（MPJ 关联表 user_address）
CREATE TABLE user_address (
    id      INT IDENTITY(1,1) NOT NULL,
    user_id INT NOT NULL,
    tel     VARCHAR(32)  DEFAULT NULL,
    address VARCHAR(255) DEFAULT NULL,
    area_id INT          DEFAULT NULL,
    status  TINYINT      DEFAULT 1,
    PRIMARY KEY (id)
);
CREATE INDEX idx_user_id ON user_address (user_id);
CREATE INDEX idx_area_id ON user_address (area_id);
COMMENT ON TABLE user_address IS '用户地址表';
COMMENT ON COLUMN user_address.id IS '主键';
COMMENT ON COLUMN user_address.user_id IS '用户ID';
COMMENT ON COLUMN user_address.tel IS '电话';
COMMENT ON COLUMN user_address.address IS '详细地址';
COMMENT ON COLUMN user_address.area_id IS '地区ID';
COMMENT ON COLUMN user_address.status IS '状态（0禁用 1启用）';

-- 地区表（MPJ 三级关联表）
CREATE TABLE area (
    id       INT IDENTITY(1,1) NOT NULL,
    province VARCHAR(32) DEFAULT NULL,
    city     VARCHAR(32) DEFAULT NULL,
    PRIMARY KEY (id)
);
COMMENT ON TABLE area IS '地区表';
COMMENT ON COLUMN area.id IS '主键';
COMMENT ON COLUMN area.province IS '省份';
COMMENT ON COLUMN area.city IS '城市';

-- 设备信息表（对齐插件测试 car_device_info）
CREATE TABLE car_device_info (
    id              INT IDENTITY(1,1) NOT NULL,
    station_id      INT         DEFAULT NULL,
    share_scheme_id INT         DEFAULT NULL,
    device_name     VARCHAR(64) DEFAULT NULL,
    PRIMARY KEY (id)
);
CREATE INDEX idx_cdi_station_id ON car_device_info (station_id);
COMMENT ON TABLE car_device_info IS '设备信息表';
COMMENT ON COLUMN car_device_info.id IS '主键';
COMMENT ON COLUMN car_device_info.station_id IS '站点ID';
COMMENT ON COLUMN car_device_info.share_scheme_id IS '共享方案ID';
COMMENT ON COLUMN car_device_info.device_name IS '设备名称';

-- 站点信息表（对齐插件测试 station_info）
CREATE TABLE station_info (
    id           INT IDENTITY(1,1) NOT NULL,
    station_id   INT         DEFAULT NULL,
    station_name VARCHAR(64) DEFAULT NULL,
    merchant_id  INT         DEFAULT NULL,
    PRIMARY KEY (id)
);
CREATE INDEX idx_si_station_id ON station_info (station_id);
COMMENT ON TABLE station_info IS '站点信息表';
COMMENT ON COLUMN station_info.id IS '主键';
COMMENT ON COLUMN station_info.station_id IS '站点编码ID';
COMMENT ON COLUMN station_info.station_name IS '站点名称';
COMMENT ON COLUMN station_info.merchant_id IS '商户ID';

-- 初始数据（与 MySQL 版 schema.sql 完全一致）
SET IDENTITY_INSERT "user" ON;
INSERT INTO "user" (id, name, age, sex, head_img) VALUES
(1, '张三', 20, 1, 'img/zhangsan.png'),
(2, '李四', 25, 1, 'img/lisi.png'),
(3, '王五', 30, 2, 'img/wangwu.png');
SET IDENTITY_INSERT "user" OFF;

SET IDENTITY_INSERT user_2026 ON;
INSERT INTO user_2026 (id, name, age, sex, head_img) VALUES
(1, '张三', 20, 1, 'img/zhangsan.png'),
(2, '李四', 25, 1, 'img/lisi.png'),
(3, '王五', 30, 2, 'img/wangwu.png');
SET IDENTITY_INSERT user_2026 OFF;

SET IDENTITY_INSERT area ON;
INSERT INTO area (id, province, city) VALUES
(1, '浙江省', '杭州市'),
(2, '浙江省', '宁波市'),
(3, '江苏省', '南京市');
SET IDENTITY_INSERT area OFF;

SET IDENTITY_INSERT user_address ON;
INSERT INTO user_address (id, user_id, tel, address, area_id, status) VALUES
(1, 1, '13800000001', '西湖区文一西路100号', 1, 1),
(2, 1, '13800000002', '滨江区江南大道200号', 1, 1),
(3, 2, '13900000003', '鄞州区天童南路300号', 2, 1),
(4, 3, '13700000004', '鼓楼区中山北路400号', 3, 0);
SET IDENTITY_INSERT user_address OFF;

SET IDENTITY_INSERT station_info ON;
INSERT INTO station_info (id, station_id, station_name, merchant_id) VALUES
(1, 101, '中心站', 1001),
(2, 102, '东站', 1002),
(3, 103, '西站', 1001);
SET IDENTITY_INSERT station_info OFF;

SET IDENTITY_INSERT car_device_info ON;
INSERT INTO car_device_info (id, station_id, share_scheme_id, device_name) VALUES
(1, 101, 1, '充电桩A-01'),
(2, 101, 1, '充电桩A-02'),
(3, 102, 2, '换电柜B-01'),
(4, 103, 3, '充电桩C-01');
SET IDENTITY_INSERT car_device_info OFF;

-- 自增计数器校准：显式主键插入后各补一条再删，
-- 确保后续应用侧 INSERT（IdType.AUTO）从 max+1 起增，不撞主键
INSERT INTO "user" (name) VALUES ('seq_fix');
DELETE FROM "user" WHERE name = 'seq_fix';
INSERT INTO user_2026 (name) VALUES ('seq_fix');
DELETE FROM user_2026 WHERE name = 'seq_fix';
INSERT INTO area (province) VALUES ('seq_fix');
DELETE FROM area WHERE province = 'seq_fix';
INSERT INTO user_address (user_id) VALUES (0);
DELETE FROM user_address WHERE user_id = 0;
INSERT INTO station_info (station_id) VALUES (0);
DELETE FROM station_info WHERE station_id = 0;
INSERT INTO car_device_info (station_id) VALUES (0);
DELETE FROM car_device_info WHERE station_id = 0;

###################################################企业#######################################################
-- 企业用户表
CREATE TABLE `firm`
(
    `id`           INT         NOT NULL AUTO_INCREMENT COMMENT '企业用户id（主键）',
    `username`     VARCHAR(64) NOT NULL COMMENT '企业用户名',
    `password`     VARCHAR(64) NOT NULL COMMENT '企业用户密码',
    `phone_number` VARCHAR(32)          DEFAULT NULL COMMENT '企业用户手机号',
    `create_time`  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`     INT(11)              DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='企业用户表';

-- 公司表
CREATE TABLE `company`
(
    `id`          INT         NOT NULL AUTO_INCREMENT COMMENT '公司id（主键）',
    `name`        VARCHAR(64) NOT NULL COMMENT '公司名称',
    `address`     TEXT        NOT NULL COMMENT '公司地址',
    `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`    INT(11)              DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='公司表';

-- 企业用户-公司关联表
CREATE TABLE `firm_company_relation`
(
    `id`          INT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `firm_id`     INT       NOT NULL COMMENT '企业用户id',
    `company_id`  INT       NOT NULL COMMENT '公司id',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`    INT(11)            DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='企业用户-公司关联表';

-- 场所表
CREATE TABLE `region`
(
    `id`          INT       NOT NULL AUTO_INCREMENT COMMENT '区域id（主键）',
    `name`        VARCHAR(64) COMMENT '区域名称',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`    INT(11)            DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='场所表';

-- 场所-公司关联表
CREATE TABLE `region_company_relation`
(
    `id`          INT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `region_id`   INT       NOT NULL COMMENT '场所id',
    `company_id`  INT       NOT NULL COMMENT '公司id',
    `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`    INT(11)            DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='场所-公司关联表';

-- 角色表
CREATE TABLE `role`
(
    `id`          INT         NOT NULL AUTO_INCREMENT COMMENT '角色id（主键）',
    `role_name`   VARCHAR(32) NOT NULL COMMENT '角色名称',
    `remark`      VARCHAR(32)          DEFAULT NULL COMMENT '备注',
    `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`    INT(11)              DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='角色表';

-- 场所普通用户表
CREATE TABLE `firm_user`
(
    `id`           INT         NOT NULL AUTO_INCREMENT COMMENT '用户id（主键）',
    `account`      VARCHAR(32) NOT NULL COMMENT '账号',
    `password`     VARCHAR(64) NOT NULL COMMENT '密码',
    `phone_number` VARCHAR(32)          DEFAULT NULL COMMENT '手机号',
    `create_time`  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`     INT(11)              DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='场所普通用户表';

-- 用户角色关联表
CREATE TABLE `firm_user_role_relation`
(
    `id`           INT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `firm_user_id` INT       NOT NULL COMMENT '用户id',
    `role_id`      INT       NOT NULL COMMENT '角色id',
    `create_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`     INT(11)            DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户角色关联表';

################################################################################
#               功能池（菜单|权限）相关表
################################################################################

CREATE TABLE `permission`
(
    `id`          INT         NOT NULL AUTO_INCREMENT COMMENT '权限id（主键）',
    `name`        VARCHAR(32) NOT NULL COMMENT '权限名称',
    `remark`      VARCHAR(64)          DEFAULT NULL COMMENT '权限备注',
    `firm_flag`   INT(11)              DEFAULT '0' COMMENT '企业是否可用（0-是，1-否）',
    `gov_flag`    INT(11)              DEFAULT '0' COMMENT '政府是否可用（0-是，1-否）',
    `hm_flag`     INT(11)              DEFAULT '0' COMMENT '宏茂是否可用（0-是，1-否）',
    `pay_flag`    INT(11)              DEFAULT '0' COMMENT '是否属于增值功能（0-是，1-否）',
    `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`    INT(11)              DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='权限表';


-- 场所-权限关联表（针对非收费权限）
CREATE TABLE `region_permission_relation`
(
    `id`            INT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `region_id`     INT       NOT NULL COMMENT '场所id',
    `permission_id` INT       NOT NULL COMMENT '权限id',
    `create_time`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`      INT(11)            DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='场所-权限关联表';

-- 场所-权限关联表（针对收费权限）
-- 场所购买收费权限后，会往这张表里插入数据）（感觉没必要建这张表）
CREATE TABLE `region_permission_pay_relation`
(
    `id`            INT       NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `region_id`     INT       NOT NULL COMMENT '场所id',
    `permission_id` INT       NOT NULL COMMENT '权限id',
    `create_time`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`      INT(11)            DEFAULT '0' COMMENT '删除标志（0代表未删除，1代表已删除）',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 COMMENT ='场所-权限关联表（针对收费权限）';

#############################################################################################################
/*
 * 为了方便, 只创建了一个数据库
 */
CREATE DATABASE `seatadb` DEFAULT CHARACTER SET utf8mb4;

# seata所需表(涉及的应用数据库都要新建该表)
CREATE TABLE `undo_log`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint       NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int          NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB;

# 业务数据表
DROP TABLE IF EXISTS `order_tbl`;
CREATE TABLE `order_tbl`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `user_id`        varchar(255) DEFAULT NULL,
    `commodity_code` varchar(255) DEFAULT NULL,
    `count`          int          DEFAULT 0,
    `money`          int          DEFAULT 0,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `storage_tbl`;
CREATE TABLE `storage_tbl`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `commodity_code` varchar(255) DEFAULT NULL,
    `count`          int          DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`commodity_code`)
) ENGINE = InnoDB;
INSERT INTO seatadb.storage_tbl(id, commodity_code, count) VALUES(1, '123456', 100);

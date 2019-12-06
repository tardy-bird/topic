use oomall;
-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`
(
    `id`           bigint(11) unsigned NOT NULL AUTO_INCREMENT,
    `gmt_create`   datetime(2)         DEFAULT NULL,
    `gmt_modified` datetime(2)         DEFAULT NULL,
    `is_deleted`   tinyint(1) unsigned DEFAULT '0',
    `pic_url_list` varchar(5000)       DEFAULT NULL,
    `content`      varchar(255)        DEFAULT NULL,
    PRIMARY KEY (`id`)
);

insert into topic(gmt_create, gmt_modified, is_deleted, pic_url_list, content)
VALUES (now(), now(), false, 'https://www.seriouseats.com/images/20100414-ph-macarons.jpg', 'This is content.');
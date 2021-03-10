drop database if exists `anchor_blog`;
create database `anchor_blog` character set utf8mb4;

use `anchor_blog`;

drop table if exists `t_type`;
create table `t_type` (
    `id` bigint not null auto_increment comment '类型ID',
    `name` varchar(255) null comment '类型名',
    primary key (`id`) using btree
) comment='类型';

drop table if exists `t_tag`;
create table `t_tag` (
    `id` bigint not null auto_increment comment '标签ID',
    `name` varchar(255) null comment '标签名',
    primary key (`id`) using btree
) comment='标签';

drop table if exists `t_blog_tags`;
create table `t_blog_tags` (
    `id` bigint not null auto_increment comment '关联ID',
    `blog_id` bigint not null comment '博客ID',
    `tag_id` bigint not null comment '标签ID',
    primary key (`id`) using btree
) comment='博客与标签关联';

drop table if exists `t_comment`;
create table `t_comment` (
    `id` bigint not null auto_increment comment '评论ID',
    `nickname` varchar(255) null comment '昵称',
    `email` varchar(255) null  comment '邮箱',
    `content` varchar(255) null  comment '评论内容',
    `avatar` varchar(255) null comment '头像地址',
    `create_time` timestamp null comment '创建时间',
    `blog_id` bigint not null comment '博客ID',
    `parent_comment_id` bigint null comment '父评论',
    `author` bit not null comment '是作者',
    primary key (`id`) using btree
) comment='评论';

drop table if exists `t_user`;
create table `t_user` (
    `id` bigint not null auto_increment comment '用户ID',
    `nickname` varchar(255) not null comment '昵称',
    `username` varchar(255) unique not null comment '用户名',
    `password` varchar(255) not null comment '密码',
    `email` varchar(255) not null comment '邮箱',
    `avatar` varchar(255) null comment '头像地址',
    `type` int not null default 0 comment '用户类型',
    `salt` varchar(255) not null comment '加密盐值',
    `create_time` timestamp null comment '创建时间',
    `update_time` timestamp null comment '修改时间',
    primary key (`id`) using btree
) comment='用户';

drop table if exists `t_blog`;
create table `t_blog` (
    `id` bigint not null auto_increment comment '博客ID',
    `title` varchar(255) null comment '标题',
    `content` longtext null comment '博文',
    `first_picture` varchar(255) null comment '首页图片',
    `flag` varchar(100) null comment '标记',
    `views` int(11) not null null default 0 comment '浏览数',
    `appreciation` bit not null default 0 comment '是否赞赏',
    `share_statement` bit not null default 0  comment '是否转载声明',
    `commentable` bit not null default 0 comment '是否评论',
    `published` bit not null default 0 comment '是否发布',
    `recommend` bit not null  default 0 comment '是否推荐',
    `create_time` timestamp null default null comment '创建时间',
    `update_time` timestamp null default null comment '修改时间',
    `type_id` bigint comment '类型ID',
    `user_id` bigint comment '用户ID',
    `comment_count` int null default 0 comment '评论数',
    primary key (`id`) using btree,
    index `idx_type` (`type_id`) using btree,
    index `idx_user` (`user_id`) using btree,
    constraint `idx_type` foreign key (`type_id`) references `t_type` (`id`) on delete restrict on update restrict,
    constraint `idx_user` foreign key (`user_id`) references `t_user` (`id`) on delete restrict on update restrict
) comment='博客';
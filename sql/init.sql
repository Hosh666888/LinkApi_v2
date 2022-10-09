create database link;

create table article
(
    id bigint not null,
    tree_catalog_id bigint null,
    title varchar(255) collate utf8mb4_general_ci not null,
    labels varchar(255) collate utf8mb4_general_ci null comment '标签 逗号分隔',
    content longtext collate utf8mb4_general_ci null comment '富文本原始字符',
    origin_content longtext collate utf8mb4_general_ci null comment '用于检索的文本',
    cover_image_url varchar(255) collate utf8mb4_general_ci null comment '封面图片地址',
    if_reprinted tinyint(1) default 0 null comment '是否转载',
    reprinted_url varchar(255) collate utf8mb4_general_ci null comment '转载链接',
    if_top tinyint(1) default 0 null comment '是否置顶',
    if_private tinyint(1) default 0 null comment '是否公开',
    heat bigint default 0 null,
    delete_flag tinyint(1) default 0 null,
    remark varchar(255) collate utf8mb4_general_ci null,
    status int default 0 null comment '审核状态
（0：审核中 1：通过  -1：失败 ）',
    create_user bigint null,
    create_time datetime null,
    update_user bigint null,
    update_time datetime null,
    constraint article_id_uindex
        unique (id)
)
    charset=utf8mb4;

alter table article
    add primary key (id);

create table comment
(
    id bigint not null
        primary key,
    article_id bigint not null,
    content varchar(255) not null,
    reply_id bigint null comment '回复评论id',
    create_user bigint not null comment '创建人',
    create_time datetime default CURRENT_TIMESTAMP not null,
    flag int default 1 not null
);

create table tree_catalog
(
    id bigint not null,
    parent_id bigint null comment '父目录id',
    name varchar(50) null comment '目录标题',
    owner bigint not null,
    constraint tree_catalog_id_uindex
        unique (id)
)
    comment '树型目录';

alter table tree_catalog
    add primary key (id);

create table user
(
    id bigint not null
        primary key,
    username varchar(50) null comment '用户名',
    password varchar(255) null,
    nick_name varchar(255) not null comment '昵称',
    gender tinyint default 1 not null comment '性别',
    email varchar(100) null,
    role varchar(10) default 'normal' not null comment '角色',
    experience bigint default 0 null comment '经验值',
    flag int default 1 null comment '标记位',
    avatar varchar(255) default 'https://images.pexels.com/photos/1605148/pexels-photo-1605148.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750' null comment '头像url',
    github_id bigint null,
    github_home_url varchar(255) null,
    create_time datetime not null,
    update_time datetime default CURRENT_TIMESTAMP null,
    permissions varchar(255) null,
    constraint user_github_id_uindex
        unique (github_id),
    constraint username_idx
        unique (username)
);

create index nickname_idx
    on user (nick_name);


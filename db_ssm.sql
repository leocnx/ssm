drop table if exists ams_authorization;

drop table if exists ams_operator;

drop table if exists ams_resource;

drop table if exists ams_role;

drop table if exists ams_role_authorization;

drop table if exists ams_role_operator;

drop table if exists ams_role_resource;

/*==============================================================*/
/* Table: ams_authorization                                     */
/*==============================================================*/
create table ams_authorization
(
   id                   bigint not null auto_increment,
   auth_name            varchar(255),
   auth_code            varchar(255),
   auth_status          varchar(16),
   primary key (id)
);

/*==============================================================*/
/* Table: ams_operator                                          */
/*==============================================================*/
create table ams_operator
(
   id                   bigint not null auto_increment,
   real_name            varchar(255),
   login_name           varchar(255),
   login_pwd            varchar(255),
   opr_status           varchar(16),
   primary key (id)
);

/*==============================================================*/
/* Table: ams_resource                                          */
/*==============================================================*/
create table ams_resource
(
   id                   bigint not null auto_increment,
   parent_id            bigint,
   level                int,
   is_leaf              char(5),
   res_name             varchar(255),
   res_code             varchar(255),
   res_status           varchar(16),
   target_name          varchar(64),
   rest_url             varchar(255),
   primary key (id)
);

/*==============================================================*/
/* Table: ams_role                                              */
/*==============================================================*/
create table ams_role
(
   id                   bigint not null auto_increment,
   role_name            varchar(255),
   role_code            varchar(255),
   primary key (id)
);

/*==============================================================*/
/* Table: ams_role_authorization                                */
/*==============================================================*/
create table ams_role_authorization
(
   id                   bigint not null auto_increment,
   role_id              bigint,
   auth_id              bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: ams_role_operator                                     */
/*==============================================================*/
create table ams_role_operator
(
   id                   bigint not null auto_increment,
   role_id              bigint,
   opr_id               bigint,
   primary key (id)
);

/*==============================================================*/
/* Table: ams_role_resource                                     */
/*==============================================================*/
create table ams_role_resource
(
   id                   bigint not null auto_increment,
   role_id              bigint,
   res_id               bigint,
   primary key (id)
);

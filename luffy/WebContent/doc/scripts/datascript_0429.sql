/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     4/29/2019 6:38:30 PM                         */
/*==============================================================*/


drop table if exists DICTIONARY;

drop table if exists MEAL;

drop table if exists "USER";

/*==============================================================*/
/* Table: DICTIONARY                                            */
/*==============================================================*/
create table DICTIONARY 
(
   DICTIONARY_ID        integer                        not null,
   NAME                 varchar(30)                    null,
   CODE                 char(8)                        null,
   constraint PK_DICTIONARY primary key clustered (DICTIONARY_ID)
);

/*==============================================================*/
/* Table: MEAL                                                  */
/*==============================================================*/
create table MEAL 
(
   MEAL_ID              integer                        not null,
   "DATE"               date                           null,
   SITE                 varchar(10)                    null,
   STAFFID              varchar(20)                    null,
   TYPE                 tinyint                        null,
   STATUS               tinyint                        null,
   "USER"               integer                        null,
   constraint PK_MEAL primary key clustered (MEAL_ID)
);

/*==============================================================*/
/* Table: "USER"                                                */
/*==============================================================*/
create table "USER" 
(
   USER_ID              integer                        not null,
   STAFFID              varchar(20)                    null,
   NAME                 varchar(5)                     null,
   ENNAME               varchar(15)                    null,
   SEX                  char(1)                        null,
   EMAIL                varchar(30)                    null,
   DEPARTMENT           integer                        null,
   constraint PK_USER primary key clustered (USER_ID)
);


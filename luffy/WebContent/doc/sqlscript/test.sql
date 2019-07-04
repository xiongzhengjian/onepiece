create  database  if not exists  test character set 'utf8';
use test;
create table user like luffy.user;
create table dictionary like luffy.dictionary;

insert into dictionary select * from  luffy.dictionary;
insert into user select * from luffy.user;

select * from user;

select * from user where user_id =11;


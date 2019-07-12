use luffy;
select * from user;
select t_u.department,count(user_id) as employeesNum from user as t_u group by department;

select  count(*) as orderedNum from user where mealstatus=1 group by department;
select  count(*) as notOrderedNum from user where mealstatus=0 group by department;
#=======union query  (trial)
select count(*) as employeesNum from user  
union
select  count(*) as orderedNum from user where mealstatus=1 
union
select  count(*) as notOrderedNum from user where mealstatus=0 ;
#=======union query (trial fail)
select count(*) as employeesNum from user group by department 
union
select  count(*) as orderedNum from user where mealstatus=1 group by department 
union
select  count(*) as notOrderedNum from user where mealstatus=0 group by department;
#=====order situation ver_0  (deserted)
select t_user1.employeesNum ,t_user2.orderedNum ,t_user3.notOrderedNum,t_user2.orderedNum/t_user1.employeesNum as orderRate
 from (select count(user_id) as employeesNum from user) t_user1,
 (select  count(*) as orderedNum from user where mealstatus=1 ) t_user2 ,
 (select  count(*) as notOrderedNum from user where mealstatus=0 ) t_user3;
#=====order situation ver_1  (deserted)
select t_user1.employeesNum ,t_user2.orderedNum ,t_user3.notOrderedNum,t_user2.orderedNum/t_user1.employeesNum as orderRate
 from (select count(user_id) as employeesNum from user group by department) t_user1,
 (select  count(*) as orderedNum from user where mealstatus=1 group by department ) t_user2 ,
 (select  count(*) as notOrderedNum from user where mealstatus=0 group by department ) t_user3;
 #=======order situation ver_2  (deserted:repeating data )
select t_user1.employeesNum ,t_user2.orderedNum ,t_user3.notOrderedNum
 from (select count(user_id) as employeesNum from user group by department) t_user1,
 (select  count(*) as orderedNum from user where mealstatus=1 group by department ) t_user2 ,
 (select  count(*) as notOrderedNum from user where mealstatus=0 group by department ) t_user3; 
 
 #=======order situation ver_3  (deserted:repeating data and fail)
select t_user1.employeesNum ,t_user2.orderedNum
 from (select count(user_id) as employeesNum from user group by department) t_user1,
 (select  count(*) as orderedNum from user where mealstatus=1 group by department ) t_user2 ;
#=========
select t_user1.employeesNum ,t_user2.orderedNum
 from (select count(user_id) as employeesNum from user group by department) t_user1,
 (select  count(*) as orderedNum from user where mealstatus=1 group by department ) t_user2 ;



#========success=============
#=======message of employees who didn't make a meal order (used)
select u.*, d.message as dept 
from user u inner join dictionary d on u.department=d.dictionary_id where u.mealstatus =0;

#order_situation_detail: 1.dept 1.1emplloyeeNum
select t_d.message as dept,count(user_id) as employeesNum 
from user as t_u inner join dictionary t_d on t_u.department=t_d.dictionary_id  group by t_u.department;


#order_situation_detail: 1.dept 1.2 orderedNum 1.3 notOrderedNum 1.4 orderRate
select  t_d.message as dept ,count(*)  as orderedNum
 from user t_u inner join dictionary t_d on t_u.department=t_d.dictionary_id where t_u.mealstatus=1 group by t_u.department ;
 
 #Reset user's mealstatus value to 0 at 00:5 per day
create event luffy_rest_mealstauts
	on schedule every 1 DAY starts '2019-07-03 00:05:00'
    ON COMPLETION PRESERVE ENABLE
    do
		UPDATE luffy.user SET luffy.user.mealstatus = 0 where luffy.user.user_id>0;

show create event luffy_rest_mealstauts;
        
drop event if exists luffy_rest_mealstauts;
 

update user set mealstatus=1 where mealstatus=0 and department=8;

alter table user modify column department varchar(10);

update user set department = '1STQ10' where department='7';
update user set department = '1STQ20' where department='8';

select department as dept,count(user_id) as employeesNum from user group by department;

#1STQ00
select count(user_id) as 1STQ00 from user where department='1STQ00' and  mealstatus=1;
#1STQ10
select count(user_id)  as 1STQ10 from user where department='1STQ10' and  mealstatus=1;
#1STQ20
select count(user_id) as 1STQ20 from user where department='1STQ20' and  mealstatus=1;

select count(user_id) as 1STQ00 from user where department='1STQ00' and  mealstatus=1 
union 
select count(user_id)  as 1STQ10 from user where department='1STQ10' and  mealstatus=1
union 
select count(user_id) as 1STQ20 from user where department='1STQ20' and  mealstatus=1;

select * from user where mealstatus=0 order by department;

select * from user where mealstatus=1;

alter table user add column hireDate date;
update user set hireDate='2017-10-17' where user_id>0;
#Trx Exception
select * from information_schema.innodb_trx;
kill 537;

#----------------------2019-07-08--------------------------
alter table user add column remember int1 default 0;
update user set remember=0 where user_id>0;

alter table user modify column hireDate date default '2017-10-17';
alter table user modify column password char(10) default '000000';
update user set password='000000' where user_id>0;
alter table user modify column enname varchar(20) default 'luffy';

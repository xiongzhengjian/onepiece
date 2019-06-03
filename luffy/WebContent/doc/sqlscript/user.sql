select * from user;
select count(user_id) as employeesNum from user group by department;
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

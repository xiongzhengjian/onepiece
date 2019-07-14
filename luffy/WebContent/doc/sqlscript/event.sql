show processlist;
#any of the following 4 statements can be used in the mysql client to turn on the Event Scheduler: 
SET GLOBAL event_scheduler = ON;
SET @@GLOBAL.event_scheduler = ON;
SET GLOBAL event_scheduler = 1;
SET @@GLOBAL.event_scheduler = 1;
#Similarly, any of these 4 statements can be used to turn off the Event Scheduler: 
SET GLOBAL event_scheduler = OFF;
SET @@GLOBAL.event_scheduler = OFF;
SET GLOBAL event_scheduler = 0;
SET @@GLOBAL.event_scheduler = 0;



#example of a minimal CREATE EVENT statement
create event test_meal_status
	on SCHEDULE  at current_timestamp + INTERVAL 1 minute
    ON COMPLETION PRESERVE ENABLE
    do
		UPDATE test.user SET test.user.mealstatus = test.user.mealstatus+1 where test.user.user_id=11;
        
drop event if exists test_meal_status;

#查看是否开启定时器
show variables like 'event_scheduler';
show variables like 'event_scheduler';

#Reset user's mealstatus value to 0 at 16:50 per day
create event test_rest_mealstauts
	on schedule every 1 DAY starts '2019-07-04 00:01:00'
    ON COMPLETION PRESERVE ENABLE
    do
		UPDATE test.user SET test.user.mealstatus = 0 where test.user.user_id>0;
drop event if exists test_rest_mealstauts;

show processlist;
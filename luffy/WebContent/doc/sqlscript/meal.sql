use luffy;
SELECT * FROM luffy.meal;
select count(*)  from  meal where  date='2019-07-05 00:00:00' and user=11;
select *  from  meal where  date='2019-07-05 00:00:00' and user=3;

select * from meal 
			where
		 user=11 and date >='2019-07-05';

select distinct *  from meal where date='2019-07-06 00:00:00';

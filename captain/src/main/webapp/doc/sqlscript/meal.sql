use luffy;
SELECT * FROM luffy.meal;
select count(*)  from  meal where  date='2019-07-05 00:00:00' and user=11;
select *  from  meal where  date='2019-07-07 00:00:00' and user=41;

select * from meal 
			where
		 user=11 and date >='2019-07-07';

select *  from meal where date>='2019-07-10 00:00:00' and type=1;



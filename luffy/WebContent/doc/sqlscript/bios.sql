create table bios (
	bios_id int(11) primary key auto_increment, 
	chassis varchar(20),
	platform varchar(20),
	test_type varchar(25),
	start datetime,
	end datetime,
	bios_version varchar(8),
	image_build_id varchar(25),
	test_plan varchar(100),
	tester varchar(15));

describe bios;

insert into bios 
(bios_id,owner,chassis,platform,test_type,start,end,bios_version,image_build_id,test_plan,tester)
 values
(2,'Sunny','Nicolas','LincsB','bios pre-test','2019-02-05 14:25:30','2019-05-11 11:05:30','F.10','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear');

alter table bios add column owner varchar(15) after bios_id;

update bios set owner='Yiquan' 
	where
    bios_id = 1;

select * from bios;

select bios_id,owner,chassis,platform,test_type,start,end,bios_version,image_build_id,test_plan,tester 
	from
		bios
    order by
		bios_id desc;
        
update bios set 
	owner = 'Yiquan2',
    chassis = 'Nicolas',
    platform = 'LincsB',
    test_type = 'Bios pre-test',
    start = '2019-06-08 14:25:30',
    end = '2019-06-11 14:25:30',
    bios_version = 'F.10',
    image_build_id = '18WW2SVT6AF',
    test_plan = 'CDT-BIOS-Checklist_v4.6_pre-test',
    tester = 'littlebear' 
 where
 bios_id=1;



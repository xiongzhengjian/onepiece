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
(bios_id,chassis,platform,test_type,start,end,bios_version,image_build_id,test_plan,tester)
 values
(1,'Nicolas','LincsB','bios pre-test','2019-06-08 14:25:30','2019-06-11 14:25:30','F.10','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear');

select * from bios;
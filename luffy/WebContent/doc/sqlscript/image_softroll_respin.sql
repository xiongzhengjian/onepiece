create table softroll_respin (
	softrollrespin_id int(11) primary key auto_increment,
    chassis varchar(20),
	platform varchar(20),
    test_function varchar(10),
    start datetime,
	end datetime,
    bios_version varchar(8),
    image_build_id varchar(25),
	test_plan varchar(100),
	tester varchar(15)
);

describe softroll_respin;

insert into softroll_respin 
(softrollrespin_id,chassis,platform,test_function,start,end,bios_version,image_build_id,test_plan,tester)
 values
(1,'NesslerP','Sunflower','FIT','2019-06-08 14:25:30','2019-06-11 14:25:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear'),
(2,'NesslerP','Sunflower','WAT','2018-06-08 14:25:30','2019-06-11 11:40:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear'),
(3,'NesslerP','Sunflower','SWT','2019-02-08 08:25:30','2019-06-11 11:40:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear');

select * from softroll_respin;
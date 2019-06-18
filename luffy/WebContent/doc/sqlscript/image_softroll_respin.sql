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

alter table softroll_respin rename to softrollrespin;

alter table softrollrespin add column owner varchar(15) after softrollrespin_id;


describe softrollrespin;

insert into softrollrespin 
(softrollrespin_id,owner,chassis,platform,test_function,start,end,bios_version,image_build_id,test_plan,tester)
 values
(7,'Tester1','NesslerP','Sunflower','FIT','2019-06-08 14:25:30','2019-06-11 14:25:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear'),
(8,'Tester2','NesslerP','Sunflower','WAT','2018-06-08 14:25:30','2019-06-11 11:40:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear'),
(9,'Tester3','NesslerP','Sunflower','SWT','2019-02-08 08:25:30','2019-06-11 11:40:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear');

select * from softrollrespin;

update softrollrespin set 			
			owner='Tester1',
		    chassis='NesslerP',
		    platform='Sunflower',
		    test_function='',		    	    
		    start='2019-02-08 08:25:30',
		    end='2019-06-11 11:40:30',
		    bios_version='F.20',
		    image_build_id='18WW2SVT6AF',
		    test_plan='CDT-BIOS-Checklist_v4.6_pre-test',
		    tester='littlebear' 
 		where
 			softrollrespin_id='2';
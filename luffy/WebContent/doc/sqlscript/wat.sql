create table wat (
	wat_id int(11) primary key auto_increment,
    chassis varchar(20),
	platform varchar(20),
    device_name varchar(30),    
    PN_SN varchar(15),
    start datetime,
	end datetime,
    bios_version varchar(8),
    image_build_id varchar(25),
	test_plan varchar(100),
	tester varchar(15)
);
alter table wat add column owner varchar(15) after wat_id;
alter table wat change PN_SN pn_sn varchar(15); 

describe wat;

insert into wat 
(wat_id,owner,chassis,platform,device_name,PN_SN,start,end,bios_version,image_build_id,test_plan,tester)
 values
(4,'Tester4','NesslerP','Sunflower','Headset 400','924121-001','2019-06-08 14:25:30','2019-06-11 14:25:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear'),
(5,'Tester5','NesslerP','Sunflower','Headset 800','924121-005','2018-06-08 14:25:30','2019-06-11 11:40:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear'),
(6,'Tester6','NesslerP','Sunflower','Headset 1200','924121-008','2019-02-08 08:25:30','2019-06-11 11:40:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear');


select * from wat;

update wat set 			
			owner='Tester1',
		    chassis='NesslerP',
		    platform='Sunflower',
		    device_name='Headset 4002',
		    pn_sn='94256-5151',		    
		    start='2019-02-08 08:25:30',
		    end='2019-06-11 11:40:30',
		    bios_version='F.20',
		    image_build_id='18WW2SVT6AF',
		    test_plan='CDT-BIOS-Checklist_v4.6_pre-test',
		    tester='littlebear' 
 		where
 			wat_id='1';
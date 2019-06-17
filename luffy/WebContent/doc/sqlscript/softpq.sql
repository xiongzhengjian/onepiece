create table softpaq (
	softpaq_id int(11) primary key auto_increment,
    chassis varchar(20),
	platform varchar(20),
    sp_number varchar(10),    
    softpaq_title varchar(50),
	version varchar(50),
    start datetime,
	end datetime,
    bios_version varchar(8),
    image_build_id varchar(25),
	test_plan varchar(100),
	tester varchar(15)
);
alter table softpaq add column owner varchar(15) after softpaq_id;
describe softpaq;

insert into softpaq 
(softpaq_id,chassis,platform,sp_number,softpaq_title,version,start,end,bios_version,image_build_id,test_plan,tester)
 values
(1,'NesslerP','Sunflower','SP96602','NVIDIA GeForce Driver for VR1','26.21.14.3039-B-1','2019-06-08 14:25:30','2019-06-11 14:25:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear'),
(2,'NesslerP','Sunflower','SP96602','NVIDIA GeForce Driver for VR2','26.21.14.3039-B-2','2018-06-08 14:25:30','2019-06-11 11:40:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear'),
(3,'NesslerP','Sunflower','SP96602','NVIDIA GeForce Driver for VR3','26.21.14.3039-B-3','2019-02-08 08:25:30','2019-06-11 11:40:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear');


select * from softpaq;
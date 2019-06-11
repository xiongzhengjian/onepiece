create table commodity (
	commodity_id int(11) primary key auto_increment,
    chassis varchar(20),
	platform varchar(20),
    type varchar(20),
    name varchar(20),
    PN_SN varchar(15),
    start datetime,
	end datetime,
    bios_version varchar(8),
    image_build_id varchar(25),
	test_plan varchar(100),
	tester varchar(15)
);

describe commodity;

insert into commodity 
(commodity_id,chassis,platform,type,name,PN_SN,start,end,bios_version,image_build_id,test_plan,tester)
 values
(1,'NesslerP','Sunflower','HDD','SEAGATE 1T','924121-001','2019-06-08 14:25:30','2019-06-11 14:25:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear'),
(2,'NesslerP','Sunflower','CPU','I5 8400','924121-005','2018-06-08 14:25:30','2019-06-11 11:40:30','F.20','18WW2SVT6AF','CDT-BIOS-Checklist_v4.6_pre-test','littlebear');


select * from commodity;
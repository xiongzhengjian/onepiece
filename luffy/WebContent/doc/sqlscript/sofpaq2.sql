use luffy;
create table softpaq2 (
	softpaq_id int(11) primary key auto_increment,
    owner varchar(15),
    start datetime,
	end datetime,
    sp_number varchar(10),    
    softpaq_title varchar(50),
	version varchar(50),
    platform varchar(80),
    sptest_tool_status varchar(5),
    installation_status varchar(5),
    function_status varchar(25),
    products_sequence int(4),
	mark varchar(100)
	
);

insert into softpaq2 
	(softpaq_id,owner,start,end,sp_number,softpaq_title,version,platform,sptest_tool_status,installation_status,function_status,products_sequence,mark) 
  values
	(1,'Elva','2019-06-08 14:25:30','2019-06-11 14:25:30','SP960669','Intel Management Engine Interface (MEI) Driver','1904.12.0.1208 - A - 16','Dyson - HP ENVY 795-0xxx Desktop','PASS','PASS','PASS','1','Only test in CFL project(Luton not support)'),
    (2,'Elva','2019-06-08 14:25:30','2019-06-11 14:25:30','SP960669','Intel Management Engine Interface (MEI) Driver','1904.12.0.1208 - A - 16','DysonP - HP Pavilion Gaming 790-0xxx Desktop','PASS','PASS','PASS','2','Only test in CFL project(Luton not support)'),
    (3,'Elva','2019-06-08 14:25:30','2019-06-11 14:25:30','SP960669','Intel Management Engine Interface (MEI) Driver','1904.12.0.1208 - A - 16','Evans 1C18 - HP Slim 290-p0xxx Desktop','PASS','PASS','PASS','3','Only test in CFL project(Luton not support)');

update softpaq2 set 			
			owner='Sunny',start='2019-06-08 14:25:30',end='2019-06-11 14:25:30',sp_number='SP960669',softpaq_title='Intel Management Engine Interface (MEI) Driver',version='1904.12.0.1208 - A - 16',platform='Dyson - HP ENVY 795-0xxx Desktop',sptest_tool_status='PASS',installation_status='PASS',function_status='PASS',products_sequence='4',mark='Only test in CFL project(Luton not support)'
 		where
 			softpaq_id='4';

select * from softpaq2;
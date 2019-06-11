SELECT * FROM luffy.dictionary;
desc dictionary;
insert into dictionary(dictionary_id,message,code) 
	values 
	(12,'weekly test','BIOS01'),
    (13,'BC test','BIOS01'),
    (14,'BIOS softpaq','BIOS01'),
    (15,'BIOS Full','BIOS01');
insert into dictionary(dictionary_id,message,code) 
	values 
	(11,'bios pre-test','BIOS01');
    
insert into dictionary(dictionary_id,message,code) 
	values 
	(16,'SWT','Softroll'),
    (17,'FIT','Softroll'),
    (18,'WAT','Softroll'),
    (19,'Stress','Softroll'),
	(20,'HWQA','Softroll'),
	(21,'Benchmark','Softroll');
    
insert into dictionary(dictionary_id,message,code) 
	values 
	(22,'HDD','Commodity01'),
    (23,'CPU','Commodity01'),
    (24,'DIMM','Commodity01'),
    (25,'SSD','Commodity01'),
	(26,'Graphic Card','Commodity01'),
	(27,'WLAN','Commodity01'),
    (28,'PSU','Commodity01'),
    (29,'PSU FAN','Commodity01');
    
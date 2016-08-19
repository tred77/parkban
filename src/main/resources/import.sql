
-- initial regions
insert into TBL_REGION(id,CODE, name, address, PARENT_ID,REGION_TYPE,ACTIVE,LEVEL) values (1,'1', 'Tehran Province ', 'Tehran',null, 'ROOT',true,0);
insert into TBL_REGION(id,CODE, name, address, PARENT_ID,REGION_TYPE,ACTIVE,LEVEL) values (2,'2', 'Tehran City', 'Tehran',1,'MIDDLE',true,1);

insert into TBL_REGION(id,CODE, name, address, PARENT_ID,REGION_TYPE,ACTIVE,LEVEL) values (3,'3', 'Region 1', 'Region 1', 2,'MIDDLE',true,2);
insert into TBL_REGION(id,CODE,name, address, PARENT_ID,REGION_TYPE,ACTIVE,LEVEL) values (5,'5', 'Vanak', 'Vanak', 3,'LEAF',true,3);
insert into TBL_REGION(id,CODE, name, address, PARENT_ID,REGION_TYPE,ACTIVE,LEVEL) values (6,'6', 'Ponak', 'Ponak', 3,'LEAF',true,3);
insert into TBL_REGION(id,CODE, name, address, PARENT_ID,REGION_TYPE,ACTIVE,LEVEL) values (7,'7', 'Jordan', 'Jordan',3,'LEAF',true,3);
insert into TBL_REGION(id,CODE, name, address, PARENT_ID,REGION_TYPE,ACTIVE,LEVEL) values (8,'8', 'Zafar', 'Zafar', 3,'LEAF',true,3);

insert into TBL_REGION(id,CODE, name, address, PARENT_ID,REGION_TYPE,ACTIVE,LEVEL) values (4,'4', 'Region 2', 'Region 2', 2,'MIDDLE',true,2);
insert into TBL_REGION(id,CODE, name, address, PARENT_ID,REGION_TYPE,ACTIVE,LEVEL) values (9,'9', 'Kurdistan', 'Kurdistan', 4,'LEAF',true,3);
insert into TBL_REGION(id,CODE, name, address, PARENT_ID,REGION_TYPE,ACTIVE,LEVEL) values (10,'10', 'Navab', 'Navab',4,'LEAF',true,3);

-- initial parktime
insert into TBL_PARK_TIME(id, VEHICLE_NUMBER, PARK_DATETIME, REGION_ID, STATUS) values (1, '22-1234', {ts '2016-06-23 08:47:52.69'}, 1, 'R');
insert into TBL_PARK_TIME(id, VEHICLE_NUMBER, PARK_DATETIME, REGION_ID, STATUS) values (2, '22-1234', {ts '2016-06-23 08:59:52.69'}, 1, 'R');
insert into TBL_PARK_TIME(id, VEHICLE_NUMBER, PARK_DATETIME, REGION_ID, STATUS) values (3, '22-1234', {ts '2016-06-23 09:20:52.69'}, 1, 'R');
insert into TBL_PARK_TIME(id, VEHICLE_NUMBER, PARK_DATETIME, REGION_ID, STATUS) values (4, '22-1234', {ts '2016-06-23 09:31:52.69'}, 1, 'R');

insert into TBL_PARK_TIME(id, VEHICLE_NUMBER, PARK_DATETIME, REGION_ID, STATUS) values (5, '99-9090', {ts '2016-06-23 08:30:52.69'}, 5, 'R');
insert into TBL_PARK_TIME(id, VEHICLE_NUMBER, PARK_DATETIME, REGION_ID, STATUS) values (6, '99-9090', {ts '2016-06-23 08:49:52.69'}, 5, 'R');
insert into TBL_PARK_TIME(id, VEHICLE_NUMBER, PARK_DATETIME, REGION_ID, STATUS) values (7, '99-9090', {ts '2016-06-23 09:01:52.69'}, 5, 'R');
insert into TBL_PARK_TIME(id, VEHICLE_NUMBER, PARK_DATETIME, REGION_ID, STATUS) values (8, '99-9090', {ts '2016-06-23 09:26:52.69'}, 5, 'R');

-- permission --
insert into TBL_PERMISSION(id,name,code,description ) values(1,'insertUser','S00001','تعریف کاربر');
insert into TBL_PERMISSION(id,name,code,description ) values(2,'updateUser','S00002','ویرایش کاربر ');
insert into TBL_PERMISSION(id,name,code,description ) values(3,'deleteUser','S00003','حذف کاربر ');

-- role -
insert into TBL_ROLE(id,name ) values(1,'Admin');
insert into TBL_ROLE(id,name) values(2,'Parkban');
insert into TBL_ROLE(id,name) values(3,'User');

-- user
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(1,'behrooz', 'zamani', 'bzd', 'bzd', true,3733111834);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(2,'hossein', 'yeganeh', 'hym', 'hym', true,3733111835);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(3,'Admin', 'Admin', 'admin', 'admin', true,3733111836);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(4,'iman', 'akbari', 'iman', 'iman', true,3733111837);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(5,'reza', 'nouri', 'reza', 'nouri', true,3733111838);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(6,'sedigh', 'rigi', 'sedigh', 'rigi', true,3733111839);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(7,'ali', 'kia', 'ali', 'kia', true,3733111840);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(8,'amir', 'amir', 'amir', 'amir', true,37331118341);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(9,'reza', 'alaei', 'reza', 'alaie', true,3733111842);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(10,'fouad', 'bahr', 'fouad', 'bahr', true,3733111843);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(11,'loghman', 'rahimzadeh', 'logh', 'logh', true,3733111844);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(12,'ahmad', 'kolivand', 'ahmad', 'koliv', true,3733111845);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(13,'mohsen', 'jenadeleh', 'mohsen', 'jende', true,3733111846);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(14,'mahmood', 'sadeghi', 'mahmood', 'sadeghi', true,3733111847);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(15,'Goli', 'razi', 'goli', 'razi', true,3733111848);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(16,'sasa', 'sasa', 'sasa', 'sasa', true,3733111849);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(17,'babak', 'eghbali', 'babak', 'eghi', true,3733111850);
insert into TBL_USER(id, first_name,last_name,username,password,active,national_id) values(18,'khaleh', 'beti', 'khale', 'beti', true,3733111851);

-- vehicle owner
insert into TBL_VEHICLE_OWNER (id, USER_ID) values(1, 1);
insert into TBL_VEHICLE_OWNER (id, USER_ID) values(2, 2);

-- initial vehicles
insert into TBL_VEHICLE(id,plate_Number,OWNER_ID) values(1,'123456789',1);
insert into TBL_VEHICLE(id,plate_Number, OWNER_ID) values(2,'987654321',2);
insert into TBL_VEHICLE(id,plate_Number, OWNER_ID) values(3,'111111111',1);
insert into TBL_VEHICLE(id,plate_Number, OWNER_ID) values(4,'222222222',2);

-- parkban
insert into TBL_PARKBAN(id, user_id) values(1,1);
insert into TBL_PARKBAN(id, user_id) values(2,2);

--parkbanTimeTable
insert into TBL_PARKBAN_TIME_TABLE(id, parkban_id, region_id, work_date) values(1, 1, 5, {ts '2016-06-23'});
insert into TBL_PARKBAN_TIME_TABLE(id, parkban_id, region_id, work_date) values(2, 2, 1, {ts '2016-06-23'});

-- parkbanTrack
insert into TBL_PARKBAN_TRACK(id, PARK_DATETIME, REGION_ID, PARKBAN_ID, LATITUDE, LONGITUDE) values(1, {ts '2016-07-16 08:30:52.69'}, null, 1 , 35.739072,51.397179);
insert into TBL_PARKBAN_TRACK(id, PARK_DATETIME, REGION_ID, PARKBAN_ID, LATITUDE, LONGITUDE) values(2, {ts '2016-07-16 08:35:52.69'}, null, 1 , 35.739063,51.397608);
insert into TBL_PARKBAN_TRACK(id, PARK_DATETIME, REGION_ID, PARKBAN_ID, LATITUDE, LONGITUDE) values(3, {ts '2016-07-16 08:40:52.69'}, null, 1 , 35.739072,51.398230);
insert into TBL_PARKBAN_TRACK(id, PARK_DATETIME, REGION_ID, PARKBAN_ID, LATITUDE, LONGITUDE) values(4, {ts '2016-07-16 08:45:52.69'}, null, 1 , 35.739072,51.399179);


-- parkCharge

insert into TBL_PARK_CHARGE(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, LAST_CHARGE_DATE,LAST_CHARGE_AMOUNT) values(1,1,'11111','Owner',12764,{ts '2016-07-16 08:50:52.69'}, 76542);
insert into TBL_PARK_CHARGE(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, LAST_CHARGE_DATE,LAST_CHARGE_AMOUNT) values(2,1,'22222','Owner',34563,{ts '2016-07-17 09:45:52.69'}, 53627);
insert into TBL_PARK_CHARGE(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, LAST_CHARGE_DATE,LAST_CHARGE_AMOUNT) values(3,1,'33333','Owner',56374,{ts '2016-07-18 10:42:52.69'}, 87123);
insert into TBL_PARK_CHARGE(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, LAST_CHARGE_DATE,LAST_CHARGE_AMOUNT) values(4,1,'44444','Owner',57840,{ts '2016-07-19 11:35:52.69'}, 65293);

insert into TBL_PARK_CHARGE(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, LAST_CHARGE_DATE,LAST_CHARGE_AMOUNT) values(5,2,'55555','Owner',12764,{ts '2016-07-26 03:50:52.69'}, 56042);
insert into TBL_PARK_CHARGE(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, LAST_CHARGE_DATE,LAST_CHARGE_AMOUNT) values(6,2,'66666','Owner',34563,{ts '2016-07-27 10:45:52.69'}, 63027);
insert into TBL_PARK_CHARGE(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, LAST_CHARGE_DATE,LAST_CHARGE_AMOUNT) values(7,2,'77777','Owner',56374,{ts '2016-07-28 06:42:52.69'}, 47023);
insert into TBL_PARK_CHARGE(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, LAST_CHARGE_DATE,LAST_CHARGE_AMOUNT) values(8,2,'88888','Owner',57840,{ts '2016-07-29 12:35:52.69'}, 95093);

-- park charge doc

insert into TBL_CHARGE_DOC(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, CHARGE_CHANNEL_TYPE,PARKBAN_ID,REGION_ID,DATE) values(1,1,'11111','Owner',12764,'PARKBAN',1,6,{ts '2016-07-10 04:42:52.69'});
insert into TBL_CHARGE_DOC(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, CHARGE_CHANNEL_TYPE,PARKBAN_ID,REGION_ID,DATE) values(2,1,'11111','Owner',34563,'PARKBAN',1,6,{ts '2016-07-18 10:42:52.69'});
insert into TBL_CHARGE_DOC(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, CHARGE_CHANNEL_TYPE,DATE) values(3,1,'11111','Owner',56374,'INTERNET',{ts '2016-07-19 12:42:52.69'});
insert into TBL_CHARGE_DOC(id, OWNER_ID, PLATE_NUMBER, CHARGE_TYPE, AMOUNT, CHARGE_CHANNEL_TYPE,DATE) values(4,1,'11111','Owner',57840,'INTERNET',{ts '2016-07-21 01:42:52.69'});


--- VehicleParkInfo

insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (1,'DAY','1395/4/26',{ts '2016-07-16'},{ts '2016-07-16'},13950426,13950426,1395,4,26);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (2,'DAY','1395/4/27',{ts '2016-07-17'},{ts '2016-07-17'},13950427,13950427,1395,4,27);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (3,'DAY','1395/4/28',{ts '2016-07-18'},{ts '2016-07-18'},13950428,13950428,1395,4,28);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (4,'DAY','1395/4/29',{ts '2016-07-19'},{ts '2016-07-19'},13950429,13950429,1395,4,29);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (5,'DAY','1395/4/30',{ts '2016-07-20'},{ts '2016-07-20'},13950430,13950430,1395,4,30);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (6,'DAY','1395/5/31',{ts '2016-07-21'},{ts '2016-07-21'},13950431,13950431,1395,4,31);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (7,'DAY','1395/5/1',{ts '2016-07-22'},{ts '2016-07-22'},13950501,13950501,1395,5,1);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (8,'DAY','1395/5/2',{ts '2016-07-23'},{ts '2016-07-23'},13950502,13950502,1395,5,2);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (9,'DAY','1395/5/3',{ts '2016-07-24'},{ts '2016-07-24'},13950503,13950503,1395,5,3);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (10,'DAY','1395/5/4',{ts '2016-07-25'},{ts '2016-07-25'},13950504,13950504,1395,5,4);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (11,'DAY','1395/5/5',{ts '2016-07-26'},{ts '2016-07-26'},13950505,13950505,1395,5,5);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (12,'DAY','1395/5/6',{ts '2016-07-27'},{ts '2016-07-27'},13950506,13950506,1395,5,6);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (13,'DAY','1395/5/7',{ts '2016-07-28'},{ts '2016-07-28'},13950507,13950507,1395,5,7);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (14,'DAY','1395/5/8',{ts '2016-07-29'},{ts '2016-07-29'},13950508,13950508,1395,5,8);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (15,'DAY','1395/5/9',{ts '2016-07-30'},{ts '2016-07-30'},13950509,13950509,1395,5,9);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (16,'DAY','1395/5/10',{ts '2016-07-31'},{ts '2016-07-31'},13950510,13950510,1395,5,10);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (17,'DAY','1395/5/11',{ts '2016-08-01'},{ts '2016-08-01'},13950511,13950511,1395,5,11);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (18,'DAY','1395/5/12',{ts '2016-08-02'},{ts '2016-08-02'},13950512,13950512,1395,5,12);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (19,'DAY','1395/5/13',{ts '2016-08-03'},{ts '2016-08-03'},13950513,13950513,1395,5,13);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (20,'DAY','1395/5/14',{ts '2016-08-04'},{ts '2016-08-04'},13950514,13950514,1395,5,14);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (21,'DAY','1395/5/15',{ts '2016-08-05'},{ts '2016-08-05'},13950515,13950515,1395,5,15);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (22,'DAY','1395/5/16',{ts '2016-08-06'},{ts '2016-08-06'},13950516,13950516,1395,5,16);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (23,'DAY','1395/5/17',{ts '2016-08-07'},{ts '2016-08-07'},13950517,13950517,1395,5,17);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (24,'DAY','1395/5/18',{ts '2016-08-08'},{ts '2016-08-08'},13950518,13950518,1395,5,18);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (25,'DAY','1395/5/19',{ts '2016-08-09'},{ts '2016-08-09'},13950519,13950519,1395,5,19);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (26,'DAY','1395/5/20',{ts '2016-08-10'},{ts '2016-08-10'},13950520,13950520,1395,5,20);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (27,'DAY','1395/5/21',{ts '2016-08-11'},{ts '2016-08-11'},13950521,13950521,1395,5,21);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (28,'DAY','1395/5/22',{ts '2016-08-12'},{ts '2016-08-12'},13950522,13950522,1395,5,22);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (29,'DAY','1395/5/23',{ts '2016-08-13'},{ts '2016-08-13'},13950523,13950523,1395,5,23);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (30,'DAY','1395/5/24',{ts '2016-08-14'},{ts '2016-08-14'},13950524,13950524,1395,5,24);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (31,'DAY','1395/5/25',{ts '2016-08-15'},{ts '2016-08-15'},13950525,13950525,1395,5,25);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (32,'DAY','1395/5/26',{ts '2016-08-16'},{ts '2016-08-16'},13950526,13950526,1395,5,26);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (33,'DAY','1395/5/27',{ts '2016-08-17'},{ts '2016-08-17'},13950527,13950527,1395,5,27);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (34,'DAY','1395/5/28',{ts '2016-08-18'},{ts '2016-08-18'},13950528,13950528,1395,5,28);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (35,'DAY','1395/5/29',{ts '2016-08-19'},{ts '2016-08-19'},13950529,13950529,1395,5,29);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (36,'DAY','1395/5/30',{ts '2016-08-20'},{ts '2016-08-20'},13950530,13950530,1395,5,30);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (37,'DAY','1395/5/31',{ts '2016-08-21'},{ts '2016-08-21'},13950531,13950531,1395,5,31);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (38,'DAY','1395/6/1',{ts '2016-08-22'},{ts '2016-08-22'},13950601,13950601,1395,6,1);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (39,'DAY','1395/6/2',{ts '2016-08-23'},{ts '2016-08-23'},13950602,13950602,1395,6,2);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (40,'DAY','1395/6/3',{ts '2016-08-24'},{ts '2016-08-24'},13950603,13950603,1395,6,3);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (41,'DAY','1395/6/4',{ts '2016-08-25'},{ts '2016-08-25'},13950604,13950604,1395,6,4);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (42,'DAY','1395/6/5',{ts '2016-08-26'},{ts '2016-08-26'},13950605,13950605,1395,6,5);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (43,'DAY','1395/6/6',{ts '2016-08-27'},{ts '2016-08-27'},13950606,13950606,1395,6,6);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (44,'DAY','1395/6/7',{ts '2016-08-28'},{ts '2016-08-28'},13950607,13950607,1395,6,7);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (45,'DAY','1395/6/8',{ts '2016-08-29'},{ts '2016-08-29'},13950608,13950608,1395,6,8);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,DAY) VALUES (46,'DAY','1395/6/9',{ts '2016-08-30'},{ts '2016-08-30'},13950609,13950609,1395,6,9);

insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (47,'WEEK','week 4 tir',{ts '2016-07-16'},{ts '2016-07-22'},13950426,13950501,1395,4,4);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (48,'WEEK','week 1 mordad',{ts '2016-07-23'},{ts '2016-07-29'},13950502,13950508,1395,5,1);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (49,'WEEK','week 2 mordad',{ts '2016-07-30'},{ts '2016-08-05'},13950509,13950515,1395,5,2);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (50,'WEEK','week 3 mordad',{ts '2016-08-06'},{ts '2016-08-12'},13950516,13950522,1395,5,3);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (51,'WEEK','week 4 mordad',{ts '2016-08-13'},{ts '2016-08-19'},13950523,13950529,1395,5,4);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (52,'WEEK','week 1 Shahrivar',{ts '2016-08-20'},{ts '2016-08-26'},13950530,13950605,1395,6,1);

insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH) VALUES (53,'MONTH','mordad',{ts '2016-07-22'},{ts '2016-08-21'},13950501,13950531,1395,5);


--- park region information --
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (1,1,6,12,426,46);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (2,2,6,13,556,52);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (3,3,6,12,356,91);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (4,4,6,16,126,70);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (5,5,6,18,316,41);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (6,6,6,19,206,95);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (7,7,6,22,206,77);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (8,8,6,722,226,81)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (9,9,6,883,356,42)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (10,10,6,72,456,52)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (11,11,6,66,526,71)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (12,12,6,58,616,63)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (13,13,6,49,706,46)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (14,14,6,32,806,34)

insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (15,47,6,234,2550,540)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (17,49,6,114,2550.130)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (16,48,6,154,2550,452)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (18,50,6,134,2550,230)

insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,TOTAL_PARK_TIME_CAPACITY) VALUES (19,53,6,280,416,312)


-- parkban proceed info

insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (1,1,1,6,1234567,454);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (2,2,1,6,223667,413);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (3,3,1,6,1234467,908);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (4,4,1,6,3234567,346);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (5,5,1,6,4234567,731);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (6,6,1,6,5234567,435);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (7,7,1,6,324567,878);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (8,8,1,6,623567,524);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (9,9,1,6,552456,324);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (10,10,1,6,332567,624);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (11,11,1,6,834567,254);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (12,12,1,6,934567,234);


insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (13,47,1,6,782456,3124);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (14,48,1,6,582567,1224);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (15,49,1,6,984567,954);
insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (16,50,1,6,734567,834);

insert into TBL_PARKBAN_PROCEED_INFO  (id,DATE_DIM_ID,PARKBAN_ID,REGION_ID,CHARGE_AMOUNT,PARK_REGISTER_COUNT) VALUES (17,53,1,6,5634567,3434);

-- vehicle park information
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (1,1,6,12,426,'222222222');
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (2,2,6,13,556,'222222222');
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (3,3,6,12,356,'222222222');
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (4,4,6,16,126,'222222222');
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (5,5,6,18,316,'222222222');
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (6,6,6,19,206,'222222222');
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (7,7,6,22,206,'222222222');
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (8,8,6,722,226,'222222222')
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (9,9,6,883,356,'222222222')
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (10,10,6,72,456,'222222222')
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (11,11,6,66,526,'222222222')
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (12,12,6,58,616,'222222222')
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (13,13,6,49,706,'222222222')
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (14,14,6,32,806,'222222222')

insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (15,47,6,234,2550,'222222222')
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (17,49,6,114,2550,'222222222')
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (16,48,6,154,2550,'222222222')
insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (18,50,6,134,2550,'222222222')

insert into TBL_VEHICLE_PARK_INFO  (id,DATE_DIM,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,PLATE_NUMBER) VALUES (19,53,6,280,416,'222222222')


-- region daily settlement
insert into TBL_PARK_DAILY_SETTLEMENT (id,REGION_ID,PARK_DATE,TOTAL_PARK_TIME,TOTAL_AMOUNT,TOTAL_SETTLED) VALUES (1,6,{ts '2016-07-16'},2345,123456,3245);
insert into TBL_PARK_DAILY_SETTLEMENT (id,REGION_ID,PARK_DATE,TOTAL_PARK_TIME,TOTAL_AMOUNT,TOTAL_SETTLED) VALUES (2,6,{ts '2016-07-23'},1302,13958,1395);
insert into TBL_PARK_DAILY_SETTLEMENT (id,REGION_ID,PARK_DATE,TOTAL_PARK_TIME,TOTAL_AMOUNT,TOTAL_SETTLED) VALUES (3,6,{ts '2016-07-30'},13959,115,1395);
insert into TBL_PARK_DAILY_SETTLEMENT (id,REGION_ID,PARK_DATE,TOTAL_PARK_TIME,TOTAL_AMOUNT,TOTAL_SETTLED) VALUES (4,6,{ts '2016-08-06'},13950,1322,135);
insert into TBL_PARK_DAILY_SETTLEMENT (id,REGION_ID,PARK_DATE,TOTAL_PARK_TIME,TOTAL_AMOUNT,TOTAL_SETTLED) VALUES (5,6,{ts '2016-08-13'},13950,13529,139);
insert into TBL_PARK_DAILY_SETTLEMENT (id,REGION_ID,PARK_DATE,TOTAL_PARK_TIME,TOTAL_AMOUNT,TOTAL_SETTLED) VALUES (6,6,{ts '2016-08-20'},3905,13955,5432);

--ParkUnSettlement
insert into TBL_PARK_UNSETTLEMENT (id,VEHICLE_NUMBER,PARK_DATE,REGION_ID,PARK_DURATION,PARK_COST) VALUES (1,'11111',{ts '2016-07-16'},6,3456,3245);
insert into TBL_PARK_UNSETTLEMENT (id,VEHICLE_NUMBER,PARK_DATE,REGION_ID,PARK_DURATION,PARK_COST) VALUES (2,'11111',{ts '2016-07-23'},6,958,695);
insert into TBL_PARK_UNSETTLEMENT (id,VEHICLE_NUMBER,PARK_DATE,REGION_ID,PARK_DURATION,PARK_COST) VALUES (3,'11111',{ts '2016-07-30'},6,115,5395);
insert into TBL_PARK_UNSETTLEMENT (id,VEHICLE_NUMBER,PARK_DATE,REGION_ID,PARK_DURATION,PARK_COST) VALUES (4,'11111',{ts '2016-08-06'},6,322,435);
insert into TBL_PARK_UNSETTLEMENT (id,VEHICLE_NUMBER,PARK_DATE,REGION_ID,PARK_DURATION,PARK_COST) VALUES (5,'22222',{ts '2016-08-13'},6,3529,339);
insert into TBL_PARK_UNSETTLEMENT (id,VEHICLE_NUMBER,PARK_DATE,REGION_ID,PARK_DURATION,PARK_COST) VALUES (6,'22222',{ts '2016-08-20'},6,955,5432);

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

-- vehicle owner
insert into TBL_VEHICLE_OWNER (id, USER_ID) values(1, 1);
insert into TBL_VEHICLE_OWNER (id, USER_ID) values(2, 2);

-- initial vehicles
insert into TBL_VEHICLE(id,plateNumber,OWNER_ID) values(1,'۱۲۳۴۵۶۷۸۹',1);
insert into TBL_VEHICLE(id,plateNumber, OWNER_ID) values(2,'۹۸۷۶۵۴۳۲۱',2);
insert into TBL_VEHICLE(id,plateNumber, OWNER_ID) values(3,'۱۱۱۱۱۱۱۱۱',1);
insert into TBL_VEHICLE(id,plateNumber, OWNER_ID) values(4,'۲۲۲۲۲۲۲۲۲',2);

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

insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (47,'WEEK','هفته چهارم  تیر',{ts '2016-07-16'},{ts '2016-07-22'},13950426,13950501,1395,5,4);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (48,'WEEK','هفته اول مرداد',{ts '2016-07-23'},{ts '2016-07-29'},13950502,13950508,1395,5,1);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (49,'WEEK','هفته دوم مرداد',{ts '2016-07-30'},{ts '2016-08-05'},13950509,13950515,1395,5,2);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (50,'WEEK','هفنه سوم مرداد',{ts '2016-08-06'},{ts '2016-08-12'},13950516,13950522,1395,5,3);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (51,'WEEK','هفنه چهارم مرداد',{ts '2016-08-13'},{ts '2016-08-19'},13950523,13950529,1395,5,4);
insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH,WEEK) VALUES (52,'WEEK','هفته اول شهریور',{ts '2016-08-20'},{ts '2016-08-26'},13950530,13950605,1395,6,1);

insert into TBL_DATE_DIMENSION (id,DATE_DIM_LEVEL,TITLE,START_DATE,END_DATE,START_DATE_FA,END_DATE_FA,YEAR,MONTH) VALUES (53,'MONTH','مرداد',{ts '2016-07-22'},{ts '2016-08-21'},13950501,13950531,1395,5);


--- park region --
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (1,1,6,12,426);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (2,2,6,13,556);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (3,3,6,12,356);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (4,4,6,16,126);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (5,5,6,18,316);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (6,6,6,19,206);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (7,7,6,22,206);
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (8,8,6,722,226)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (9,9,6,883,356)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (10,10,6,72,456)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (11,11,6,66,526)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (12,12,6,58,616)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (13,13,6,49,706)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (14,14,6,32,806)

insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (15,47,6,234,2550)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (16,48,6,154,2550)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (17,49,6,114,2550)
insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (18,50,6,134,2550)

insert into TBL_REGION_PARK_INFO  (id,DATE_DIM_ID,REGION_ID,TOTAL_PARK_DURATION,TOTAL_PARK_COST,YEAR,MONTH,DAY,WEEK) VALUES (19,53,6,280,416)
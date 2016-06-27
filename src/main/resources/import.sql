-- initial cities
insert into TBL_CITY(id,name) values(1,'تهران');
insert into TBL_CITY(id,name) values(2,'سنندج');
insert into TBL_CITY(id,name) values(3,'تبریز');
insert into TBL_CITY(id,name) values(4,'اصفهان');

-- initial regions
insert into TBL_REGION(id, name, address, city_id) values (1, 'ونک', 'ونک', 1);
insert into TBL_REGION(id, name, address, city_id) values (2, 'پونک', 'پونک', 1);
insert into TBL_REGION(id, name, address, city_id) values (3, 'جردن', 'جردن', 1);
insert into TBL_REGION(id, name, address, city_id) values (4, 'ظفر', 'ظفر', 1);
insert into TBL_REGION(id, name, address, city_id) values (5, 'کردستان', 'کردستان', 2);
insert into TBL_REGION(id, name, address, city_id) values (6, 'منطقه یک', 'منطقه یک', 2);

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
insert into TBL_USER(id, firstName,lastName,username,password,active,nationalId) values(1,'behrooz', 'zamani', 'bzd', 'bzd', true,'3733733333');
insert into TBL_USER(id, firstName,lastName,username,password,active,nationalId) values(2,'hossein', 'yeganeh', 'hym', 'hym', true,'3733733334');
insert into TBL_USER(id, firstName,lastName,username,password,active,nationalId) values(3,'Admin', 'Admin', 'admin', 'admin', true,'3733733335');

-- parkban
insert into TBL_PARKBAN(id, user_id) values(1,1);
insert into TBL_PARKBAN(id, user_id) values(2,2);

--parkbanTimeTable
insert into TBL_PARKBAN_TIME_TABLE(id, parkban_id, region_id, work_date) values(1, 1, 5, {ts '2016-06-23'});
insert into TBL_PARKBAN_TIME_TABLE(id, parkban_id, region_id, work_date) values(2, 2, 1, {ts '2016-06-23'});
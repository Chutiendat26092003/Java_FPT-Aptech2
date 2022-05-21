create database if not exists managementStudent;

use managementStudent;

drop table  if exists students;
create table students (
                       studentId varchar(10),
                       name varchar(50),
                       Address varchar(50),
                       phone varchar(20),
                       primary key (id)
);

insert into students value ('B01010', 'Nguyen Tuan Anh', 'Ha Noi', '0955556666');
insert into students value ('B01222', 'Nguyen Hoang Hai', 'Ha Noi', '0955551234');
insert into students value ('B01214', 'Hoang Thi Binh', 'Ha Noi', '0955555252');
insert into students value ('B01950', 'Nguyen Anh Van', 'Ha Noi', '0955545466');
create database if not exists emusicstore;

use emusicstore;

drop table  if exists musics;
create table musics (
                        id varchar(20),
                        name varchar(50),
                        author varchar(50),
                        year varchar(20),
                        primary key (id)
);

insert into books value ('101', 'Ngay dau tien di hoc', 'Nguyen Ngoc Thien', 2019);
insert into books value ('102', 'Vui den truong', 'Nguyen Van Trung', 2019);
insert into books value ('103', 'Em di mau giao', 'Duong Minh Vien',2015);
insert into books value ('104', 'Be vui den truong', 'Do Anh Hung', 2015);
insert into books value ('105', 'Bai ca di hoc', 'Phan Tran Bang', 2015);
insert into books value ('106', 'Chau len ba', 'Pham Minh Tuan', 2019);
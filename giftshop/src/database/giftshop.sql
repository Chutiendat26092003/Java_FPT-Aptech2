create database if not exists egiftshop;

use egiftshop;

drop table  if exists gifts;
create table gifts (
                       id int,
                       name varchar(50),
                       price float,
                       qty int,
                       primary key (id)
);

insert into gifts value (101, 'Gau bong', 15.5, 20);
insert into gifts value (102, 'Hop but', 20.2, 30);
insert into gifts value (103, 'Vo', 5.3, 50);
insert into gifts value (104, 'Hinh dan', 5, 50);
insert into gifts value (105, 'Tay', 3, 50);
insert into gifts value (106, 'But bi', 5, 50);
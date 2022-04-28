create database if not exists ebookshop;

user ebookshop;

drop table  if exists books;
create table books (
    id int,
    title varchar(50),
    author varchar(50),
    price float,
    qty int,
    primary key (id)
);

insert into books value (1001, 'Java for dummies', 'Dang Kim Thi', 11.11, 11);
insert into books value (1002, 'More Java for dummies', 'CodeLean VN', 22.22, 22);
insert into books value (1003, 'More Java for more dummies', 'Mohamad Ali', 33.33, 33);
insert into books value (1004, 'A Cup of Java', 'Kumar', 44.44, 44);
insert into books value (1005, 'A Teaspoon of Java', 'Kevin Jones', 55.0, 55);
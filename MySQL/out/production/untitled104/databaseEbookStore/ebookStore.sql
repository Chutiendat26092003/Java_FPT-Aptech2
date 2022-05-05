create database if not exists eBookStore;
use eBookStore;

drop table  if exists categories;
CREATE TABLE categories(
                           categoryID INT NOT NULL,
                           categoryName varchar(50),
                           PRIMARY KEY (categoryID)
);

insert into categories value (1001, 'Truyen');
insert into categories value (1002, 'Hai');
insert into categories value (1003, 'Van hoc');


drop table  if exists books;
CREATE TABLE books(
                      bookID INT NOT NULL,
                      bookName varchar(50),
                      price DECIMAL,
                      author varchar(50),
                      qty int,
                      categoryID INT NOT NULL,
                      PRIMARY KEY (bookID),

                      FOREIGN KEY (categoryID)
                          REFERENCES categories(categoryID)
                          ON UPDATE CASCADE ON DELETE RESTRICT
);

insert into books value (1, 'Rua va tho', 50.000, 'Jack', 50, 1001);
insert into books value (2, 'Dac nhan tam', 80.000, 'Jack', 50, 1003);
insert into books value (3, 'Chuyen luat su', 60.000, 'Recce', 50, 1002);
insert into books value (4, 'Chuyen vo chong', 30.000, 'Recce', 50, 1002);
insert into books value (5, 'Tuyet chieu', 50.000, 'Kim Dong', 50, 1002);
insert into books value (6, 'Dan ong la vua to mo', 50.000, 'Adam', 50, 1002);
insert into books value (7, 'Nha Gia Kim', 100.000, 'Mount', 50, 1003);
insert into books value (8, 'Cafe sang', 90.000, 'Tony', 50, 1003);
insert into books value (9, 'Cafe toi', 90.000, 'Tony', 50, 1003);
insert into books value (10, 'Cha giau cha ngheo', 50.000, 'Jack', 50, 1003);
insert into books value (11, 'Ech ngoi day gieng', 50.000, 'Dan gian', 50, 1001);
insert into books value (12, 'Chua son lam', 50.000, 'Kim Bach', 50, 1001);
insert into books value (13, 'Bach khoa toan thu', 50.000, 'Kim DOng', 50, 1001);
insert into books value (14, 'Thay boi xem voi', 50.000, 'Thay boi', 50, 1002);
insert into books value (15, 'Xem que', 50.000, 'Thay boi', 50, 1002);




drop table  if exists customers;
CREATE TABLE customers(
                          customerID INT NOT NULL,
                          customerName varchar(50),
                          tell varchar(20),
                          address varchar(100),
                          PRIMARY KEY (customerID)
);

insert into customers value (101, 'Nguyen Dac Trung', '0399995555', 'Ha Noi');
insert into customers value (102, 'Phan Van Tu', '0399995544', 'Ha Noi');
insert into customers value (103, 'Nguyen Tung Duong', '0352523555', 'Ha Noi');
insert into customers value (104, 'Luu Quan Du', '0392125255', 'Ha Noi');



drop table  if exists orders;
CREATE TABLE orders(
                       orderID INT NOT NULL,
                       customerID INT NOT NULL,
                       orderDate DATETIME,
                       status char,
                       PRIMARY KEY (orderID),

                       FOREIGN KEY (customerID)
                           REFERENCES customers(customerID)
                           ON UPDATE CASCADE ON DELETE RESTRICT
);

insert into orders value (1000001, 101, '2022-5-5', '0');
insert into orders value (1000002, 101, '2022-5-5', '1');
insert into orders value (1000003, 102, '2022-5-5', '1');
insert into orders value (1000004, 103, '2022-5-5', '2');
insert into orders value (1000005, 104, '2022-5-5', '2');
insert into orders value (1000006, 101, '2022-5-5', '3');
insert into orders value (1000007, 102, '2022-5-5', '3');
insert into orders value (1000008, 102, '2022-5-5', '4');
insert into orders value (1000009, 103, '2022-5-5', '5');



drop table  if exists orderDetails;
CREATE TABLE orderDetails(
                             orderID INT NOT NULL,
                             bookID INT NOT NULL,
                             qty int,
                             price DECIMAL,


                             FOREIGN KEY (bookID)
                                 REFERENCES books(bookID)
                                 ON UPDATE CASCADE ON DELETE RESTRICT,

                             FOREIGN KEY (orderID)
                                 REFERENCES orders(orderID)
                                 ON UPDATE CASCADE ON DELETE RESTRICT
);


insert into orderDetails value (1000001, 1, 20, 50.000);
insert into orderDetails value (1000002, 2, 20, 50.000);
insert into orderDetails value (1000003, 3, 20, 50.000);
insert into orderDetails value (1000004, 5, 20, 50.000);
insert into orderDetails value (1000005, 7, 20, 50.000);
insert into orderDetails value (1000006, 9, 20, 50.000);
insert into orderDetails value (1000007, 11, 20, 50.000);
insert into orderDetails value (1000008, 13, 20, 50.000);
insert into orderDetails value (1000009, 1, 20, 50.000);



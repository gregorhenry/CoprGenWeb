DROP DATABASE IF EXISTS dw;


CREATE DATABASE dw
CHARACTER SET utf8
COLLATE utf8_general_ci;

use dw;

create table User(
ID_user int NOT NULL auto_increment,
Email varchar(30) unique,
Name varchar(20),
Lastname varchar (20),
Password varchar(16) not null ,
primary key(ID_user)

);

create table Profile(
ID_profile  int NOT NULL auto_increment,
Description varchar(30),
Name varchar(40),
primary key(ID_profile)
);

create table Contact(
ID_contact int NOT NULL auto_increment,
Name varchar(20),
Phone int(9),
Email varchar(30) unique,
primary key(ID_contact)
);

create table Promotions(
ID_promotion int NOT NULL auto_increment,
Name varchar(20),
Price numeric(8,0) ,
Picture varchar(50),
Description varchar(40),
TimeIni time,
TimeEnd time,
primary key(ID_promotion)
);

create table Products(
ID_product int NOT NULL auto_increment,
Name varchar(30),
Price numeric(8,2),
Picture varchar(50),
Description varchar(40),
primary key(ID_product)
);

create table Notification(
ID_notification int NOT NULL auto_increment,
Title varchar(30),
Timeto time,
Description varchar(40),
primary key(ID_notification)
);

ALTER TABLE User ADD ID_profile int NOT NULL;
ALTER TABLE User ADD CONSTRAINT fk_id_profile FOREIGN KEY (ID_profile) REFERENCES Profile(ID_profile);

ALTER TABLE Profile ADD ID_contact int NOT NULL;
ALTER TABLE Profile ADD CONSTRAINT fk_id_contact FOREIGN KEY (ID_contact) REFERENCES Contact(ID_contact);

ALTER TABLE Profile ADD ID_promotion int NOT NULL;
ALTER TABLE Profile ADD CONSTRAINT fk_id_promotion FOREIGN KEY (ID_promotion) REFERENCES Promotions(ID_promotion);

ALTER TABLE Profile ADD ID_product int NOT NULL;
ALTER TABLE Profile ADD CONSTRAINT fk_id_product FOREIGN KEY (ID_product) REFERENCES Products(ID_product);

ALTER TABLE Profile ADD ID_notification int NOT NULL;
ALTER TABLE Profile ADD CONSTRAINT fk_id_notification FOREIGN KEY (ID_notification) REFERENCES Notification(ID_notification);

alter table Promotions add TimeIni time;
alter table Promotions add TimeEnd time;

ALTER TABLE Notification ADD ID_promotion int NOT NULL;
ALTER TABLE Notification ADD CONSTRAINT fk_id_promotion FOREIGN KEY (ID_promotion) REFERENCES Promotions(ID_promotion);
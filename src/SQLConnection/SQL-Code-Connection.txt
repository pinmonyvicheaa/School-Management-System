create database school_management_system;
use school_management_system;

CREATE TABLE login (
  name VARCHAR(200),
    userid VARCHAR(200),
    password VARCHAR(200)
);
INSERT INTO login (name, userid, password) VALUES ('Vichea', 'vichea', '123');

CREATE TABLE student (
    studentid VARCHAR(10) PRIMARY KEY,
    studentname VARCHAR(100),
    sex CHAR(1),
    enrolldate date,
    phonenum VARCHAR(255),
    email VARCHAR(100),
    address VARCHAR(255),
    photo LONGBLOB NOT NULL
);
create table course(courseid int(11) primary key, course varchar(255), duration varchar(255));
create table fee(fid int(11) primary key, studentname varchar(255), amount int(20));

CREATE TABLE class (
    id INT(11) AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);
CREATE TABLE subject (
    id INT(11) AUTO_INCREMENT,
    subject VARCHAR(255),
    PRIMARY KEY (id)
);
create table timetable(id int(11) AUTO_INCREMENT, class varchar(255), subject varchar(255), days varchar(255), time varchar(255), primary key (id));

CREATE TABLE date (
    id INT(11) AUTO_INCREMENT,
    datee date,
    PRIMARY KEY (id)
);

CREATE TABLE stuname (
    id INT(11) AUTO_INCREMENT,
    stunamee VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE subjects (
    id INT(11) AUTO_INCREMENT,
    subject VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE status (
    id INT(11) AUTO_INCREMENT,
    statuss VARCHAR(255),
    PRIMARY KEY (id)
);

create table attendance(id INT(11) AUTO_INCREMENT, date varchar(255), stuname varchar(255), subjects varchar(255), status varchar(255), days varchar(255), time varchar(255), PRIMARY KEY (id));
create database studentdatabase;
use studentdatabase;
create table student
(
id int primary key auto_increment,
name varchar(50),
department varchar(50),
country varchar(50)
);
use studentdatabase;
insert into student(name,department,country)
values ('Monika','E&TC','INDIA');
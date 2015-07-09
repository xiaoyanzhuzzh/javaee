use user_management;

drop table users;

create table users (
  id int(11) NOT NULL auto_increment,
  name varchar(30) NOT NULL,
  gender varchar(10) NOT NULL,
  age int(6) NOT NULL,
  email varchar(40) default NULL,
  PRIMARY KEY  (id)
);


insert into users values(null,'张志慧','女',22,'zhzhang1993@outlook.com');

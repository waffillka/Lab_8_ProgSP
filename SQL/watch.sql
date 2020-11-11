create table Watch(
id INT NOT NULL AUTO_INCREMENT,
    nameWatch varchar(40) default null,
    typeWatch varchar(40) default null,
    price double default null,
    count int default null,
    manufacturer varchar(40) default null,
    country varchar(40) default null,
    primary key(id)
);
CREATE TABLE User 
(
	id INT NOT NULL AUTO_INCREMENT,
    firstName varchar(40) default null,
    surname varchar(40) default null,
    username varchar(100) default null,
    password varchar(50) default null,
    contactPhone varchar(15) default null,
    primary key(id)
)
 
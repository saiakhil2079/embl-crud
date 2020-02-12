CREATE TABLE person
(
firstname varchar(100) not null,
lastname varchar (100) not null,
age int not null,
favouritecolour varchar(20) not null,
hobby varchar(300) not null,
PRIMARY KEY (firstname, lastname, age)
);
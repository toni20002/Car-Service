DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    user_id     int PRIMARY KEY auto_increment,
    username    varchar(255) not null unique,
    email       varchar(255) not null unique,
    password    varchar(255) not null unique,
    firstName   varchar(255) not null,
    lastName    varchar(255) not null,
    phoneNumber varchar(255) not null unique,
    creationTime timestamp    not null,
    role        varchar(255) not null
);
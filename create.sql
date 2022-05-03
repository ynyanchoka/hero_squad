SET MODE PostgresSQL;

CREATE DATABASE heroin;

CREATE TABLE hero (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    age INT,
    power VARCHAR,
    weakness VARCHAR,
    squadName VARCHAR,

);

CREATE TABLE squad (
    id int PRIMARY KEY auto_increment,
    squadName VARCHAR,
    cause VARCHAR,
    squadSize INT,

);

CREATE DATABASE heroin_test WITH TEMPLATE heroSquad;
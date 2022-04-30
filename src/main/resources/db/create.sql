SET MODE PostgresSQL;

CREATE TABLE IF NOT EXISTS heroes (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    age INT,
    power VARCHAR,
    weakness VARCHAR,

);

CREATE TABLE IF NOT EXISTS squad (
    id int PRIMARY KEY auto_increment,
    squadName VARCHAR,
    cause VARCHAR,
    squadSize INT,

);
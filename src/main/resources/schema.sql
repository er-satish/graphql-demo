CREATE SCHEMA IF NOT EXISTS mys;

CREATE TABLE IF NOT EXISTS mys.ADDRESS
(
    ADDRESS_ID INT NOT NULL IDENTITY,
    STREET_NAME VARCHAR(100),
    CITY VARCHAR(100)
);
CREATE TABLE IF NOT EXISTS mys.CLIENT
(
    CLIENT_ID INT NOT NULL IDENTITY,
    FST_NAME VARCHAR(100),
    LST_NAME VARCHAR(100),
    MID_NAME VARCHAR(100),
    ADDRESS_ID INT,
    CONSTRAINT XIFADDRESS FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS("ADDRESS_ID")
);


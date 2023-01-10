CREATE DATABASE people;

USE people;

CREATE TABLE person
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    age            INT,
    salary         DOUBLE,
    passport       CHAR(10),
    address        VARCHAR(200),
    dateofbirthday DATE,
    datetimecreate DATETIME,
    timetolunch    TIME,
    letter         TEXT
);

INSERT INTO person
VALUES (NULL, 20, 2000.00, '4124567JK8', 'Minsk, Svobody Str. 10', '2002-12-11', '2022-10-12 10:22:02', '12:00:00',
        'He is a very important person'),
       (NULL, 19, 1500.00, '4904567JO8', 'Londod, Becker Str. 553', '2003-11-10', '2022-08-08 08:02:07', '12:30:00',
        'He is a good worker'),
       (NULL, 27, 2200.00, '9824567EK5', 'New York, New Str. 23B', '1995-07-22', '2021-07-21 15:37:11', '11:30:00',
        'He is our manager'),
       (NULL, 22, 1800.00, '4395KRO983', 'Moskow, Red Str. 123', '2000-03-02', '2020-02-12 10:48:43', '12:15:00',
        'He must work better'),
       (NULL, 35, 2500.00, '870374KR12', 'Minsk, Nezavisimosti Str 123/23', '1987-05-30', '2018-07-30 16:45:02',
        '13:00:00', 'I dont now this person');


SELECT *
FROM person
WHERE age > 21
ORDER BY datetimecreate;
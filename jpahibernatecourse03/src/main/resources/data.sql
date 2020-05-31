/* when we use hibernate , hibernate create table for us from entity class
create table person
(
   id integer not null,
   name varchar(255) not null,
   location varchar(255),
   birth_date timestamp,
   visible boolean default true,
   primary key(id)
);
*/

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 

VALUES(10001,  'Ali', 'Istanbul','1994-04-08 00:00:00');

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 

VALUES(10002,  'Dogan', 'St.Petersburg','1994-04-08 00:00:00');

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) 

VALUES(10003,  'Kristen', 'St.Petersburg','1993-05-19 00:00:00');
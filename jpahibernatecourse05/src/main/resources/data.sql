INSERT INTO course(id,name, created_date, last_updated_date) VALUES (10001, 'Data Structures', sysdate(), sysdate());
INSERT INTO course(id,name, created_date, last_updated_date) VALUES (10002, 'CS50', sysdate(), sysdate());
INSERT INTO course(id,name, created_date, last_updated_date) VALUES (10003, 'IOS', sysdate(), sysdate());


INSERT INTO passport(id,number) VALUES (30001,'TR00222');
INSERT INTO passport(id,number) VALUES (30002,'FF02021');
INSERT INTO passport(id,number) VALUES (30003,'US1231');



INSERT INTO student(id,name,passport_id) VALUES (20001,'Jane',30001);
INSERT INTO student(id,name,passport_id) VALUES (20002,'Dane',30002);
INSERT INTO student(id,name,passport_id) VALUES (20003,'Maria',30003);






INSERT INTO review(id,rating,description) VALUES (40001,'1','first comment');
INSERT INTO review(id,rating,description) VALUES (40002,'2','second comment');
INSERT INTO review(id,rating,description) VALUES (40003,'3','third comment');
INSERT INTO course(id,name, created_date, last_updated_date, is_deleted) VALUES (10001, 'Data Structures', sysdate(), sysdate(),false);
INSERT INTO course(id,name, created_date, last_updated_date, is_deleted) VALUES (10002, 'CS50', sysdate(), sysdate(),false);
INSERT INTO course(id,name, created_date, last_updated_date, is_deleted) VALUES (10003, 'IOS', sysdate(), sysdate(),false);


INSERT INTO passport(id,number) VALUES (30001,'TR00222');
INSERT INTO passport(id,number) VALUES (30002,'FF02021');
INSERT INTO passport(id,number) VALUES (30003,'US1231');


INSERT INTO student(id,name,passport_id) VALUES (20001,'Jane',30001);
INSERT INTO student(id,name,passport_id) VALUES (20002,'Dane',30002);
INSERT INTO student(id,name,passport_id) VALUES (20003,'Maria',30003);



INSERT INTO review(id,rating,description,course_id,student_id) VALUES (40001,'5','comment from Maria to DataStructures course',10001,20003);
INSERT INTO review(id,rating,description,course_id,student_id) VALUES (40002,'5','comment from Dane to DataStructures course',10001,20002);
INSERT INTO review(id,rating,description,course_id,student_id) VALUES (40003,'5','comment from Dane to IOS course',10003,20002);


INSERT INTO student_course(student_id,course_id) VALUES (20001,10001);
INSERT INTO student_course(student_id,course_id) VALUES (20002,10001);
INSERT INTO student_course(student_id,course_id) VALUES (20003,10001);
INSERT INTO student_course(student_id,course_id) VALUES (20003,10003);

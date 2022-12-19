SELECT * FROM hanbit_member;

SELECT id,password,name,nick,question,answer,tel,enabled,member_type,license_no,gender,work_history,location,work_type
FROM hanbit_member WHERE id='java';

INSERT INTO hanbit_member(id,password,name,nick,question,answer,tel) VALUES('java','a','이지은','아이유','나의 노래방 애창곡은?','좋은날','01012345678');

DELETE FROM hanbit_member WHERE id='zzzzz'; 

SELECT COUNT(*) FROM hanbit_member WHERE nick='아이유';

SELECT id FROM hanbit_member WHERE name='박진수' AND tel='01028355343';

SELECT password FROM hanbit_member WHERE id='spring' AND name='박진수' AND tel='01028355343' AND question='나의 출신 초등학교는?' AND answer='문성초';
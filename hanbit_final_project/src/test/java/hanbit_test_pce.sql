SELECT * FROM hanbit_member;

SELECT id,password,name,nick,question,answer,tel,enabled,member_type,license_no,gender,work_history,location,work_type
FROM hanbit_member WHERE id='java';

INSERT INTO hanbit_member(id,password,name,nick,question,answer,tel) VALUES('java','a','이지은','아이유','나의 노래방 애창곡은?','좋은날','01012345678');

DELETE FROM hanbit_member WHERE id='zzzzz'; 

SELECT COUNT(*) FROM hanbit_member WHERE nick='아이유';
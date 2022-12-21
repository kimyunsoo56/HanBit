CREATE TABLE hanbit_free_board(
	free_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content CLOB NOT NULL,
	time_posted DATE DEFAULT SYSDATE,
	hits NUMBER DEFAULT 0,
	category VARCHAR2(100), 
	image VARCHAR2(100),
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT hanbit_free_board_fk FOREIGN KEY(id) REFERENCES hanbit_member(id)
)
select id from HANBIT_MEMBER
SELECT * FROM hanbit_free_board;
insert into hanbit_free_board (free_no,title,content,time_posted,hits,category,image,id)
values(hanbit_free_board_seq.nextval,'테스트 중입니다','테스트 중입니다',sysdate,0,'자유',null,'java')

SELECT id,password FROM hanbit_member;


INSERT INTO hanbit_member(id,password,name,nick,question,answer,tel) 
VALUES('test1','a','test1','test1','나의 노래방 애창곡은?','좋은날','9898989898');
INSERT INTO hanbit_member(id,password,name,nick,question,answer,tel) 
VALUES('test2','a','test2','test2','나의 노래방 애창곡은?','좋은날','7897897');
INSERT INTO hanbit_member(id,password,name,nick,question,answer,tel) 
VALUES('test3','a','test3','test3','나의 노래방 애창곡은?','좋은날','78978968');
INSERT INTO hanbit_member(id,password,name,nick,question,answer,tel) 
VALUES('test4','a','test4','test4','나의 노래방 애창곡은?','좋은날','678678');
INSERT INTO hanbit_member(id,password,name,nick,question,answer,tel) 
VALUES('test5','a','test5','test5','나의 노래방 애창곡은?','좋은날','098578');
INSERT INTO hanbit_member(id,password,name,nick,question,answer,tel) 
VALUES('test6','a','test6','test6','나의 노래방 애창곡은?','좋은날','567756');
INSERT INTO hanbit_member(id,password,name,nick,question,answer,tel) 
VALUES('test7','a','test7','test7','나의 노래방 애창곡은?','좋은날','678678');
INSERT INTO hanbit_member(id,password,name,nick,question,answer,tel) 
VALUES('test8','a','test8','test7','나의 노래방 애창곡은?','좋은날','567568');



insert into hanbit_free_board (free_no,title,content,time_posted,hits,category,image,id)
values(hanbit_free_board_seq.nextval,'테스트 중입니다','테스트 중입니다',sysdate,0,'자유',null,'spring');
insert into hanbit_free_board (free_no,title,content,time_posted,hits,category,image,id)
values(hanbit_free_board_seq.nextval,'테스트 중입니다','테스트 중입니다',sysdate,0,'자유',null,'spring');
insert into hanbit_free_board (free_no,title,content,time_posted,hits,category,image,id)
values(hanbit_free_board_seq.nextval,'테스트 중입니다','테스트 중입니다',sysdate,0,'자유',null,'spring');
insert into hanbit_free_board (free_no,title,content,time_posted,hits,category,image,id)
values(hanbit_free_board_seq.nextval,'테스트 중입니다','테스트 중입니다',sysdate,0,'자유',null,'spring');
insert into hanbit_free_board (free_no,title,content,time_posted,hits,category,image,id)
values(hanbit_free_board_seq.nextval,'테스트 중입니다','테스트 중입니다',sysdate,0,'자유',null,'spring');
insert into hanbit_free_board (free_no,title,content,time_posted,hits,category,image,id)
values(hanbit_free_board_seq.nextval,'테스트 중입니다','테스트 중입니다',sysdate,0,'자유',null,'spring');

CREATE TABLE hanbit_report_board(
report_no NUMBER 
)
select * from hanbit_report_board;

select * from HANBIT_COMMENT;
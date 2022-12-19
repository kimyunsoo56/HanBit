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


-- 한빛 회원 테이블 
SELECT * FROM hanbit_member;

commit

hanbit_member(
	id	VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	nick VARCHAR2(100) NOT NULL,
	question VARCHAR2(100) NOT NULL,
	answer VARCHAR2(100) NOT NULL,
	tel NUMBER NOT NULL UNIQUE,
	enabled NUMBER DEFAULT 1 NOT NULL,
	member_type NUMBER DEFAULT 1 NOT NULL, 
	license_no NUMBER UNIQUE,
	gender VARCHAR2(100) CHECK(gender IN('남성','여성')),
	work_history VARCHAR2(100),
	location VARCHAR2(100),
	work_type VARCHAR2(100) CHECK(work_type IN('자택근무','병원근무'))
)

select id,password,name,nick,question,answer,tel,enabled,member_type,license_no,gender,work_history,location,work_type from hanbit_member where id='spring' and password='a';

select id,password,name,nick,question,answer,tel,enabled,member_type,license_no,gender,work_history,location,work_type from hanbit_member where id='spring';

insert into (id,password,name,nick,question,answer,tel,enabled,member_type,license_no,gender,work_history,location,work_type)
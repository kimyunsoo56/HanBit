CREATE TABLE hanbit_member(
	id	VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	nick VARCHAR2(100) NOT NULL,
	question VARCHAR2(100) NOT NULL,
	answer VARCHAR2(100) NOT NULL,
	tel NUMBER NOT NULL UNIQUE,
	enabled NUMBER DEFAULT 1 NOT NULL,
	license_no NUMBER UNIQUE,
	gender VARCHAR2(100) CHECK(gender IN('남성','여성')),
	work_history VARCHAR2(100),
	location VARCHAR2(100),
	work_type VARCHAR2(100) CHECK(work_type IN('자택근무','병원근무'))
)
DROP TABLE hanbit_member;
SELECT * FROM hanbit_member;

CREATE TABLE hanbit_authorities(
	id VARCHAR2(100) NOT NULL,
	authority VARCHAR2(30) NOT NULL,
	CONSTRAINT hanbit_authorities_fk FOREIGN KEY(id) REFERENCES hanbit_member(id),
	CONSTRAINT hanbit_member_authorities PRIMARY KEY(id,authority)
)
DROP TABLE hanbit_authorities;
SELECT * FROM hanbit_authorities;

CREATE TABLE notice_board(
	notice_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content CLOB NOT NULL,
	time_posted DATE DEFAULT SYSDATE(YY-MM-DD HH:mm),
	hits NUMBER DEFAULT 0,
	category VARCHAR2(100) 
)



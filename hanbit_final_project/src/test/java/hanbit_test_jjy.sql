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

--로그인
SELECT id,password,name,nick,question,answer,tel,enabled,member_type,license_no,gender,work_history,location,work_type from hanbit_member where id='spring' and password='a';

-- 아이디로 회원정보조회
SELECT id,password,name,nick,question,answer,tel,enabled,member_type,license_no,gender,work_history,location,work_type from hanbit_member where id='spring';

-- 요양보호사 등록
INSERT INTO hanbit_member
VALUES ('springboot','a','김요양','요양천사','가장 기억에 남는 장소는?','집',01012345678,default,2,1112223334,'여성','3년','서울','자택근무');


UPDATE hanbit_member SET enabled=2 where id='test6' and password='a' and question='나의 노래방 애창곡은?' and answer='좋은날';

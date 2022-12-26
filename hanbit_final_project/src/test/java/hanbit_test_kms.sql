-- 한빛 회원 테이블 생성
CREATE TABLE hanbit_member_msk(
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

insert into hanbit_member_msk(id,password,name,nick,question,answer,tel,enabled,member_type)
values ('minseok0316','a','김민석','민석의닉네임','나의 보물 2호는??','보물2호',01012345,default,default);

insert into hanbit_member_msk
values ('yoyangsa','a','요양사이름','요양사닉네임','나의 보물 3호는??','보물3호',010123456,default,2,789456123,'여성','병원에서 3년','경기도','자택근무');

insert into hanbit_member_msk
values ('yoyangsa2','a','요양사이름2','요양사닉네임2','나의 보물 4호는??','보물4호',0101234567,default,2,1354885,'남성','난 경력이 없슴다','서울','병원근무');

insert into hanbit_member_msk
values ('yoyangsa3','a','콜드','colde','나의 보물 5호는??','보물5호',010123452,default,2,1352885,'남성','앨범을 냈습니다','대전','자택근무');

DROP TABLE hanbit_member;
SELECT * FROM hanbit_member_msk;

-- 한빛 매칭 게시판 테이블 생성
CREATE TABLE hanbit_match_board_msk(
	match_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content CLOB NOT NULL,
	time_posted DATE not null,
	hits NUMBER DEFAULT 0,
	image VARCHAR2(100),
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT hanbit_match_board_msk_fk FOREIGN KEY(id) REFERENCES hanbit_member_msk(id)
)

select b.title,b.content,b.time_posted,b.hits,b.image,m.id,m.name,m.location,m.gender,m.work_type,m.work_history
from hanbit_match_board_msk b
inner join hanbit_member_msk m on b.id=m.id
where b.match_no=2


insert into hanbit_match_board_msk values (hanbit_match_board_msk_seq.nextval,'경력 10년의 요양보호사 입니다!','소개글 내용입니다!',sysdate,5,12345,'yoyangsa')
insert into hanbit_match_board_msk values (hanbit_match_board_msk_seq.nextval,'경력 15년의 요양보호사 입니다!','소개글 내용입니다2!',sysdate,11,1234,'yoyangsa2')
insert into hanbit_match_board_msk values (hanbit_match_board_msk_seq.nextval,'경력 21년의 요양보호사 입니다!','최선을 다하겠습니다!!',sysdate,100,1224,'yoyangsa3')


CREATE SEQUENCE hanbit_match_board_msk_seq;
DROP TABLE hanbit_match_board_msk;
drop SEQUENCE hanbit_match_board_msk_seq;
SELECT * FROM hanbit_match_board_msk;

select b.match_no,b.title,b.content,b.time_posted,b.hits,b.image,m.id,m.name,m.location,m.gender,m.work_type
from hanbit_match_board_msk b
inner join hanbit_member_msk m on b.id=m.id

select id from hanbit_member_msk WHERE MEMBER_TYPE=2;


-- 한빛 쪽지 테이블 생성 
CREATE TABLE hanbit_message_msk(
	message_no NUMBER PRIMARY KEY,
	content CLOB NOT NULL,
	checking NUMBER DEFAULT 0,
	time_posted DATE DEFAULT SYSDATE,
	send_id VARCHAR2(100) NOT NULL,
	receive_id VARCHAR2(100) NOT NULL,
	CONSTRAINT msk_send_id_msk_fk FOREIGN KEY(send_id) REFERENCES hanbit_member_msk(id),	
	CONSTRAINT msk_receive_id_msk_fk FOREIGN KEY(receive_id) REFERENCES hanbit_member_msk(id)
)
CREATE SEQUENCE hanbit_message_msk_seq;
DROP TABLE hanbit_message_msk;
DROP SEQUENCE hanbit_message_seq_msk;
SELECT * FROM hanbit_message_msk;

insert into hanbit_message_msk values(hanbit_message_msk_seq.nextval,'번호를 알 수 있을까요?',sysdate,'spring')


SELECT COUNT(*)
		FROM   hanbit_match_board b
		inner join hanbit_member m on b.id=m.id
		where m.location='경기' and m.gender='남성' and m.work_type='자택근무'











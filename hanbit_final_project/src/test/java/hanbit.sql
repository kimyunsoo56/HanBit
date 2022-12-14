-- 한빛 회원 테이블 생성
CREATE TABLE hanbit_member(
	id	VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	nick VARCHAR2(100) NOT NULL,
	question VARCHAR2(100) NOT NULL,
	answer VARCHAR2(100) NOT NULL,
	tel VARCHAR2(100) NOT NULL UNIQUE,
	enabled NUMBER DEFAULT 1 NOT NULL,
	member_type NUMBER DEFAULT 1 NOT NULL, 
	license_no NUMBER UNIQUE,
	gender VARCHAR2(100) CHECK(gender IN('남성','여성')),
	work_history VARCHAR2(100),
	location VARCHAR2(100),
	work_type VARCHAR2(100) CHECK(work_type IN('자택근무','병원근무'))
)
DROP TABLE hanbit_member;
SELECT * FROM hanbit_member;


-- 한빛 알림 게시판 테이블 생성
CREATE TABLE hanbit_notice_board(
	notice_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content CLOB NOT NULL,
	time_posted DATE DEFAULT SYSDATE,
	hits NUMBER DEFAULT 0,
	category VARCHAR2(100), 
	image VARCHAR2(1000),
	link VARCHAR2(200),
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT hanbit_notice_board_fk FOREIGN KEY(id) REFERENCES hanbit_member(id)
)
CREATE SEQUENCE hanbit_notice_board_seq;
DROP TABLE hanbit_notice_board;
SELECT * FROM hanbit_notice_board;
DROP SEQUENCE hanbit_notice_board_seq;




-- 한빛 자유 게시판 테이블 생성
CREATE TABLE hanbit_free_board(
	free_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content CLOB NOT NULL,
	time_posted DATE DEFAULT SYSDATE,
	hits NUMBER DEFAULT 0,
	category VARCHAR2(100), 
	image VARCHAR2(1000),
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT hanbit_free_board_fk FOREIGN KEY(id) REFERENCES hanbit_member(id)
)
CREATE SEQUENCE hanbit_free_board_seq;
DROP TABLE hanbit_free_board;
DROP SEQUENCE hanbit_free_board_seq;
SELECT * FROM hanbit_free_board;

-- 한빛 알림 게시판 댓글 테이블 생성
CREATE TABLE hanbit_notice_comment(
	comment_no NUMBER PRIMARY KEY,
	content CLOB NOT NULL,
	time_posted DATE DEFAULT SYSDATE,
	id VARCHAR2(100) NOT NULL,
	notice_no NUMBER NOT NULL,
	CONSTRAINT hanbit_notice_comment_fk FOREIGN KEY(id) REFERENCES hanbit_member(id),
	CONSTRAINT hanbit_notice_comment_no_fk FOREIGN KEY(notice_no) REFERENCES hanbit_notice_board(notice_no) ON DELETE CASCADE
)
CREATE SEQUENCE hanbit_notice_comment_seq;
DROP TABLE hanbit_notice_comment;
DROP SEQUENCE hanbit_notice_comment_seq;
SELECT * FROM hanbit_notice_comment;

-- 한빛 자유 댓글 테이블 생성
CREATE TABLE hanbit_comment(
	comment_no NUMBER PRIMARY KEY,
	content CLOB NOT NULL,
	time_posted DATE DEFAULT SYSDATE,
	id VARCHAR2(100) NOT NULL,
	free_no NUMBER NOT NULL,
	CONSTRAINT hanbit_free_comment_fk FOREIGN KEY(id) REFERENCES hanbit_member(id),
	CONSTRAINT hanbit_free_comment_no_fk FOREIGN KEY(free_no) REFERENCES hanbit_free_board(free_no) ON DELETE CASCADE
)
CREATE SEQUENCE hanbit_comment_seq;
DROP TABLE hanbit_comment;
DROP SEQUENCE hanbit_comment_seq;
SELECT * FROM hanbit_comment;


-- 한빛 매칭 게시판 테이블 생성
CREATE TABLE hanbit_match_board(
	match_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content CLOB NOT NULL,
	time_posted DATE DEFAULT SYSDATE,
	hits NUMBER DEFAULT 0,
	image VARCHAR2(1000),
	id VARCHAR2(100) NOT NULL,
	CONSTRAINT hanbit_match_board_fk FOREIGN KEY(id) REFERENCES hanbit_member(id)
)
CREATE SEQUENCE hanbit_match_board_seq;
DROP TABLE hanbit_match_board;
DROP SEQUENCE hanbit_match_board_seq;
SELECT * FROM hanbit_match_board;


-- 한빛 매칭 좋아요 테이블 생성
CREATE TABLE hanbit_likes(
	id VARCHAR2(100),
	match_no NUMBER,
	CONSTRAINT hanbit_likes_id_fk FOREIGN KEY(id) REFERENCES hanbit_member(id),
	CONSTRAINT hanbit_likes_no_fk FOREIGN KEY(match_no) REFERENCES hanbit_match_board(match_no) ON DELETE CASCADE,
	CONSTRAINT hanbit_likes_pk PRIMARY KEY(id,match_no) 
)

DROP TABLE hanbit_likes;
SELECT * FROM hanbit_likes;

-- 한빛 쪽지 테이블 생성  // 캐스케이드 고려안함
CREATE TABLE hanbit_message(
	message_no NUMBER PRIMARY KEY,
	content CLOB NOT NULL,
	checking NUMBER DEFAULT 0,
	time_posted DATE DEFAULT SYSDATE,
	send_id VARCHAR2(100) NOT NULL,
	receive_id VARCHAR2(100) NOT NULL,
	CONSTRAINT hanbit_message_send_id_fk FOREIGN KEY(send_id) REFERENCES hanbit_member(id),	
	CONSTRAINT hanbit_message_receive_id_fk FOREIGN KEY(receive_id) REFERENCES hanbit_member(id)
)
CREATE SEQUENCE hanbit_message_seq;
DROP TABLE hanbit_message;
DROP SEQUENCE hanbit_message_seq;
SELECT * FROM hanbit_message;

INSERT INTO hanbit_member(id, password, name, nick, question, answer,tel,enabled,member_type)
VALUES('admin','a','관리자','관리자','ㅇㅇ','ㅁㄴ',010011111,1,3);











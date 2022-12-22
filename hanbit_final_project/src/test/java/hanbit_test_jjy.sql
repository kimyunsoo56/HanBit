-- 한빛 회원 테이블 
SELECT * FROM hanbit_member;

COMMIT

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
SELECT id,password,name,nick,question,answer,tel,enabled,member_type,license_no,gender,work_history,location,work_type FROM hanbit_member WHERE id='spring' AND password='a';

-- 아이디로 회원정보조회
SELECT id,password,name,nick,question,answer,tel,enabled,member_type,license_no,gender,work_history,location,work_type FROM hanbit_member WHERE id='spring';

-- 요양보호사 등록
INSERT INTO hanbit_member
VALUES ('springboot','a','김요양','요양천사','가장 기억에 남는 장소는?','집',01012345678,DEFAULT,2,1112223334,'여성','3년','서울','자택근무');

-- 회원탈퇴
UPDATE hanbit_member SET enabled=2 WHERE id='test6' AND password='a' AND question='나의 노래방 애창곡은?' AND answer='좋은날';
UPDATE hanbit_member SET enabled=1 WHERE id='spring2';

-- 작성글목록
SELECT notice_no, title, hits, time_posted
FROM hanbit_match_board,hanbit_free_board,hanbit_notice_board
INNER JOIN ON 


--방법 2 ANSI SQL 조인
 
 	--	SELECT 컬럼명,컬럼명
 --		FROM 테이블 명 별칭 
 	--	INNER JOIN 테이블명 별칭 ON 별칭.컬럼명 = 별칭,컬럼명 





-- 나의 질문목록 조회 : 판매글제목, 질문글제목, 작성일, 답변유무
select sb.sales_title,  qb.qna_title,  qb.qna_content,   qb.qna_date
from (select * from hs_qna_board where member_id='jmc') qb
inner join hs_sales_board sb on sb.sales_post_no=qb.sales_post_no

select sb.sales_title,  qb.qna_title,  qb.qna_content,  qb.qna_date,   qrb.member_id
from (select * from hs_qna_board where member_id='jmc') qb
inner join hs_sales_board sb on sb.sales_post_no=qb.sales_post_no
left outer join hs_qna_reply_board qrb on qrb.qna_post_no=qb.qna_post_no;

select * from hs_qna_board qb 
left outer join hs_qna_reply_board qrb on qb.qna_post_no=qrb.qna_post_no;

select qb.qna_post_no, qb.qna_title,qb.qna_content,qb.qna_date,qb.qna_status,qb.sales_post_no,qb.member_id,sb.sales_title
from hs_qna_board qb
inner join hs_sales_board sb on sb.sales_post_no=qb.sales_post_no
where qb.member_id='jmc'







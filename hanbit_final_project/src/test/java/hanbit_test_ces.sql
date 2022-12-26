-- 관리자 아이디 생성
INSERT INTO hanbit_member(id, password, name, nick, question, answer, tel, enabled, member_type, license_no, gender, work_history, location, work_type) 
VALUES ('admin', 'a', '관리자', '관리자', '질문', '대답', 010, 1, 3, 1111, '여성', '이력', '수원', '자택근무');

UPDATE hanbit_member SET enabled=1 WHERE id='admin';
UPDATE hanbit_member SET member_type=3 WHERE id='admin';

-- 알림 게시판 게시글 생성
INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category, image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '제목', '내용',sysdate, 0, '건강 정보', '이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category, image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '제목1', '내용1',sysdate, 0, '건강 정보', '이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '제목2', '내용2',sysdate, 0, '건강 정보', 
'이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '제목3', '내용3',sysdate, 0, '건강 정보', 
'이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '제목4', '내용4',sysdate, 0, '건강 정보', 
'이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '제목5', '내용5',sysdate, 0, '건강 정보', 
'이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '제목6', '내용6',sysdate, 0, '건강 정보', 
'이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '제목7', '내용7',sysdate, 0, '건강 정보', 
'이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '제목8', '내용8',sysdate, 0, '건강 정보', 
'이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '제목9', '내용9',sysdate, 0, '건강 정보', 
'이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '1', '내용9',sysdate, 0, '건강 정보', 
'이미지', 'www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '7', '내용9',sysdate, 0, '건강 정보', 
'이미지', 'https://www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, '8', '내용9',sysdate, 0, '건강정보', 
'이미지', 'https://www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, 'ㅇㅇ', '내용9',sysdate, 0, '알림정보', 
'이미지', 'https://www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, 'ㄴㄴ', '내용9',sysdate, 0, '공지사항', 
'이미지', 'https://www.naver.com', 'admin')

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, 'ㄴㄴ', '내용9',sysdate, 0, '공지사항', 
'이미지', 'https://www.naver.com', 'admin')
INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, 'ㄴㄴ', '내용9',sysdate, 0, '공지사항', 
'이미지', 'https://www.naver.com', 'admin')
INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, 'ㄴㄴ', '내용9',sysdate, 0, '공지사항', 
'이미지', 'https://www.naver.com', 'admin')
INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, 'ㄴㄴ', '내용9',sysdate, 0, '공지사항', 
'이미지', 'https://www.naver.com', 'admin')
INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, 'ㄴㄴ', '내용9',sysdate, 0, '공지사항', 
'이미지', 'https://www.naver.com', 'admin')
INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, 'ㄴㄴ', '내용9',sysdate, 0, '공지사항', 
'이미지', 'https://www.naver.com', 'admin')
INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, 'ㄴㄴ', '내용9',sysdate, 0, '공지사항', 
'이미지', 'https://www.naver.com', 'admin')
INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted, hits, category,
image, link, id)
VALUES(hanbit_notice_board_seq.nextval, 'ㄴㄴ', '내용9',sysdate, 0, '공지사항', 
'이미지', 'https://www.naver.com', 'admin')

COMMIT


DELETE  FROM hanbit_notice_board WHERE title = '제목';

commit

-- 총 게시물 수 조회
SELECT COUNT(*) FROM hanbit_notice_board; 


-- 알림 게시판 게시물 리스트 출력
SELECT nb.notice_no, nb.title, nb.time_posted, nb.hits, m.id, m.nick 
FROM (  
	SELECT row_number() over(order by no desc) as rnum, notice_no, title, SYSDATE, hits, 
	FROM   hanbit_notice_board ) nb, hanbit_member m  
WHERE  nb.id=m.id and rnum between 1AND 3
ORDER BY no DESC  

SELECT nb.notice_no, nb.title, nb.time_posted, nb.hits, m.id, m.nick 
FROM (  
	SELECT row_number() over(order by notice_no desc) as rnum, notice_no, title, sysdate, hits, id, time_posted
	FROM   hanbit_notice_board ) nb, hanbit_member m  
WHERE  nb.id=m.id and rnum between 1AND 3
ORDER BY notice_no DESC  


-- 알림 게시판 게시물 리스트 출력
SELECT hnb.notice_no, hnb.category, hnb.title, hm.nick, hnb.time_posted, hnb.hits
FROM hanbit_notice_board hnb
INNER JOIN hanbit_member hm ON hnb.id=hm.id

-- 알림 게시판 게시물 리스트 출력 (rnum 추가한 버전)
SELECT hnb.rnum, hnb.notice_no, hnb.title, hm.nick, hnb.time_posted, hnb.hits, hnb.category
FROM (
SELECT ROW_NUMBER() OVER (ORDER BY notice_no DESC) AS rnum,  
notice_no, title, time_posted, hits, category, id, image
FROM hanbit_notice_board ) hnb
INNER JOIN hanbit_member hm ON hnb.id=hm.id
ORDER BY hnb.notice_no DESC

-- 알림 게시판 게시물 디테일 뷰 출력
SELECT hnb.category, hnb.title, hm.nick, hnb.time_posted, hnb.hits, hnb.content, hnb.image, hnb.link
FROM hanbit_notice_board hnb
INNER JOIN hanbit_member hm ON hnb.id=hm.id
WHERE hnb.notice_no = 1 

-- 조회수 증가
update hanbit_notice_board
set hits=hits+1
where notice_no = 1;

-- 알림 게시판 카테고리 별 조회
SELECT hnb.notice_no, hnb.category, hnb.title, hm.nick, hnb.time_posted, hnb.hits
FROM hanbit_notice_board hnb
INNER JOIN hanbit_member hm ON hnb.id=hm.id
WHERE hnb.category = '공지사항' 

-- 알림 게시판 카테고리 별 조회 (rnum 추가한 버전)
SELECT hnb.rnum, hnb.notice_no, hnb.title, hm.nick, hnb.time_posted, hnb.hits, hnb.category
FROM (
SELECT ROW_NUMBER() OVER (ORDER BY notice_no DESC) AS rnum,  
notice_no, title, SYSDATE AS time_posted, hits, category, id
FROM hanbit_notice_board WHERE category = '공지사항' 
) hnb 
INNER JOIN hanbit_member hm ON hnb.id=hm.id
ORDER BY hnb.notice_no DESC

	   SELECT * from
      (select ROWNUM rm, notice_no, title, nick,time_posted, hits, category from
      (select hnb.notice_no, hnb.title, hm.nick, hnb.time_posted, hnb.hits, hnb.category
      from hanbit_notice_board hnb
      inner join hanbit_member hm on hnb.id=hm.id
      order by hnb.notice_no desc))


SELECT  hnb.rnum,  hnb.notice_no, hnb.category, hnb.title, hm.nick, hnb.time_posted, hnb.hits
FROM(
SELECT ROW_NUMBER() OVER(ORDER BY notice_no DESC) AS rnum, notice_no, id, category, title, nick, SYSDATE 
AS time_posted, hits, category FROM hanbit_notice_board WHERE category = '공지사항' 
) hnb
INNER JOIN hanbit_member hm ON hnb.id=hm.id
WHERE rnum BETWEEN 1 AND 5
ORDER BY hnb.notice_no DESC 



-- 알림 게시판 글쓰기
SELECT hanbit_notice_board_seq.nextval
FROM   dual

-- 알림 게시판 게시물 리스트 출력 (rnum 추가한 버전) + 페이징 네이션
SELECT * from
(select ROWNUM rm, notice_no, title, nick,time_posted, hits, category from
(select hnb.notice_no, hnb.title, hm.nick, hnb.time_posted, hnb.hits, hnb.category
from hanbit_notice_board hnb
inner join hanbit_member hm on hnb.id=hm.id
order by hnb.notice_no desc))
where rm between 1 and 100


-- 알림 게시판 게시물 리스트 출력 (rnum 추가한 버전)
SELECT hnb.rnum, hnb.notice_no, hnb.title, hm.nick, hnb.time_posted, hnb.hits, hnb.category
FROM (
SELECT ROW_NUMBER() OVER (ORDER BY notice_no DESC) AS rnum,  
notice_no, title, SYSDATE AS time_posted, hits, category, id
FROM hanbit_notice_board ) hnb
INNER JOIN hanbit_member hm ON hnb.id=hm.id
ORDER BY hnb.notice_no DESC
where rnum between 1 and 100

SELECT hnb.category, hnb.title, hm.nick, hnb.time_posted, hnb.hits, hnb.content, hnb.image, hnb.link
		FROM hanbit_notice_board hnb
		INNER JOIN hanbit_member hm ON hnb.id=hm.id
		WHERE hnb.notice_no = 65 

-- 알림 게시판 댓글 테이블 컬럼 추가
insert into hanbit_notice_comment(comment_no, content, time_posted, id, notice_no)
values(hanbit_notice_comment_seq.nextval, '댓글', sysdate, 'admin', 1)

SELECT * FROM hanbit_notice_comment;
		
CREATE TABLE hanbit_comment(
comment_no NUMBER PRIMARY KEY,
content CLOB NOT NULL,
time_posted DATE DEFAULT SYSDATE,
id VARCHAR2(100) NOT NULL,
free_no NUMBER NOT NULL,
CONSTRAINT hanbit_free_comment_fk FOREIGN KEY(id) REFERENCES hanbit_member(id),
CONSTRAINT hanbit_free_comment_no_fk FOREIGN KEY(free_no) REFERENCES hanbit_free_board(free_no)
)	

SELECT * FROM hanbit_comment;





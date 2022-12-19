-- 관리자 아이디 생성
INSERT INTO hanbit_member(id, password, name, nick, question, answer, tel, enabled, member_type, license_no, gender, work_history, location, work_type) 
VALUES ('admin', 'a', '관리자', '관리자', '질문', '대답', 010, 1, 3, 1111, '여성', '이력', '수원', '자택근무');

-- 알림 게시판 게시글 생성
INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted,hits, category, image, id)  
VALUES (hanbit_notice_board_seq.nextval, '테스트1', '안녕하세요', SYSDATE, 0, '공지사항', 'te.png', 'admin');

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted,hits, category, image, id)  
VALUES (hanbit_notice_board_seq.nextval, '테스트2', '안녕하세요', SYSDATE, 0, '건강 정보', 'te.png', 'admin');

INSERT INTO hanbit_notice_board(notice_no, title, content, time_posted,hits, category, image, id)  
VALUES (hanbit_notice_board_seq.nextval, '테스트3', '안녕하세요', SYSDATE, 0, '알림 정보', 'te.png', 'admin');

DELETE  FROM hanbit_notice_board WHERE title = '테스트2';

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

-- 알림 게시판 게시물 디테일 뷰 출력
SELECT hnb.category, hnb.title, hm.nick, hnb.time_posted, hnb.hits, hnb.content, hnb.image
FROM hanbit_notice_board hnb
INNER JOIN hanbit_member hm ON hnb.id=hm.id
WHERE hnb.notice_no = 1 

-- 알림 게시판 카테고리 별 조회
SELECT hnb.notice_no, hnb.category, hnb.title, hm.nick, hnb.time_posted, hnb.hits
FROM hanbit_notice_board hnb
INNER JOIN hanbit_member hm ON hnb.id=hm.id
WHERE hnb.category = '공지사항' 

-- 알림 게시판 카테고리 별 조회 (rnum 추가한 버전)
SELECT  hnb.rnum, hnb.notice_no, hnb.category, hnb.title,  hm.nick, hnb.time_posted, hnb.hits
FROM(
SELECT ROW_NUMBER() OVER(ORDER BY hnb.notice_no DESC) AS rnum, notice_no, category, title, nick, SYSDATE, hits
AS hnb.time_posted, hnb.hits, hnb.category FROM hanbit_notice_board WHERE hnb.category = '공지사항' 
) hnb
INNER JOIN hanbit_member hm ON hnb.id=hm.id
WHERE rnum BETWEEN 1 AND 5
ORDER BY hnb.notice_no DESC 

-- 알림 게시판 글쓰기
SELECT hanbit_notice_board_seq.nextval
FROM   dual

select * from hanbit_member;
select * from hanbit_notice_board;


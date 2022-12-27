package org.kosta.myproject.model.service;

import java.util.List;
import java.util.Map;

import org.kosta.myproject.model.vo.CommentVO;
import org.kosta.myproject.model.vo.NoticeBoardListVO;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.kosta.myproject.model.vo.NoticeCommentVO;

public interface NoticeBoardService {

// noticeBoardList - 페이징 적용
List<Map<String, Object>> noticeBoardList1(Criteria cri);

// noticeBoardDetailView 게시물 상세보기
NoticeBoardVO noticeBoardDetailView(int noticeNo);

//조회수 증가
void addHits(int noticeNo);

// writeNoticeBoardForm 게시물 작성 
void writeNoticeBoardForm(NoticeBoardVO noticeBoardVO);

// noticeWrite 게시물 작성 (세션 연결)
void noticeWrite(NoticeBoardVO noticeBoardVO);

int totalPostListCnt();

// 게시물 삭제
void noticeDelete(int noticeNo);

// 게시물 수정
void noticeUpdate(NoticeBoardVO noticeBoardVO);

// 댓글 등록
void registerComment(NoticeCommentVO commentVO);

// 댓글 목록
List<NoticeCommentVO> findCommentList(int noticeNo);

// 댓글 삭제
void commentDelete(int commentNo);

// 카테고리별 목록 조회 (페이징 적용)
int getTotalPostCountByCategory(String category);

// 카테고리별 목록 조회 (페이징 적용)
List<Map<String, Object>> findNoticeByCategory(Criteria cri, String category);

}

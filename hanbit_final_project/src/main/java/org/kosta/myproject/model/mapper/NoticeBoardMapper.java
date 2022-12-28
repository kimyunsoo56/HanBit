package org.kosta.myproject.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.service.Criteria;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.kosta.myproject.model.vo.NoticeCommentVO;

@Mapper
public interface NoticeBoardMapper {

	// 총 게시물 수 조회 
	int totalPostListCnt();
	
	// 게시물 조회 (PagingBean 객체 매개변수로 설정)
	List<Map<String, Object>> noticeBoardList1(Criteria cri);

	// noticeBoardDetailView 게시물 상세보기
	NoticeBoardVO noticeBoardDetailView(int noticeNo);
	
	// 조회수 증가
	void addHits(int freeNo);

	// writeNoticeBoard 글쓰기
	void noticeWrite(NoticeBoardVO noticeBoardVO);

	// 게시물 삭제
	void noticeDelete(int noticeNo);

	// 게시물 수정
	void noticeUpdate(NoticeBoardVO noticeBoardVO);

	// 댓글 등록
	void registerComment(NoticeCommentVO commentVO);

	// 댓글 목록 조회
	List<NoticeCommentVO> findCommentList(int noticeNo);
	
	// 댓글 삭제
	void commentDelete(int commentNo);

	// 카테고리 별 조회 (페이징 적용)
	List<Map<String, Object>> findNoticeByCategory(HashMap<String, Object> paramMap);

	// 카테고리 별 조회 (페이징 적용)
	int getTotalPostCountByCategory(String category);
}

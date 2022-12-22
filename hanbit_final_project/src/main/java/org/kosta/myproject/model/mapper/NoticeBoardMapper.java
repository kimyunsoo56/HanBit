package org.kosta.myproject.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.service.Criteria;
import org.kosta.myproject.model.service.PagingBean;
import org.kosta.myproject.model.vo.NoticeBoardVO;

@Mapper
public interface NoticeBoardMapper {

	// 총 게시물 수 조회 
	int getTotalPostCount();
	
	// 게시물 조회 (PagingBean 객체 매개변수로 설정)
	List<Map<String, Object>> noticeBoardList1(Criteria cri);
	
	// 카테고리 별 조회 (페이징 적용)
	List<Map<String, Object>> findByCategory(Criteria cri);

	// noticeBoardDetailView 게시물 상세보기
	NoticeBoardVO noticeBoardDetailView(int noticeNo);

	// writeNoticeBoard 글쓰기
	void noticeWrite(NoticeBoardVO noticeBoardVO);

	int totalPostListCnt();

	// List<NoticeBoardVO> findNoticeByCategory(NoticeBoardVO noticeBoardVO);





}

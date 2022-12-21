package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.service.Criteria;
import org.kosta.myproject.model.service.PagingBean;
import org.kosta.myproject.model.vo.NoticeBoardVO;

@Mapper
public interface NoticeBoardMapper {

	// 총 게시물 수 조회 
	int getTotalPostCount();
	
	// 게시물 조회 (PagingBean 객체 매개변수로 설정)
	List<NoticeBoardVO> noticeBoardList1();
	
	// 게시물 조회 (PagingBean 객체 매개변수로 설정)
	// List<NoticeBoardVO> getListWithPaging(Criteria cri);

	// noticeBoardDetailView 게시물 상세보기
	NoticeBoardVO noticeBoardDetailView(int noticeNo);

	// writeNoticeBoard 글쓰기
	void noticeWrite(NoticeBoardVO noticeBoardVO);

	List<NoticeBoardVO> noticeBoardList(PagingBean pagingBean);

	// 카테고리별 조회
	List<NoticeBoardVO> noticeFindByCategory(NoticeBoardVO noticeBoardVO);

}

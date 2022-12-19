package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.service.PagingBean;
import org.kosta.myproject.model.vo.NoticeBoardVO;

@Mapper
public interface NoticeBoardMapper {

	// 0 . 총 게시물 수 조회 
	int getTotalPostCount();
	
	// 1. 게시물 조회 (PagingBean 객체 매개변수로 설정)
	List<NoticeBoardVO> noticeBoardList(PagingBean pagingBean);

	List<NoticeBoardVO> noticeBoardList1();

	
	// noticeBoardDetailView 게시물 상세보기
	NoticeBoardVO noticeBoardDetailView(int noticeNo);

	// writeNoticeBoardForm 글쓰기
	void writeNoticeBoardForm(NoticeBoardVO noticeBoardVO);

}

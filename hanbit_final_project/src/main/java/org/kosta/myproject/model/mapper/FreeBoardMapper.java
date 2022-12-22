package org.kosta.myproject.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.service.Criteria;
import org.kosta.myproject.model.vo.CommentVO;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.kosta.myproject.model.vo.ReportVO;

@Mapper
public interface FreeBoardMapper {
	
	// 게시물 조회 (PagingBean 객체 매개변수로 설정)
	List<Map<String, Object>> findAll(Criteria cri);

	FreeBoardVO getFreeDetail(int freeNo);

	void addHits(int freeNo);

	void freeDelete(int freeNo);

	void freeUpdate(FreeBoardVO freeBoardVO);

	void registerFreeBoard(String title, String content, String category, String id);

	void freeReport(int freeNo);

	List<ReportVO> findReportList();

	void registerComment(CommentVO commentVO);

	List<CommentVO> findCommentList(int freeNo);

	void commentDelete(int commentNo);

	int getTotalPostCount();

	List<FreeBoardVO> findFreeByCategory(String category);

}

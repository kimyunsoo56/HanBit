package org.kosta.myproject.model.service;

import java.util.List;
import java.util.Map;


import org.kosta.myproject.model.vo.CommentVO;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.kosta.myproject.model.vo.ReportVO;

public interface FreeBoardService {
	
	
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

	List<Map<String, Object>> findFreeByCategory(String category, Criteria cri);

	int getTotalPostCountByCategory(String category);

	void freeWrite(FreeBoardVO freeBoardVO);

	List<Map<String, Object>> freeBoardList1(Criteria cri);

}

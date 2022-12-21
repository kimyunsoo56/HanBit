package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.vo.CommentVO;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.kosta.myproject.model.vo.ReportVO;

@Mapper
public interface FreeBoardMapper {

	List<FreeBoardVO> findAll();

	FreeBoardVO getFreeDetail(int freeNo);

	void addHits(int freeNo);

	void freeDelete(int freeNo);

	void freeUpdate(FreeBoardVO freeBoardVO);

	void registerFreeBoard(String title, String content, String category, String id);

	void freeReport(int freeNo);

	List<ReportVO> findReportList();

	void registerComment(CommentVO commentVO);

}

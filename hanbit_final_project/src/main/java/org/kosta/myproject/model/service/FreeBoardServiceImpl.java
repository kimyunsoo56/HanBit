package org.kosta.myproject.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.myproject.model.mapper.FreeBoardMapper;
import org.kosta.myproject.model.vo.CommentVO;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.kosta.myproject.model.vo.ReportVO;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	@Resource
	private FreeBoardMapper freeBoardMapper;

	//글목록
	@Override
	public List<FreeBoardVO> findAll() {
		//List<BoardEntity> boardEntityList = br.findAll();
		List<FreeBoardVO> FreeBoardList = freeBoardMapper.findAll();
		return FreeBoardList;
	}
	//게시글상세보기
	@Override
	public FreeBoardVO getFreeDetail(int freeNo) {
		return freeBoardMapper.getFreeDetail(freeNo);
	}
	//조회수증가
	@Override
	public void addHits(int freeNo) {
		freeBoardMapper.addHits(freeNo);
	}
	//글삭제
	@Override
	public void freeDelete(int freeNo) {
		freeBoardMapper.freeDelete(freeNo);
		
	}

	@Override
	public void freeUpdate(FreeBoardVO freeBoardVO) {
		freeBoardMapper.freeUpdate(freeBoardVO);
		
	}
	@Override
	public void registerFreeBoard(String title, String content, String category, String id) {
		freeBoardMapper.registerFreeBoard(title,content,category,id);
		
	}
	@Override
	public void freeReport(int freeNo) {
		freeBoardMapper.freeReport(freeNo);
		
	}
	@Override
	public List<ReportVO> findReportList() {
		List<ReportVO> reportList = freeBoardMapper.findReportList();
		return reportList;
	}
	@Override
	public void registerComment(CommentVO commentVO) {
		freeBoardMapper.registerComment(commentVO);

	}
	
	

}

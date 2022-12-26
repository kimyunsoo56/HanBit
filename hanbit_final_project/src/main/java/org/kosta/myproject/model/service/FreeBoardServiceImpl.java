package org.kosta.myproject.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Map<String, Object>> findAll(Criteria cri) {
		//List<BoardEntity> boardEntityList = br.findAll();
		List<Map<String, Object>> FreeBoardList = freeBoardMapper.findAll(cri);
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
	@Override
	public List<CommentVO> findCommentList(int freeNo) {
		List<CommentVO> commentList = freeBoardMapper.findCommentList(freeNo);
		return commentList;
	}
	@Override
	public void commentDelete(int commentNo) {
		freeBoardMapper.commentDelete(commentNo);
		
	}
	@Override
	public int getTotalPostCount() {
		int count = freeBoardMapper.getTotalPostCount();
		return count;
	}
	//카테고리별검색
	@Override
	public List<Map<String, Object>> findFreeByCategory(String category, Criteria cri) {
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("cri", cri);
		paramMap.put("category", category);
		return freeBoardMapper.findFreeByCategory(paramMap);
		
	}
	@Override
	public int getTotalPostCountByCategory(String category) {
		int count = freeBoardMapper.getTotalPostCountByCategory(category);
		return count;
	}
	@Override
	public void freeWrite(FreeBoardVO freeBoardVO) {
		freeBoardMapper.freeWrite(freeBoardVO);
		
	}
	@Override
	public List<Map<String, Object>> freeBoardList1(Criteria cri) {
		return freeBoardMapper.freeBoardList1(cri);
	}
	@Override
	public int getTotalPostCountByKeyword(String keyword) {
		int count = freeBoardMapper.getTotalPostCountByKeyword(keyword);
		return count;
	}
	//키워드검색
	@Override
	public List<Map<String, Object>> findFreeByKeyword(String keyword, Criteria cri) {
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("cri", cri);
		paramMap.put("keyword", keyword);
		return freeBoardMapper.findFreeByKeyword(paramMap);
	}
	
	
	

}

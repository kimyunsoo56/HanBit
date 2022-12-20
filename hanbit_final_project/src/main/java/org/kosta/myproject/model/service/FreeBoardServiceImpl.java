package org.kosta.myproject.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.kosta.myproject.model.mapper.FreeBoardMapper;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	@Resource
	private FreeBoardMapper freeBoardMapper;
	

	//글쓰기
	@Override
	public void write(FreeBoardVO freeBoardVO) {
		freeBoardMapper.write(freeBoardVO);	
	}
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


}

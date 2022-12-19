package org.kosta.myproject;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.mapper.MatchBoardMapper;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HanbitJunitTestKms {
	private final MatchBoardMapper matchBoardMapper;
	
	@Autowired
	public HanbitJunitTestKms(MatchBoardMapper matchBoardMapper) {
		super();
		this.matchBoardMapper = matchBoardMapper;
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	public void MatchBoardList() {
		List<MatchBoardVO> list=matchBoardMapper.matchBoardList();
		Assertions.assertEquals(1, list.size()); 
		System.out.println(list.size());
	}
	
	@Test
	public void MatchDetail() {
		int matchNo=2;
		MatchBoardVO matchVO=matchBoardMapper.matchDetail(matchNo);
		Assertions.assertEquals(11, matchVO.getHits()); 
		System.out.println(matchVO.getHits());
	}
}

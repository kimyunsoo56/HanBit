package org.kosta.myproject.model.service;

import java.util.List;

import org.kosta.myproject.model.vo.MatchBoardVO;
import org.springframework.stereotype.Service;

@Service
public interface MatchBoardService  {

	List<MatchBoardVO> matchBoardList();

	MatchBoardVO matchDetail(int matchNo);

	List<MatchBoardVO>findMatchListBylgw(MatchBoardVO matchBoardVO);

	







	

	

}

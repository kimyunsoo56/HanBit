package org.kosta.myproject.model.service;

import java.util.List;

import org.kosta.myproject.model.mapper.MatchBoardMapper;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatchBoardServiceImpl implements MatchBoardService {
	
	private final MatchBoardMapper matchBoardMapper;

	@Override
	public List<MatchBoardVO> matchBoardList() {
		
		return matchBoardMapper.matchBoardList();
	}

	@Override
	public MatchBoardVO matchDetail(int matchNo) {
		
		return matchBoardMapper.matchDetail(matchNo);
	}

	@Override
	public List<MatchBoardVO> findMatchListBylgw(MatchBoardVO matchBoardVO) {
		
		return matchBoardMapper.findMatchListBylgw(matchBoardVO);
	}

}

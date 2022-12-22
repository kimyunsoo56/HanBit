package org.kosta.myproject.model.service;

import java.util.List;

import org.kosta.myproject.model.mapper.MatchBoardMapper;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.kosta.myproject.model.vo.MessageVO;
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

	@Override
	public int realSendMessage(MessageVO messageVO) {
		
		return matchBoardMapper.realSendMessage(messageVO);
	}

	@Override
	public int registerMatch(MatchBoardVO matchBoardVO) {
		
		return matchBoardMapper.registerMatch(matchBoardVO);
	}

	@Override
	public List<MessageVO> messageList(String id) {
		
		return matchBoardMapper.messageList(id);
	}

	@Override
	public List<MessageVO> messageList1(String id) {
		
		return matchBoardMapper.messageList1(id);
	}

	@Override
	public void addHits(int matchNo) {
		matchBoardMapper.addHits(matchNo);
	}

	@Override
	public void addChecking(int messageNo) {
		matchBoardMapper.addChecking(messageNo);
	}

	@Override
	public void matchDelete(int matchNo) {
		matchBoardMapper.matchDelete(matchNo);
	}

	@Override
	public void updateMatch(MatchBoardVO matchBoardVO) {
		matchBoardMapper.updateMatch(matchBoardVO);
	}

	

	









	
	

	

	

}

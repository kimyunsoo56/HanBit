package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.kosta.myproject.model.vo.MessageVO;
@Mapper
public interface MatchBoardMapper {

	List<MatchBoardVO> matchBoardList();

	MatchBoardVO matchDetail(int matchNo);

	List<MatchBoardVO> findMatchListBylgw(MatchBoardVO matchBoardVO);
	
	int realSendMessage(MessageVO messageVO);

	int registerMatch(MatchBoardVO matchBoardVO);

	List<MessageVO> messageList(String id);

	List<MessageVO> messageList1(String id);

	void addHits(int matchNo);

	void addChecking(int messageNo);

	void matchDelete(int matchNo);

	void updateMatch(MatchBoardVO matchBoardVO);

	

	

	

	










	

}

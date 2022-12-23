package org.kosta.myproject.model.service;

import java.util.List;

import org.kosta.myproject.model.vo.LikesVO;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.kosta.myproject.model.vo.MessageVO;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.springframework.stereotype.Service;

@Service
public interface MatchBoardService  {

	List<MatchBoardVO> matchBoardList();

	MatchBoardVO matchDetail(int matchNo);

	List<MatchBoardVO>findMatchListBylgw(MatchBoardVO matchBoardVO);

	int realSendMessage(MessageVO messageVO);

	int registerMatch(MatchBoardVO matchBoardVO);

	List<MessageVO> messageList(String id);

	List<MessageVO> messageList1(String id);

	void addHits(int matchNo);

	void addChecking(int messageNo);

	void matchDelete(int matchNo);

	void updateMatch(MatchBoardVO matchBoardVO);

	void addLikes(LikesVO likesVO);

	void removeLikes(LikesVO likesVO);



	


	

	



	

	


	
	

	







	

	

}

package org.kosta.myproject.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.service.Criteria;
import org.kosta.myproject.model.vo.LikesVO;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.kosta.myproject.model.vo.MessageVO;
@Mapper
public interface MatchBoardMapper {

	List<MatchBoardVO> matchBoardList();

	MatchBoardVO matchDetail(int matchNo);

	//List<MatchBoardVO> findMatchListBylgw(MatchBoardVO matchBoardVO);
	
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

	int checkLikes(LikesVO likesVO);

	int getTotalPostCount();

	List<Map<String, Object>> findAll(Criteria cri);

	//int getTotalPostCountByCategory(MatchBoardVO matchBoardVO);

	List<MatchBoardVO> findMatchListBylgw(MatchBoardVO matchBoardVO);

	

	







	

	

	

	










	

}

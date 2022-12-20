package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.vo.MatchBoardVO;
@Mapper
public interface MatchBoardMapper {

	List<MatchBoardVO> matchBoardList();

	MatchBoardVO matchDetail(int matchNo);

	List<MatchBoardVO> findMatchListBylgw(MatchBoardVO matchBoardVO);





	

}

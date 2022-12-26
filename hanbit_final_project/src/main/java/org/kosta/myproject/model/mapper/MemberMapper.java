package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.vo.CommentVO;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.kosta.myproject.model.vo.MemberVO;

@Mapper
public interface MemberMapper {

	MemberVO login(MemberVO memberVO);

	public MemberVO myPageDetail(String id);

	MemberVO findMemberById(String id);

	int registerMember(MemberVO memberVO);

	int checkTel(String tel);

	String findId(String name, String tel);

	String findPassword(String id, String name, String tel, String question, String answer);

	int checkLicenseNo(int licenseNo);

	void registerCareWorker(MemberVO memberVO);

	void updateMember(MemberVO memberVO);

	int deleteMember(MemberVO memberVO);

	List<MatchBoardVO> myLikedList(String id);

	List<FreeBoardVO> findFreePostList(String id);

	List<MatchBoardVO> findMatchPostList(String id);

	List<CommentVO> findFreePostCommentList(String id);

}

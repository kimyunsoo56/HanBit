package org.kosta.myproject.model.service;

import java.util.List;

import org.kosta.myproject.model.mapper.MemberMapper;
import org.kosta.myproject.model.vo.FreeBoardVO;
//github.com/kimyunsoo56/HanBit.git
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.kosta.myproject.model.vo.MemberVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	private final MemberMapper memberMapper;

	@Override
	public MemberVO login(MemberVO memberVO) {
		return memberMapper.login(memberVO);
	}

	@Override
	public MemberVO myPageDetail(String id) {
		return memberMapper.myPageDetail(id);
	}
	@Override
	public MemberVO findMemberById(String id) {
		return memberMapper.findMemberById(id);
	}

	@Override
	public int register(MemberVO memberVO) {
		return memberMapper.registerMember(memberVO);
	}

	@Override
	public String findId(String name, String tel) {
		return memberMapper.findId(name, tel);
	}

	@Override
	public String findPassword(String id, String name, String tel, String question, String answer) {
		return memberMapper.findPassword(id, name, tel, question, answer);
	}

	@Override
	public int checkLicenseNo(int licenseNo) {
		return memberMapper.checkLicenseNo(licenseNo);
	}

	@Override
	public void registerCareWorker(MemberVO memberVO) {
		memberMapper.registerCareWorker(memberVO);
	}

	@Override
	public void updateMember(MemberVO memberVO) {
		memberMapper.updateMember(memberVO);
	}

	@Override
	public int checkTel(String tel) {
		return memberMapper.checkTel(tel);
	}
	@Override
	public int deleteMember(MemberVO memberVO) {
		return memberMapper.deleteMember(memberVO);
	}

	@Override
	public List<FreeBoardVO> findFreePostList(String id) {
		List<FreeBoardVO> list = memberMapper.findFreePostList(id);
		System.out.println(list);
		return memberMapper.findFreePostList(id);
	}

	@Override
	public List<MatchBoardVO> myLikedList(String id) {
		return memberMapper.myLikedList(id);
	}
	
	@Override
	public List<MatchBoardVO> findMatchPostList(String id) {
		return memberMapper.findMatchPostList(id);
	}

}

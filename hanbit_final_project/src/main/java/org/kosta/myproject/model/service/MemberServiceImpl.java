package org.kosta.myproject.model.service;

import org.kosta.myproject.model.mapper.MemberMapper;
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
	public int checkNick(String nick) {
		return memberMapper.checkNick(nick);
	}

	@Override
	public int checkTel(String tel) {
		return memberMapper.checkTel(tel);
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
	public void deleteMember(MemberVO memberVO) {
		memberMapper.deleteMember(memberVO);
	}


}

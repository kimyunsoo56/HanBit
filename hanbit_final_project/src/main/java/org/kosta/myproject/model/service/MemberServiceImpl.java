package org.kosta.myproject.model.service;

import org.kosta.myproject.model.mapper.MemberMapper;
import org.kosta.myproject.model.vo.MemberVO;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
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
}
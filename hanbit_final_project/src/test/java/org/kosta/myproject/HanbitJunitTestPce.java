package org.kosta.myproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.mapper.MemberMapper;
import org.kosta.myproject.model.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HanbitJunitTestPce {
	private MemberMapper memberMapper;
	@Autowired
	public HanbitJunitTestPce(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}
	// id로 회원정보인 MemberVO 를 반환하는 sql 테스트
	@Test
	void findMemberById() {
		String id="java";
		MemberVO memberVO=memberMapper.findMemberById(id);
		Assertions.assertNotNull(memberVO);
		System.out.println("member: "+memberVO);
	}
	@Test
	void registerMember() {
		MemberVO memberVO=new MemberVO("spring", "a", "박진수", "진수팍", "나의 출신 초등학교는?", "문성초", "01028355343");
		int result=memberMapper.registerMember(memberVO);
		Assertions.assertEquals(1, result);
	}
}








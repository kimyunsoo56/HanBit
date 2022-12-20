package org.kosta.myproject;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.mapper.MemberMapper;
import org.kosta.myproject.model.vo.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HanbitJunitTestJjy {
	private Logger logger=LoggerFactory.getLogger(getClass());
	private MemberMapper memberMapper;
	@Autowired
	public HanbitJunitTestJjy(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}
	@Test
	void mapper() {
		Assertions.assertNotNull(memberMapper);
	}
	@Test
	public void login() {
		MemberVO memberVO=new MemberVO();
		memberVO.setId("java");
		memberVO.setPassword("a");
		MemberVO resultVO=memberMapper.login(memberVO);
		System.out.println(resultVO);
	}
	@Test
	public void myPageDetail() {
		String id="java";
		MemberVO memberVO=memberMapper.myPageDetail(id);
		Assertions.assertNotNull(memberVO);
	}
	@Test
	public void delectMember() {
		String password="a";
		String question="나의 출신 초등학교는?";
		String answer="문성초";
	}
}

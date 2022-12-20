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
		MemberVO memberVO=new MemberVO("test5","a","나의 노래방 애창곡은?","좋은날",2);
		System.out.println("삭제됐나" + memberVO);
		memberMapper.deleteMember(memberVO);
		System.out.println("삭제됐다" + memberVO);
	}
}

package org.kosta.myproject;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.mapper.MemberMapper;
import org.kosta.myproject.model.vo.MatchBoardVO;
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
	// id로 회원정보인 MemberVO 를 반환하는 테스트
	@Test
	void findMemberById() {
		String id="java";
		MemberVO memberVO=memberMapper.findMemberById(id);
		Assertions.assertNotNull(memberVO);
	}
	// 회원가입 테스트
	@Test
	void registerMember() {
		MemberVO memberVO=new MemberVO("spring", "a", "박진수", "진수팍", "나의 출신 초등학교는?", "문성초", "01028355343");
		int result=memberMapper.registerMember(memberVO);
		Assertions.assertEquals(1, result);
	}
	// 아이디 찾기 테스트
	@Test
	void findId() {
		String name="박진수";
		String tel="01028355343";
		String id=memberMapper.findId(name, tel);
		Assertions.assertNotNull(id);
	}
	// 비밀번호 찾기 테스트
	@Test
	void findPassword() {
		String id="spring";
		String name="박진수";
		String tel="01028355343";
		String question="나의 출신 초등학교는?";
		String answer="문성초";
		String password=memberMapper.findPassword(id,name,tel,question,answer);
		Assertions.assertNotNull(password);
	}
	// 요양보호사 등록 테스트
	@Test
	void registerCareWorker() {
		MemberVO memberVO=new MemberVO("2222", 2, 2222222, "여성", "신입", "서울", "자택근무");
		memberMapper.registerCareWorker(memberVO);
	}
	// 회원 정보 수정 테스트
	@Test
	void updateMemberForm() {
		MemberVO memberVO=new MemberVO("spring", "aa", "장지영", "오리", "나의 노래방 애창곡은?", "편의점", "01098516852", null, null, null, null);
		memberMapper.updateMember(memberVO);
	}
	// 찜 목록 조회 테스트
	@Test
	void myPageLikeList() {
		String id="java";
		List<MatchBoardVO> list=memberMapper.myLikedList(id);
		Assertions.assertEquals(1, list.size());
		System.out.println(list);
	}
}








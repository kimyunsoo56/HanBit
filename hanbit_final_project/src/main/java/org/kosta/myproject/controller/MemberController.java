package org.kosta.myproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.kosta.myproject.model.service.MemberService;
import org.kosta.myproject.model.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	// register form 에서 for문 돌릴 select 부분을 model에 담아서 넘겨줌
	@RequestMapping("registerForm")
	public String registerForm(Model model) {
		List<String> question=new ArrayList<>();
		question.add("가장 기억에 남는 장소는?");
		question.add("나의 좌우명은?");
		question.add("나의 보물 제1호는?");
		question.add("인상 깊게 읽은 책 이름은?");
		question.add("내가 존경하는 인물은?");
		question.add("나의 출신 초등학교는?");
		question.add("나의 노래방 애창곡은?");
		model.addAttribute("questionList", question);
		return "member/register-form";
	}
	// 회원가입 폼
	@PostMapping("registerMember")
	public String register(MemberVO memberVO) {
		memberService.register(memberVO);
		return "redirect:registerMemberResult";
	}
	// 회원가입
	@RequestMapping("registerMemberResult")
	public String registerMemberResult() {
		return "member/register-result";
	}
	// 아이디 중복체크 Ajax
	@RequestMapping("registerCheckId")
	@ResponseBody
	public MemberVO registerCheckId(String id) {
		MemberVO checkId=memberService.findMemberById(id);
		return checkId;
	}
	// 닉네임 중복체크 Ajax
	@RequestMapping("registerCheckNick")
	@ResponseBody
	public int registerCheckNick(String nick) {
		int checkNick=memberService.checkNick(nick);
		return checkNick;
	}
	// 연락처 중복체크 Ajax
	@RequestMapping("registerCheckTel")
	@ResponseBody
	public int registerCheckTel(String tel) {
		int checkTel=memberService.checkTel(tel);
		return checkTel;
	}
	// 아이디 찾기 폼
	@RequestMapping("findIdForm")
	public String findIdForm() {
		return "member/findid-form";
	} 
	// 아이디 찾기
	@RequestMapping("findId")
	public String findId(String name,String tel,Model model) {
		String viewName=null;
		String findId=memberService.findId(name,tel);
		if(findId==null) {
			viewName="member/findid-fail";
		}else {
			model.addAttribute("memberId", findId);
			viewName="member/findid-ok";
		}
		return viewName;
	}
	// 비밀번호 찾기 폼
	@RequestMapping("findPasswordForm")
	public String findPasswordForm(Model model) {
		List<String> question=new ArrayList<>();
		question.add("가장 기억에 남는 장소는?");
		question.add("나의 좌우명은?");
		question.add("나의 보물 제1호는?");
		question.add("인상 깊게 읽은 책 이름은?");
		question.add("내가 존경하는 인물은?");
		question.add("나의 출신 초등학교는?");
		question.add("나의 노래방 애창곡은?");
		model.addAttribute("questionList", question);
		return "member/findpassword-form";
	}
	// 비밀번호 찾기
	@RequestMapping("findPassword")
	public String findPassword(String id,String name,String tel,String question,String answer,Model model) {
		String viewName=null;
		String findPassword=memberService.findPassword(id,name,tel,question,answer);
		if(findPassword==null) {
			viewName="member/findpassword-fail";
		}else {
			model.addAttribute("memberPassword", findPassword);
			viewName="member/findpassword-ok";
		}
		return viewName;
	}
	// 요양보호사 등록 폼
	@RequestMapping("registerCareWorkerForm")
	public String registerCareWorkerForm(Model model) {
		// 성별
		List<String> gender=new ArrayList<>();
		gender.add("남성");
		gender.add("여성");
		model.addAttribute("genderList", gender);
		// 경력
		List<String> workHistory=new ArrayList<>();
		workHistory.add("신입");
		workHistory.add("1년 미만");
		workHistory.add("1년~3년");
		workHistory.add("3년~5년");
		workHistory.add("5~7년");
		workHistory.add("7년~10년");
		workHistory.add("10년 이상");
		model.addAttribute("workHistoryList", workHistory);
		// 지역
		List<String> location=new ArrayList<>();
		location.add("서울특별시");
		location.add("경기도");
		location.add("인천광역시");
		location.add("강원도");
		location.add("충청북도");
		location.add("충청남도");
		location.add("대전광역시");
		location.add("세종특별자치시");
		location.add("전라북도");
		location.add("전라남도");
		location.add("광주광역시");
		location.add("경상북도");
		location.add("경상남도");
		location.add("부산광역시");
		location.add("대구광역시");
		location.add("울산광역시");
		location.add("제주특별자치도");
		model.addAttribute("locationList", location);
		// 근무타입
		List<String> workType=new ArrayList<>();
		workType.add("자택근무");
		workType.add("병원근무");
		model.addAttribute("workTypeList", workType);
		return "member/register-careworker-form";
	}
}

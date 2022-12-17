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
	// 
	@PostMapping("registerMember")
	public String register(MemberVO memberVO) {
		memberService.register(memberVO);
		return "redirect:registerMemberResult";
	}
	@RequestMapping("registerMemberResult")
	public String registerMemberResult() {
		return "member/register-result";
	}
	@RequestMapping("registerCheckId")
	@ResponseBody
	public MemberVO registerCheckId(String id) {
		MemberVO checkId=memberService.findMemberById(id);
		return checkId;
	}
	@RequestMapping("registerCheckNick")
	@ResponseBody
	public int registerCheckNick(String nick) {
		int checkNick=memberService.checkNick(nick);
		return checkNick;
	}
	@RequestMapping("registerCheckTel")
	@ResponseBody
	public int registerCheckTel(String tel) {
		int checkTel=memberService.checkTel(tel);
		return checkTel;
	}
}

package org.kosta.myproject.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.service.MemberService;
import org.kosta.myproject.model.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
	 private final MemberService memberService;
	
	 @RequestMapping("/loginForm")
	 public String loginForm() {
		 return "member/login-form";
	 }
	 
	 @PostMapping("/login")
	 public String login(MemberVO memberVO,HttpServletRequest request) {
		 MemberVO resultVO=memberService.login(memberVO);
		 if(resultVO==null) { 
				return "member/login-fail";
			} else {
				HttpSession session=request.getSession();
				session.setAttribute("mvo", resultVO);
				return "redirect:/";
			}
	 }
	  @PostMapping("/logout") 
			public String logout(HttpServletRequest request) {
				HttpSession session=request.getSession(false);
				if(session!=null) 
					session.invalidate();
				return "redirect:/";
	 }
	  @RequestMapping("/myPage")
		 public String myPage() {
			 return "member/myPage";
		 }
	  @PostMapping("/myPageDetail")
		 public String myPageDetail(HttpSession session,Model model,String id) {
		  System.out.println("받아오냐");
		  model.addAttribute("memberVO", memberService.myPageDetail(id));
		   System.out.println("아이디 받아온다" + id + session);
			 return "member/myPageDetailList";
	  }
	  
}

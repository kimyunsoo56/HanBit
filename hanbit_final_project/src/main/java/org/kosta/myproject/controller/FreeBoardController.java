package org.kosta.myproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.service.FreeBoardService;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.kosta.myproject.model.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FreeBoardController {

	private final FreeBoardService freeBoardService;

	
	//글목록
	@GetMapping("freeBoardList")
	public String findAll(Model model) {
		List<FreeBoardVO> FreeBoardList = freeBoardService.findAll();
		model.addAttribute("FreeBoardList", FreeBoardList);
		return "freeBoard/freeBoardList";
	}
	// 글쓰기 폼으로 이동
	@RequestMapping("freeWrite")
	public String writeForm(HttpSession session) {
		//세션 만료 시 홈으로 - AOP 대상(cross-cutting concern)
		 if (session.getAttribute("mvo") == null) 
			 return "redirect:home.do";
		 
		return "freeBoard/freeWrite";
	}
	
	// 글쓰기 기능
	@PostMapping("write")
	//RedirectAttributes : 쿼리스트링 방식을 간단하게 처리할 수 있는 interface
	public String write(FreeBoardVO freeBoardVO, HttpSession session, Model model) {
		//세션 만료 시 홈으로 - AOP 대상(cross-cutting concern)
		if (session.getAttribute("mvo") == null)
			return "redirect:home.do";
		//세션에서 memberVO 정보 받아와서 freeBoardVO객체에 할당
		MemberVO memberVO = (MemberVO) session.getAttribute("mvo");
		freeBoardVO.setMemberVO(memberVO);
		//글 작성 동작
		freeBoardService.write(freeBoardVO);

		return "redirect:freeDetail";
	
	}
	//글 상세보기-조회수증가O
	@RequestMapping("freeDetail")
	public ModelAndView getFreeDetail(int freeNo, HttpSession session, RedirectAttributes ra) {  
		session.getAttribute("mvo");
		//MemberController의 login 메서드를 확인
		@SuppressWarnings("unchecked")
		ArrayList<Integer> noList = (ArrayList<Integer>) session.getAttribute("noList");
		//noList에 조회하는 게시글의 번호가 존재하지 않으면
		if (noList.contains(freeNo) == false) {
			freeBoardService.addHits(freeNo);//조회수증가방지없음
			noList.add(freeNo); //noList에 조회한 게시글 no 추가
		}
		ModelAndView mv = new ModelAndView();
		  mv.setViewName("freeBoard/freeDetail");
		  mv.addObject("freeDetail", freeBoardService.getFreeDetail(freeNo));
		return mv;
		
	}
	
}

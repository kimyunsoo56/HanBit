package org.kosta.myproject.controller;

import java.util.List;

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
	@RequestMapping("writeForm")
	public String writeForm(HttpSession session) {
		//세션 만료 시 홈으로 - AOP 대상(cross-cutting concern)
		 if (session.getAttribute("mvo") == null) 
			 return "redirect:home.do";
		 
		return "freeBoard/freeWrite";
	}
	
	// 글쓰기 기능
	@PostMapping("write.do")
	//RedirectAttributes : 쿼리스트링 방식을 간단하게 처리할 수 있는 interface
	public String write(FreeBoardVO freeBoardVO, HttpSession session, RedirectAttributes ra) {
		//세션 만료 시 홈으로 - AOP 대상(cross-cutting concern)
		if (session.getAttribute("mvo") == null)
			return "redirect:home.do";
		//세션에서 memberVO 정보 받아와서 freeBoardVO객체에 할당
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		freeBoardVO.setMemberVO(mvo);
		//글 작성 동작
		freeBoardService.write(freeBoardVO);

		return "redirect:freeDetail.do";
	}
	//글 상세보기
	@RequestMapping("freeDetail")
	public ModelAndView getFreeDetail(int freeNo) {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("freeBoard/freeDetail");
		  mv.addObject("freeDetail", freeBoardService.getFreeDetail(freeNo));
		return mv;
		
	}
	/*
	 *  @RequestMapping("getNoticeDetail.do")
   public ModelAndView getNoticeDetail(String noticeNo) {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("board/notice/noticeDetail.tiles");
      mv.addObject("nvo", boardService.getNoticeDetail(noticeNo));
      return mv;
   }
	 */
	

}

package org.kosta.myproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.service.Criteria;
import org.kosta.myproject.model.service.FreeBoardService;
import org.kosta.myproject.model.service.Paging;
import org.kosta.myproject.model.vo.CommentVO;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.kosta.myproject.model.vo.MemberVO;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.kosta.myproject.model.vo.ReportVO;
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
	public String findAll(Model model,Criteria cri) {
		//List<FreeBoardVO> FreeBoardList = freeBoardService.findAll();
		//model.addAttribute("FreeBoardList", FreeBoardList);
		int totalCnt =  freeBoardService.getTotalPostCount();
	      System.out.println(totalCnt);
	      Paging paging = new Paging();
	      paging.setCri(cri);
	      paging.setTotalCount(totalCnt);
	      System.out.println(cri);
	      System.out.println(paging);
	      List<Map<String, Object>> FreeBoardList = freeBoardService.findAll(cri);
	      //System.out.println(FreeBoardList);
	      model.addAttribute("FreeBoardVO", FreeBoardList);
	      model.addAttribute("paging", paging);
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
	//글쓰기
	@PostMapping("write")
	public String write(MemberVO memberVO,String title,String content,String category, HttpSession session) {
		String id = memberVO.getId();
		System.out.println(id);
		System.out.println(category);
		freeBoardService.registerFreeBoard(title, content,category, id);
		return "redirect:freeBoardList";
	}
	
	//글 상세보기
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
	        mv.addObject("commentList", freeBoardService.findCommentList(freeNo));
	      return mv;
	      
	   }
		
	//글삭제
	@PostMapping("freeDelete")
	public String FreeDelete(int freeNo) {
		freeBoardService.freeDelete(freeNo);
		return "redirect:freeBoardList";
	}
	//글 수정 폼으로 이동
	  @RequestMapping("freeDetailUpdateForm")
	public String freeDetailUpdateForm(int freeNo, HttpServletRequest request, Model model) {
		HttpSession session=request.getSession();
		//세션 만료 시 홈으로 - AOP 대상(cross-cutting concern)
		if (session.getAttribute("mvo") == null)
			return "redirect:home";
		//freeDetail에 freeNo로 포스팅 정보를 전송해준다.
		model.addAttribute("mvo",session);
		model.addAttribute("freeDetail", freeBoardService.getFreeDetail(freeNo));
		System.out.println(freeNo);
		return "freeBoard/freeDetailUpdateForm";
	}
	
	//게시글수정
	@PostMapping("freeUpdate")
	public String freeUpdate(FreeBoardVO freeBoardVO) {
		freeBoardService.freeUpdate(freeBoardVO);
		return "redirect:freeBoardList";
	}
	//신고
	@PostMapping("freeReport")
	public String freeReport(int freeNo) {
		freeBoardService.freeReport(freeNo);
		return "redirect:freeBoardList";
	}
	//신고리스트 보기
	@GetMapping("freeReportList")
	public String freeReportList(Model model) {
		List<ReportVO> reportList = freeBoardService.findReportList();
		model.addAttribute("reportList", reportList);
		System.out.println(reportList);
		return "freeBoard/freeReportList";
	}
	//댓글
	@PostMapping("writeComment")
	public String writeComment(CommentVO commentVO,Model model) {
		System.out.println(commentVO);
		freeBoardService.registerComment(commentVO);
		//freeBoardService.findCommentList();
		//model.addAttribute("commentList",freeBoardService.findCommentList());
		return "redirect:freeDetail?freeNo="+commentVO.getFreeNo();
	}
	//댓글목록
	@RequestMapping("getComment")
	public List<CommentVO> getComment(int freeNo,Model model) {
		List<CommentVO> commentList = freeBoardService.findCommentList(freeNo);
		model.addAttribute("commentList", commentList);
		//System.out.println(commentList);
		return commentList;
	}
	//댓글삭제
	@PostMapping("commentDelete")
	public String commentDelete(int commentNo,int freeNo) {
		freeBoardService.commentDelete(commentNo);
		//System.out.println(commentNo);
		return "redirect:freeDetail?freeNo="+freeNo;
	}
	//카테고리별 조회
	 @RequestMapping("findFreeByCategory")
	   public String findFreeByCategory(Model model, String category) {
	     model.addAttribute("FreeCategory", freeBoardService.findFreeByCategory(category)); 
	     return "freeBoard/freeBoardList"; 
	   }
}










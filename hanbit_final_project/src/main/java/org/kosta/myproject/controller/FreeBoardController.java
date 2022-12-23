package org.kosta.myproject.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	      //System.out.println(totalCnt);
	      Paging paging = new Paging();
	      paging.setCri(cri);
	      paging.setTotalCount(totalCnt);
	      //System.out.println(cri);
	      //System.out.println(paging);
	      List<Map<String, Object>> FreeBoardList = freeBoardService.findAll(cri);
	      //System.out.println(FreeBoardList);
	      model.addAttribute("FreeBoardList", FreeBoardList);
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
	/*
	 * @PostMapping("write") public String write(MemberVO memberVO,String
	 * title,String content,String category, HttpSession session) { String id =
	 * memberVO.getId();
	 * 
	 * freeBoardService.registerFreeBoard(title, content,category, id); return
	 * "redirect:freeBoardList"; }
	 */
	//글쓰기 이미지 추가
	@PostMapping("write")
	   public String write(FreeBoardVO freeBoardVO, HttpSession session, RedirectAttributes ra, @RequestParam("photo") MultipartFile file) {
		   System.out.println(freeBoardVO+"=================");
		   SimpleDateFormat nowTime = new SimpleDateFormat("yyyyMMddHHmmss");
			Date now = new Date();
	      if (session.getAttribute("mvo") == null)
	         return "redirect:noticeBoard/noticeBoardList";
	     
	      MemberVO mvo = (MemberVO) session.getAttribute("mvo");
	      freeBoardVO.setMemberVO(mvo);
	      ra.addAttribute("freeNo", freeBoardVO.getFreeNo());
	      String fileName = null;
	      if (file.isEmpty() == false) {
	      fileName = freeBoardVO.getMemberVO().getId()+"_"+nowTime.format(now)+"_"+ file.getOriginalFilename();
	      freeBoardVO.setImage(fileName);      
	      }
	      try(
	    	      // 윈도우일 경우
	    	      FileOutputStream fos = new FileOutputStream("C:\\kosta250\\git-final\\HanBit\\hanbit_final_project\\src\\main\\resources\\static\\images\\" + fileName);
	    		  
	    		  InputStream is = file.getInputStream();
	    	    ){
	    	      int readCount = 0;
	    	      byte[] buffer = new byte[2048];
	    	      while((readCount = is.read(buffer)) != -1){
	    	      fos.write(buffer,0,readCount);
	    	    }
	    	    }catch(Exception ex){
	    	      throw new RuntimeException("file Save Error");
	    	    }
	      freeBoardService.freeWrite(freeBoardVO);
	      return "redirect:freeBoardList";
	   }
	@RequestMapping("freeWriteResult")
	   public String freeWriteResult(Model model, Criteria cri) {
	      model.addAttribute("FreeBoardList", freeBoardService.findAll(cri));
	      return "freeBoard/freeBoardList";
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
	   public String findFreeByCategory(Model model, String category,Criteria cri) {
		 int totalCnt =  freeBoardService.getTotalPostCountByCategory(category);
		 Paging paging = new Paging();
	     paging.setCri(cri);
	     paging.setTotalCount(totalCnt);
	     List<Map<String, Object>> FreeBoardList = freeBoardService.findFreeByCategory(category,cri);
	   model.addAttribute("FreeBoardList", FreeBoardList);
	   
	     return "freeBoard/freeBoardList :: #freeTbody"; 
	     /*
	      * int totalCnt =  freeBoardService.getTotalPostCount();
	      //System.out.println(totalCnt);
	      Paging paging = new Paging();
	      paging.setCri(cri);
	      paging.setTotalCount(totalCnt);
	      //System.out.println(cri);
	      //System.out.println(paging);
	      List<Map<String, Object>> FreeBoardList = freeBoardService.findAll(cri);
	      //System.out.println(FreeBoardList);
	      model.addAttribute("FreeBoardList", FreeBoardList);
	      model.addAttribute("paging", paging);
	      */
	   }
	
}










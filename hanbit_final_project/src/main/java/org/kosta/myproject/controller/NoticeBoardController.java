package org.kosta.myproject.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.service.Criteria;
import org.kosta.myproject.model.service.NoticeBoardService;
import org.kosta.myproject.model.service.Paging;
import org.kosta.myproject.model.vo.MemberVO;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NoticeBoardController {
   private final NoticeBoardService noticeBoardService;

   /*
    * @RequestMapping("noticeBoardList") public String noticeBoardList(String
    * pageNo, Model model) { NoticeBoardListVO noticeBoardList =
    * noticeBoardService.noticeBoardList(pageNo); model.addAttribute("nblvo",
    * noticeBoardList); return "noticeBoard/noticeBoardList";
    */

   // 게시물 리스트 보기
   @RequestMapping("noticeBoardList")
   public String noticeBoardList(Model model, Criteria cri) {
      int totalCnt =  noticeBoardService.totalPostListCnt();
      System.out.println(totalCnt);
      
      Paging paging = new Paging();
      paging.setCri(cri);
      paging.setTotalCount(totalCnt);
      
      System.out.println(cri);
      System.out.println(paging);
      List<Map<String, Object>> list = noticeBoardService.noticeBoardList1(cri);
      System.out.println(list);
      model.addAttribute("nblvo", list);
      model.addAttribute("paging", paging);
      return "noticeBoard/noticeBoardList";
   }
   
   // 글 전체 조회 (카테고리별로 보기)
 @RequestMapping("findByCategory")
   public String findByCategory(Model model, NoticeBoardVO noticeBoardVO, Criteria cri) {
	 log.debug("param:{}",noticeBoardVO); 
     model.addAttribute("nblvo", noticeBoardService.findNoticeByCategory(noticeBoardVO)); 
     return "noticeBoard/noticeBoardList :: #NoticeCategory"; 
   }

   // 게시물 상세보기
   @RequestMapping("noticeDetail")
   public String noticeDetail(Model model, int noticeNo) {
      NoticeBoardVO vo = noticeBoardService.noticeBoardDetailView(noticeNo);
      model.addAttribute("detail", vo);
      return "noticeBoard/noticeDetail";
   }


   

   // 글쓰기 폼으로 이동 (세션 연결 - 세션 만료시 홈으로)
   @RequestMapping("writeNoticeForm")
   public String writeNoticeForm(HttpSession session) {
      if (session.getAttribute("mvo") == null)
         return "redirect:noticeBoard/noticeBoardList";
      return "noticeBoard/noticeWrite";
   }

   // 글쓰기 (세션 연결)
   @PostMapping("noticeWrite")
   public String write(NoticeBoardVO noticeBoardVO, HttpSession session, RedirectAttributes ra) {
      System.out.println(noticeBoardVO);

      if (session.getAttribute("mvo") == null)
         return "redirect:noticeBoard/noticeBoardList";
      MemberVO mvo = (MemberVO) session.getAttribute("mvo");
      noticeBoardVO.setMemberVO(mvo);
      noticeBoardService.noticeWrite(noticeBoardVO);
      ra.addAttribute("noticeNo", noticeBoardVO.getNoticeNo());
      // return "redirect:noticeBoard/noticeBoardList";
      return "redirect:noticeWriteResult";
   }

   @RequestMapping("noticeWriteResult")
   public String noticeWriteResult(Model model, Criteria cri) {
      model.addAttribute("nblvo", noticeBoardService.noticeBoardList1(cri));
      return "noticeBoard/noticeBoardList";
   }

   /*
    * // 본인이 게시한 게시글 상세보기 (조회수 증가 X) // - 글쓰기, 수정 시 사용
    * 
    * @RequestMapping("noticeDetailwithoutaddhits") public postDetailNoHits(Model
    * model, int noticeNo) { return new ModelAndView("board/post_detail", "pvo",
    * boardService.getPostDetailNoHits(no)); }
    */


}
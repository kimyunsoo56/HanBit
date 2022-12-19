package org.kosta.myproject.controller;

import org.kosta.myproject.model.service.NoticeBoardService;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class NoticeBoardController {
	private final NoticeBoardService noticeBoardService;
	
	/*
	@RequestMapping("noticeBoardList")
	public String noticeBoardList(String pageNo, Model model) {
	NoticeBoardListVO noticeBoardList = noticeBoardService.noticeBoardList(pageNo);
		model.addAttribute("nblvo", noticeBoardList);
		return "noticeBoard/noticeBoardList";
*/
		
	// 게시물 리스트 보기
	@RequestMapping("noticeBoardList")
	public String noticeBoardList(Model model) {
		model.addAttribute("nblvo", noticeBoardService.noticeBoardList1());
		return "noticeBoard/noticeBoardList";
	}
	
	// 게시물 상세보기
	@RequestMapping("noticeDetail")
	public String noticeDetail(Model model, int noticeNo) {
		NoticeBoardVO vo = noticeBoardService.noticeBoardDetailView(noticeNo);
		model.addAttribute("detail", vo);
		return "noticeBoard/noticeDetail";
	}
	
	 // 글 전체 조회 (카테고리별로 보기)
 
	
	// 글쓰기
	@RequestMapping("WriteNoticeBoardForm")
	public String writeNoticeBoardForm() {
		return "noticeBoard/writeNoticeBoardForm";
	}
}

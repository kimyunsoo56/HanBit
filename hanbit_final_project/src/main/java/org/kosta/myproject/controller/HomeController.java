package org.kosta.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value = {"/","home"})
	public String home() {
		return "index";
	}
	@RequestMapping("noticeBoardList")
	public String noticeBoardList() {
		return "noticeBoard/noticeBoardList";
	}
	@RequestMapping("freeBoardList")
	public String freeBoard() {
		return "freeBoard/freeBoardList";
	}
	@RequestMapping("freeDetail")
	public String freeDetail() {
		return "freeBoard/freeDetail";
	}
	@RequestMapping("freeWrite")
	public String freeWrite() {
		return "freeBoard/freeWrite";
	}
}

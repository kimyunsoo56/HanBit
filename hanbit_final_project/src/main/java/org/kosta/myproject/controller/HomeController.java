package org.kosta.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value = {"/","home"})
	public String home() {
		return "index";
	}
	@RequestMapping("noticeBoard")
	public String noticeBoardList() {
		return "noticeBoard/noticeBoardList";
	}
	
}

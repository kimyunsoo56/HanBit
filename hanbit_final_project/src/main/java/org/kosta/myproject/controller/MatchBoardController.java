package org.kosta.myproject.controller;

import org.kosta.myproject.model.service.MatchBoardService;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequiredArgsConstructor
public class MatchBoardController {

	private final MatchBoardService matchBoardService;
	
	
	@RequestMapping("MatchBoardList")
	
	public String MatchBoardList(Model model){
		model.addAttribute("matchList",matchBoardService.matchBoardList());   
		
		return "matchBoard/matchBoard";
	}
	
	
	@RequestMapping("matchDetail")
	
	public String showMatchDetail(Model model,int matchNo){
		//model.addAttribute("numberGot",matchNo); 
		MatchBoardVO vo=matchBoardService.matchDetail(matchNo);
		model.addAttribute("matchDetail",vo);
		
		return "matchBoard/matchDetail";
	}
	
@RequestMapping("WriteMatchBoardForm")
	public String writeMatchBoard(Model model){
		
		return "matchBoard/matchWrite";
	}

	
	  @RequestMapping("findMatchListBylgw") public String
	  findMatchListBylgw(MatchBoardVO matchBoardVO,Model model) {
	  log.debug("param:{}",matchBoardVO); 
	  model.addAttribute("lgwList",
	  matchBoardService.findMatchListBylgw(matchBoardVO)); 
	  // employee/list2 =>  view name 
	  // :: #empTbody 타임리프가 model의 empList를 이용해 생성한 html 요소를 반영할 요소 id
	  return "employee/list2 :: #empTbody"; }
	 

}

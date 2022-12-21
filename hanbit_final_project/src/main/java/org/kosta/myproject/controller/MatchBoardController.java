package org.kosta.myproject.controller;

import org.kosta.myproject.model.service.MatchBoardService;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.kosta.myproject.model.vo.MessageVO;
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
		model.addAttribute("matchNo",matchNo); 
		MatchBoardVO vo=matchBoardService.matchDetail(matchNo);
		model.addAttribute("matchDetail",vo);
		
		return "matchBoard/matchDetail";
	}
	
@RequestMapping("WriteMatchBoardForm")
	public String writeMatchBoard(Model model){
		
		return "matchBoard/matchWrite";
	}

	
	  @RequestMapping("findMatchListBylgw") 
	//  @ResponseBody
	  public String findMatchListBylgw(MatchBoardVO matchBoardVO,Model model) {
	  log.debug("param:{}",matchBoardVO); 
	  model.addAttribute("matchList", matchBoardService.findMatchListBylgw(matchBoardVO)); 
	  return "matchBoard/matchBoard :: #matchTbody"; 
	  }
	  
	  
	  @RequestMapping("Jjim") 
		  public String showJjim(MatchBoardVO matchBoardVO,Model model) {
				/*
				 * log.debug("param:{}",matchBoardVO); model.addAttribute("matchList",
				 * matchBoardService.findMatchListBylgw(matchBoardVO)); return
				 * "matchBoard/matchBoard :: #matchTbody";
				 */
		  
		  return "matchBoard/matchBoard";
		  }
	  
	  @RequestMapping("SendMessage") 
	  public String sendMessage(Model model,String yoyangsaName,String matchBoardId,int matchNo) {
		 model.addAttribute("yoyangsaName",yoyangsaName);
		 model.addAttribute("matchBoardId",matchBoardId);
		 model.addAttribute(matchNo);
			/* model.addAttribute("matchBoardId",matchBoardId); */
	  
	  return "matchBoard/messageForm";
	  }
	  
		
		  @RequestMapping("RealSendMessage") 
		  public String realSendMessage(Model model,MessageVO messageVO,int matchNo) { 
			 System.out.println(messageVO);
			 int result=matchBoardService.realSendMessage(messageVO);
	
			 System.out.println("^^^^^^^^^^^^" + matchNo);
		  return "redirect:matchDetail?matchNo="+matchNo; 
		  }
		  
		// 쪽지함가기 
		     @RequestMapping("myMessage")
		       public String myMessage() {
		          return "matchBoard/myMessage";
		       }
		 
		 
	  
	 
	 

}

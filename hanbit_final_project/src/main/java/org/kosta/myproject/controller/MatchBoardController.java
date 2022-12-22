package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.service.MatchBoardService;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.kosta.myproject.model.vo.MemberVO;
import org.kosta.myproject.model.vo.MessageVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String showMatchDetail(Model model,int matchNo,HttpSession session){
		
		@SuppressWarnings("unchecked")
		ArrayList<Integer> noListMatch = (ArrayList<Integer>) session.getAttribute("noListMatch");
		if (noListMatch.contains(matchNo) == false) {
			matchBoardService.addHits(matchNo);//조회수증가방지없음
			noListMatch.add(matchNo); //noList에 조회한 게시글 no 추가
		}
		
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
	  
	  
	  @RequestMapping("showLike") 
		  public String showLike(MatchBoardVO matchBoardVO,Model model) {
				/*
				 * log.debug("param:{}",matchBoardVO); model.addAttribute("matchList",
				 * matchBoardService.findMatchListBylgw(matchBoardVO)); return
				 * "matchBoard/matchBoard :: #matchTbody";
				 */
		  
		  return "matchBoard/matchBoard";
		  }
	  //쪽지 쓰는 곳으로 넘어가기.
	  @RequestMapping("SendMessage") 
	  public String sendMessage(Model model,String yoyangsaName,String matchBoardId,int matchNo) {
		 model.addAttribute("yoyangsaName",yoyangsaName);
		 model.addAttribute("matchBoardId",matchBoardId);
		 model.addAttribute(matchNo);
			/* model.addAttribute("matchBoardId",matchBoardId); */
	  
	  return "matchBoard/messageForm";
	  }
	  
		//매칭게시판에서 쪽지보내기
		  @RequestMapping("RealSendMessage1") 
		  public String realSendMessage1(Model model,MessageVO messageVO) { 
			 System.out.println(messageVO);
			 int result=matchBoardService.realSendMessage(messageVO);
	
			
		  return "redirect:myMessage"; 
		  }
		  
		  @RequestMapping("RealSendMessage") 
		  public String realSendMessage(Model model,MessageVO messageVO,int matchNo) { 
			 System.out.println(messageVO);
			 int result=matchBoardService.realSendMessage(messageVO);
	
			 System.out.println("^^^^^^^^^^^^" + matchNo);
		  return "redirect:matchDetail?matchNo="+matchNo; 
		  }
		  
		  //글쓰기
		  @PostMapping("registerMatch")
		  public String registerMatch(MatchBoardVO matchBoardVO,Model model, HttpServletRequest request){
		  	
			HttpSession session = request.getSession(false);
			if(session != null && session.getAttribute("mvo") != null) {
				MemberVO mvo = (MemberVO) session.getAttribute("mvo");
				matchBoardVO.setMemberVO(mvo);
			}
		  	System.out.println(matchBoardVO);
		  	int result= matchBoardService.registerMatch(matchBoardVO);
		  	
		  	
		  	return "redirect:MatchBoardList";
		  }
		// 쪽지함가기 (받은편지함)
		     @RequestMapping("myMessage")
		       public String myMessage(Model model,HttpServletRequest request) {
		    	 HttpSession session = request.getSession(false);
		    	 MemberVO memberVO = (MemberVO) session.getAttribute("mvo");
		    	 String id=memberVO.getId();
		    	 model.addAttribute("messageList", matchBoardService.messageList(id));   
		    	 
		    	 
		    	 
		          return "matchBoard/myMessage";
		       }
		     //보낸쪽지함
		     @RequestMapping("myMessage2")
		       public String myMessage2(Model model,HttpServletRequest request) {
		    	 HttpSession session = request.getSession(false);
		    	 MemberVO memberVO = (MemberVO) session.getAttribute("mvo");
		    	 String id=memberVO.getId();
		    	 model.addAttribute("messageList", matchBoardService.messageList1(id));   
		    	 
		    	 
		    	 
		          return "matchBoard/myMessage1";
		       }
		     
		     @RequestMapping("messageDetail")
		       public String myMessageDetail(Model model,HttpSession session,String receiveId,String content,int messageNo) {
		    	 @SuppressWarnings("unchecked")
				ArrayList<Integer> noListMessage = (ArrayList<Integer>) session.getAttribute("noListMessage");
		 		if (noListMessage.contains(messageNo) == false) {
		 			matchBoardService.addChecking(messageNo);//조회수증가방지없음
		 			noListMessage.add(messageNo); //noList에 조회한 게시글 no 추가
		 		} 
		    	 model.addAttribute("receiveId",receiveId);
		    	 model.addAttribute("content",content);
		    	 
		    	 
		    	 
		          return "matchBoard/myMessageDetail";
		       }
		     
		     @RequestMapping("sendMessage2")
		       public String sendMessage2(Model model,HttpServletRequest request,String receiveId) {
		    	/* HttpSession session = request.getSession(false);
		    	 MemberVO memberVO = (MemberVO) session.getAttribute("mvo");
		    	 String id=memberVO.getId();
		    	 model.addAttribute("messageList", matchBoardService.messageList1(id)); */  
		    	 model.addAttribute("receiveId",receiveId);
		          return "matchBoard/messageForm1";
		       }
		     
		     
		    //글 삭제
		     @PostMapping("matchDelete")
		       public String matchDelete(int matchNo) {
		    	matchBoardService.matchDelete(matchNo);
		 		return "redirect:MatchBoardList";
		       }
		     
		     //글 수정폼으로 이동
		     
		     @RequestMapping("matchDetailUpdateForm")
		 	public String matchDetailUpdateForm(int matchNo, HttpServletRequest request, Model model) {
		 		HttpSession session=request.getSession();
		 		//세션 만료 시 홈으로 - AOP 대상(cross-cutting concern)
		 		if (session.getAttribute("mvo") == null)
		 			return "redirect:home";
		 		//freeDetail에 freeNo로 포스팅 정보를 전송해준다.
		 		model.addAttribute("mvo",session);
		 		model.addAttribute("matchDetail", matchBoardService.matchDetail(matchNo));
		 		return "matchBoard/matchDetailUpdateForm";
		 	}
		     
		   //매칭 글 수정
		 	@PostMapping("updateMatch")
		 	public String updateMatch(MatchBoardVO matchBoardVO) {
		 		matchBoardService.updateMatch(matchBoardVO);
		 		System.out.println(matchBoardVO);
		 		return "redirect:MatchBoardList";
		 	}
		 
		 
	
	  
	 
	 
	
}

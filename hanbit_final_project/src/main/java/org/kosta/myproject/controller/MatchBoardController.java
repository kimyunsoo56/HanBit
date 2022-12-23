package org.kosta.myproject.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.service.MatchBoardService;
import org.kosta.myproject.model.vo.LikesVO;
import org.kosta.myproject.model.vo.MatchBoardVO;
import org.kosta.myproject.model.vo.MemberVO;
import org.kosta.myproject.model.vo.MessageVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MatchBoardController {

	private final MatchBoardService matchBoardService;

	@RequestMapping("MatchBoardList")

	public String MatchBoardList(Model model) {
		model.addAttribute("matchList", matchBoardService.matchBoardList());

		return "matchBoard/matchBoard";
	}
	@RequestMapping("showLike")
	public String showLike(Model model,HttpSession session,String id,String matchNo) {
		System.out.println("확인:"+matchNo);
		System.out.println(id);
	
		@SuppressWarnings("unchecked")
		ArrayList<String> noListLike = (ArrayList<String>) session.getAttribute("noListLike");
	
		LikesVO likesVO=new LikesVO();
		likesVO.setId(id);
		likesVO.setMatchNo(Integer.parseInt(matchNo));
		
		if (noListLike.contains(matchNo) == false) {
			noListLike.add(matchNo);
			matchBoardService.addLikes(likesVO);
		}else {
			noListLike.remove(matchNo);
			matchBoardService.removeLikes(likesVO);
			
		}
		for(int i = 0; i<noListLike.size();i++) {
			System.out.println("후: " +noListLike.get(i));
		}
		
		session.setAttribute("noListLike",noListLike);
		

		return "redirect:matchDetail?matchNo="+matchNo;
	}

	@RequestMapping("matchDetail")
	public String showMatchDetail(Model model, int matchNo, HttpSession session) {
		String message="";
		MemberVO vo=(MemberVO) session.getAttribute("mvo");
		String id=vo.getId();

		@SuppressWarnings("unchecked")
		ArrayList<Integer> noListMatch = (ArrayList<Integer>) session.getAttribute("noListMatch");
		if (noListMatch.contains(matchNo) == false) {
			matchBoardService.addHits(matchNo);// 조회수증가방지없음
			noListMatch.add(matchNo); // noList에 조회한 게시글 no 추가
		}
		LikesVO likesVO= new LikesVO();
		likesVO.setId(id);
		likesVO.setMatchNo(matchNo);
		int result=matchBoardService.checkLikes(likesVO);
		if(result==0) {
			model.addAttribute("likePic", "nolike.png");// 동적으로 변화될 수 있는 이미지 정보 
			
		}else {
			
			model.addAttribute("likePic", "like.png");// 동적으로 변화될 수 있는 이미지 정보 
		}
		System.out.println(likesVO);
		System.out.println(result);
		model.addAttribute("matchNo", matchNo);
		MatchBoardVO vo1 = matchBoardService.matchDetail(matchNo);
		model.addAttribute("matchDetail", vo1);
		model.addAttribute("likeMessage",message);
        
		return "matchBoard/matchDetail";
	}

	@RequestMapping("WriteMatchBoardForm")
	public String writeMatchBoard(Model model) {

		return "matchBoard/matchWrite";
	}

	@RequestMapping("findMatchListBylgw")
	// @ResponseBody
	public String findMatchListBylgw(MatchBoardVO matchBoardVO, Model model) {
		log.debug("param:{}", matchBoardVO);
		model.addAttribute("matchList", matchBoardService.findMatchListBylgw(matchBoardVO));
		return "matchBoard/matchBoard :: #matchTbody";
	}

	

	// 쪽지 쓰는 곳으로 넘어가기.
	@RequestMapping("SendMessage")
	public String sendMessage(Model model, String yoyangsaName, String matchBoardId, int matchNo) {
		model.addAttribute("yoyangsaName", yoyangsaName);
		model.addAttribute("matchBoardId", matchBoardId);
		model.addAttribute(matchNo);
		/* model.addAttribute("matchBoardId",matchBoardId); */

		return "matchBoard/messageForm";
	}

	// 매칭게시판에서 쪽지보내기
	@RequestMapping("RealSendMessage1")
	public String realSendMessage1(Model model, MessageVO messageVO) {
		System.out.println(messageVO);
		int result = matchBoardService.realSendMessage(messageVO);

		return "redirect:myMessage";
	}

	@RequestMapping("RealSendMessage")
	public String realSendMessage(Model model, MessageVO messageVO, int matchNo) {
		System.out.println(messageVO);
		int result = matchBoardService.realSendMessage(messageVO);

		System.out.println("^^^^^^^^^^^^" + matchNo);
		return "redirect:matchDetail?matchNo=" + matchNo;
	}

	/*
	 * // 글쓰기
	 * 
	 * @PostMapping("registerMatch") public String registerMatch(MatchBoardVO
	 * matchBoardVO, Model model, HttpServletRequest request) {
	 * 
	 * HttpSession session = request.getSession(false); if (session != null &&
	 * session.getAttribute("mvo") != null) { MemberVO mvo = (MemberVO)
	 * session.getAttribute("mvo"); matchBoardVO.setMemberVO(mvo); }
	 * System.out.println(matchBoardVO); int result =
	 * matchBoardService.registerMatch(matchBoardVO);
	 * 
	 * return "redirect:MatchBoardList"; }
	 */
	
	  // 글쓰기
	  @PostMapping("registerMatch") 
	  public String registerMatch(MatchBoardVO matchBoardVO, Model model, HttpServletRequest request,@RequestParam("photo") MultipartFile file) {
		  SimpleDateFormat nowTime = new SimpleDateFormat("yyyyMMddHHmmss");
			Date now = new Date();
	  HttpSession session = request.getSession(false); 
	  if (session != null && session.getAttribute("mvo") != null) { 
		  MemberVO mvo = (MemberVO) session.getAttribute("mvo"); 
		  matchBoardVO.setMemberVO(mvo); 
		  }
	  System.out.println(matchBoardVO); 
	  
	  //-----------------------------------------------------------
	  
      String fileName = null;
      if (file.isEmpty() == false) {
      fileName = matchBoardVO.getMemberVO().getId()+"_"+nowTime.format(now)+"_"+ file.getOriginalFilename();
      matchBoardVO.setImage(fileName); 
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
	  int result =matchBoardService.registerMatch(matchBoardVO);
	  System.out.println(result);
	  return "redirect:MatchBoardList"; 
	  }
	 
	
	

	// 쪽지함가기 (받은편지함)
	@RequestMapping("myMessage")
	public String myMessage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		MemberVO memberVO = (MemberVO) session.getAttribute("mvo");
		String id = memberVO.getId();
		model.addAttribute("messageList", matchBoardService.messageList(id));

		return "matchBoard/myMessage";
	}

	// 보낸쪽지함
	@RequestMapping("myMessage2")
	public String myMessage2(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		MemberVO memberVO = (MemberVO) session.getAttribute("mvo");
		String id = memberVO.getId();
		model.addAttribute("messageList", matchBoardService.messageList1(id));

		return "matchBoard/myMessage1";
	}

	@RequestMapping("messageDetail")
	public String myMessageDetail(Model model, HttpSession session, String receiveId, String content, int messageNo) {
		@SuppressWarnings("unchecked")
		ArrayList<Integer> noListMessage = (ArrayList<Integer>) session.getAttribute("noListMessage");
		if (noListMessage.contains(messageNo) == false) {
			noListMessage.add(messageNo); // noList에 조회한 게시글 no 추가
		}
		model.addAttribute("receiveId", receiveId);
		model.addAttribute("content", content);

		return "matchBoard/myMessageDetail";
	}

	@RequestMapping("sendMessage2")
	public String sendMessage2(Model model, HttpServletRequest request, String receiveId) {
		/*
		 * HttpSession session = request.getSession(false); MemberVO memberVO =
		 * (MemberVO) session.getAttribute("mvo"); String id=memberVO.getId();
		 * model.addAttribute("messageList", matchBoardService.messageList1(id));
		 */
		model.addAttribute("receiveId", receiveId);
		return "matchBoard/messageForm1";
	}

	// 글 삭제
	@PostMapping("matchDelete")
	public String matchDelete(int matchNo) {
		matchBoardService.matchDelete(matchNo);
		return "redirect:MatchBoardList";
	}

	// 글 수정폼으로 이동

	@RequestMapping("matchDetailUpdateForm")
	public String matchDetailUpdateForm(int matchNo, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 세션 만료 시 홈으로 - AOP 대상(cross-cutting concern)
		if (session.getAttribute("mvo") == null)
			return "redirect:home";
		// freeDetail에 freeNo로 포스팅 정보를 전송해준다.
		model.addAttribute("mvo", session);
		model.addAttribute("matchDetail", matchBoardService.matchDetail(matchNo));
		return "matchBoard/matchDetailUpdateForm";
	}

	// 매칭 글 수정
	@PostMapping("updateMatch")
	public String updateMatch(MatchBoardVO matchBoardVO) {
		matchBoardService.updateMatch(matchBoardVO);
		System.out.println(matchBoardVO);
		return "redirect:MatchBoardList";
	}

}

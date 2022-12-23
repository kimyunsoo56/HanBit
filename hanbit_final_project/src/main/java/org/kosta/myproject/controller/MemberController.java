package org.kosta.myproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.service.MemberService;
import org.kosta.myproject.model.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
   //로그인 폼
    @RequestMapping("loginForm")
    public String loginForm() {
       return "member/login-form";
    }
    // 로그인
    @PostMapping("/login")
	 public String login(MemberVO memberVO,HttpServletRequest request) {
		 MemberVO resultVO=memberService.login(memberVO);
		 if(resultVO==null || resultVO.getEnabled()==2) { 
				return "member/login-fail";
			} else {
				HttpSession session=request.getSession();
				session.setAttribute("mvo", resultVO);
				//자유게시판 조회수 증가 방지를 위한 작업
				session.setAttribute("noList",  new ArrayList<Integer>());
				//매칭 게시판 조회수
				session.setAttribute("noListMatch",  new ArrayList<Integer>());
				//쪽지 읽음 여부!
				session.setAttribute("noListMessage",  new ArrayList<Integer>());
				//찜을 위한 세션 생성
				session.setAttribute("noListLike",new ArrayList<String>());
				
				return "redirect:/";
			}
	 }
    // 로그아웃
     @PostMapping("logout") 
         public String logout(HttpServletRequest request) {
            HttpSession session=request.getSession(false);
            if(session!=null) 
               session.invalidate();
            return "redirect:/";
    }
     // 마이페이지 
     @RequestMapping("myPage")
       public String myPage() {
          return "member/myPage";
       }
     // 회원정보상세조회
     @GetMapping("/myPageDetail")
       public String myPageDetail(HttpServletRequest request,Model model) {
        HttpSession session=request.getSession(false);
        MemberVO memberVO=(MemberVO) session.getAttribute("mvo");   
        session.setAttribute("mvo", memberVO);
          return "member/myPageDetailList";
     }
   // register form 에서 for문 돌릴 select 부분을 model에 담아서 넘겨줌
   @RequestMapping("registerMemberForm")
   public String registerForm(Model model) {
      List<String> question=new ArrayList<>();
      question.add("가장 기억에 남는 장소는?");
      question.add("나의 좌우명은?");
      question.add("나의 보물 제1호는?");
      question.add("인상 깊게 읽은 책 이름은?");
      question.add("내가 존경하는 인물은?");
      question.add("나의 출신 초등학교는?");
      question.add("나의 노래방 애창곡은?");
      model.addAttribute("questionList", question);
      return "member/register-form";
   }
   // 회원가입 폼
   @PostMapping("registerMember")
   public String register(MemberVO memberVO) {
      memberService.register(memberVO);
      return "redirect:registerMemberResult";
   }
   // 회원가입
   @RequestMapping("registerMemberResult")
   public String registerMemberResult() {
      return "member/register-result";
   }
   // 아이디 중복체크 Ajax
   @RequestMapping("registerMemberCheckId")
   @ResponseBody
   public MemberVO registerCheckId(String id) {
      MemberVO checkId=memberService.findMemberById(id);
      return checkId;
   }
   // 연락처 중복체크 Ajax
   @RequestMapping("registerMemberCheckTel")
   @ResponseBody
   public int registerCheckTel(String tel) {
      int checkTel=memberService.checkTel(tel);
      return checkTel;
   }
   // 아이디 찾기 폼
   @RequestMapping("findIdForm")
   public String findIdForm() {
      return "member/findid-form";
   } 
   // 아이디 찾기
   @RequestMapping("findId")
   public String findId(String name,String tel,Model model) {
      String viewName=null;
      String findId=memberService.findId(name,tel);
      if(findId==null) {
         viewName="member/findid-fail";
      }else {
         model.addAttribute("memberId", findId);
         viewName="member/findid-ok";
      }
      return viewName;
   }
   // 비밀번호 찾기 폼
   @RequestMapping("findPasswordForm")
   public String findPasswordForm(Model model) {
      List<String> question=new ArrayList<>();
      question.add("가장 기억에 남는 장소는?");
      question.add("나의 좌우명은?");
      question.add("나의 보물 제1호는?");
      question.add("인상 깊게 읽은 책 이름은?");
      question.add("내가 존경하는 인물은?");
      question.add("나의 출신 초등학교는?");
      question.add("나의 노래방 애창곡은?");
      model.addAttribute("questionList", question);
      return "member/findpassword-form";
   }
   // 비밀번호 찾기
   @RequestMapping("findPassword")
   public String findPassword(String id,String name,String tel,String question,String answer,Model model) {
      String viewName=null;
      String findPassword=memberService.findPassword(id,name,tel,question,answer);
      if(findPassword==null) {
         viewName="member/findpassword-fail";
      }else {
         model.addAttribute("memberPassword", findPassword);
         viewName="member/findpassword-ok";
      }
      return viewName;
   }
   // 요양보호사 등록 폼
   @RequestMapping("registerCareWorkerForm")
   public String registerCareWorkerForm(Model model) {
      // 성별
      List<String> gender=new ArrayList<>();
      gender.add("남성");
      gender.add("여성");
      model.addAttribute("genderList", gender);
      // 경력
      List<String> workHistory=new ArrayList<>();
      workHistory.add("신입");
      workHistory.add("1년 미만");
      workHistory.add("1년~3년");
      workHistory.add("3년~5년");
      workHistory.add("5~7년");
      workHistory.add("7년~10년");
      workHistory.add("10년 이상");
      model.addAttribute("workHistoryList", workHistory);
      // 지역
      List<String> location=new ArrayList<>();
      location.add("서울");
      location.add("경기");
      location.add("강원");
      location.add("충북");
      location.add("충남");
      location.add("전북");
      location.add("전남");
      location.add("경북");
      location.add("경남");
      location.add("제주");
      model.addAttribute("locationList", location);
      // 근무타입
      List<String> workType=new ArrayList<>();
      workType.add("자택근무");
      workType.add("병원근무");
      model.addAttribute("workTypeList", workType);
      return "member/register-careworker-form";
   }
   // 자격증 번호 중복체크
	@RequestMapping("registerCheckLicenseNo")
	@ResponseBody
	public int registerCheckLicenseNo(int licenseNo) {
		int checkLicenseNo=memberService.checkLicenseNo(licenseNo);
		return checkLicenseNo;
	}
	// 요양보호사 등록
	@PostMapping("registerCareWorker")
	public String registerCareWorker(MemberVO memberVO,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		memberService.registerCareWorker(memberVO);
		String id=mvo.getId();
		mvo=memberService.findMemberById(id);
		session.setAttribute("mvo", mvo);
		return "redirect:registerCareWorkerResult";
	}
	// 요양보호사 등록 결과
	@RequestMapping("registerCareWorkerResult")
	public String registerCareWorkerResult() {
		return "member/register-careworker-result";
	}
   // 탈퇴 페이지 폼 
    @RequestMapping("deleteMemberForm")
    public String deleteMemberForm(Model model) {
       List<String> delectquestion=new ArrayList<>();
       delectquestion.add("가장 기억에 남는 장소는?");
       delectquestion.add("나의 좌우명은?");
       delectquestion.add("나의 보물 제1호는?");
       delectquestion.add("인상 깊게 읽은 책 이름은?");
       delectquestion.add("내가 존경하는 인물은?");
       delectquestion.add("나의 출신 초등학교는?");
       delectquestion.add("나의 노래방 애창곡은?");
       model.addAttribute("delectquestionList", delectquestion);
       return "member/deleteMember-form";
    }
    // 회원탈퇴 
    // 회원탈퇴는 메서드명만 회원 탈퇴로 delect이고 쿼리문은 update 로 작동한다. 
     @PostMapping("deleteMember") 
     @ResponseBody
     public String deleteMember(HttpServletRequest request,MemberVO memberVO) { 
    	HttpSession session=request.getSession(false);
    	MemberVO mvo = (MemberVO) session.getAttribute("mvo");
    	memberVO.setId(mvo.getId());
    	int result = memberService.deleteMember(memberVO);
    	if(result == 1) {
			mvo = memberService.findMemberById(mvo.getId());
	    	session.setAttribute("mvo", mvo);
	    	session.invalidate();
	    	return "ok";
    	} else {
    		return "fail";
    	}
       }
     
   // 회원 정보 수정 폼
      @RequestMapping("updateMemberForm")
      public String updateMemberForm(Model model) {
         // 개별질문
         List<String> question = new ArrayList<>();
         question.add("가장 기억에 남는 장소는?");
         question.add("나의 좌우명은?");
         question.add("나의 보물 제1호는?"); 
         question.add("인상 깊게 읽은 책 이름은?");
         question.add("내가 존경하는 인물은?");
         question.add("나의 출신 초등학교는?");
         question.add("나의 노래방 애창곡은?");
         model.addAttribute("questionList", question);
         // 경력
         List<String> workHistory = new ArrayList<>();
         workHistory.add("신입");
         workHistory.add("1년 미만");
         workHistory.add("1년~3년");
         workHistory.add("3년~5년");
         workHistory.add("5~7년");
         workHistory.add("7년~10년");
         workHistory.add("10년 이상");
         model.addAttribute("workHistoryList", workHistory);
         // 지역
         List<String> location = new ArrayList<>();
         location.add("서울");
         location.add("경기");
         location.add("강원");
         location.add("충북");
         location.add("충남");
         location.add("전북");
         location.add("전남");
         location.add("경북");
         location.add("경남");
         location.add("제주");
         model.addAttribute("locationList", location);
         // 근무형태
         List<String> workType = new ArrayList<>();
         workType.add("자택근무");
         workType.add("병원근무");
         model.addAttribute("workTypeList", workType);
         return "member/update-member-form";
      }
      // 회원 정보 수정
      @PostMapping("updateMember")
      public String updateMember(MemberVO memberVO,HttpServletRequest request) {
    	  HttpSession session=request.getSession(false);
    	  MemberVO mvo = (MemberVO) session.getAttribute("mvo");
    	  memberService.updateMember(memberVO);
    	  String id=mvo.getId();
    	  mvo=memberService.findMemberById(id);
    	  session.setAttribute("mvo", mvo);
    	  return "redirect:updateMemberResult";
      }
      @RequestMapping("updateMemberResult")
      public String updateMemberResult() {
    	  return "member/update-member-result";
      }
      // 연락처 중복체크 Ajax
      @RequestMapping("updateCheckTel")
      @ResponseBody
      public int updateCheckTel(String tel) {
         int checkTel=memberService.checkTel(tel);
         return checkTel;
      }
/*      // 내가쓴글, 작성글조회
      @GetMapping("/myPagePostList")
      public String myPagePostList(HttpServletRequest request, Model model) {
		ArrayList<FreeBoardVO> myPagePostList= FreeBoardService.

		model.addAttribute("FreeBoardList", FreeBoardService.FreeBoardList());
		//model.addAttribute("MatchBoardList", MatchBoardService.MatchBoardList());
         return "member/myPagePostList";*/
    }

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
import org.kosta.myproject.model.service.NoticeBoardService;
import org.kosta.myproject.model.service.Paging;
import org.kosta.myproject.model.vo.CommentVO;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.kosta.myproject.model.vo.MemberVO;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.kosta.myproject.model.vo.NoticeCommentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
		int totalCnt = noticeBoardService.totalPostListCnt();
		// System.out.println(totalCnt);

		Paging paging = new Paging();
		paging.setCri(cri);
		paging.setTotalCount(totalCnt);

		// System.out.println(cri);
		// System.out.println(paging);
		List<Map<String, Object>> list = noticeBoardService.noticeBoardList1(cri);
		// System.out.println(list);
		model.addAttribute("nblvo", list);
		model.addAttribute("paging", paging);
		return "noticeBoard/noticeBoardList";
	}

	// 글 전체 조회 (카테고리별로 보기)

	/*
	 * @RequestMapping("findByCategory") public String findByCategory(Model model,
	 * NoticeBoardVO noticeBoardVO, Criteria cri) {
	 * log.debug("param:{}",noticeBoardVO);
	 * model.addAttribute("nblvo",noticeBoardService.findNoticeByCategory(
	 * noticeBoardVO)); return "noticeBoard/noticeBoardList :: #NoticeCategory"; }
	 */

	// 글 전체 조회 (카테고리별로 보기) - 페이징 적용
	@RequestMapping("findByCategory")
	public String findByCategory(Model model, Criteria cri) {
		int totalCnt = noticeBoardService.totalPostListCnt();
		Paging paging = new Paging();
		List<Map<String, Object>> list = noticeBoardService.findByCategory(cri);
		model.addAttribute("nblvo", list);
		model.addAttribute("paging", paging);
		return "noticeBoard/noticeBoardList :: #NoticeCategory";
	}

	// 게시물 상세보기
	@RequestMapping("noticeDetail")
	public String noticeDetail(Model model, int noticeNo, HttpSession session) {
		session.getAttribute("mvo");
		@SuppressWarnings("unchecked")
		ArrayList<Integer> noList = (ArrayList<Integer>) session.getAttribute("noList");
		if (noList.contains(noticeNo) == false) {
			noticeBoardService.addHits(noticeNo);// 조회수증가방지없음
			noList.add(noticeNo); // noList에 조회한 게시글 no 추가
		}
		NoticeBoardVO vo = noticeBoardService.noticeBoardDetailView(noticeNo);
		// System.out.println(vo);
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
	public String write(NoticeBoardVO noticeBoardVO, HttpSession session, RedirectAttributes ra,
			@RequestParam("photo") MultipartFile file) {
		System.out.println(noticeBoardVO + "=================");
		SimpleDateFormat nowTime = new SimpleDateFormat("yyyyMMddHHmmss");
		Date now = new Date();

		if (session.getAttribute("mvo") == null)
			return "redirect:noticeBoard/noticeBoardList";

		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		noticeBoardVO.setMemberVO(mvo);
		ra.addAttribute("noticeNo", noticeBoardVO.getNoticeNo());
		String fileName = null;
		if (file.isEmpty() == false) {
			fileName = noticeBoardVO.getMemberVO().getId() + "_" + nowTime.format(now) + "_"
					+ file.getOriginalFilename();
			noticeBoardVO.setImage(fileName);
		}
		try (
				// 윈도우일 경우
				FileOutputStream fos = new FileOutputStream(
						"C:\\kosta250\\git-final\\HanBit\\hanbit_final_project\\src\\main\\resources\\static\\images\\"
								+ fileName);

				InputStream is = file.getInputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[2048];
			while ((readCount = is.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}
		noticeBoardService.noticeWrite(noticeBoardVO);
		return "redirect:noticeBoardList";
	}

	@RequestMapping("noticeWriteResult")
	public String noticeWriteResult(Model model, Criteria cri) {
		model.addAttribute("nblvo", noticeBoardService.noticeBoardList1(cri));
		return "noticeBoard/noticeBoardList";
	}

	// 글 삭제
	@PostMapping("noticeDelete")
	public String noticeDelete(int noticeNo) {
		noticeBoardService.noticeDelete(noticeNo);
		return "redirect:noticeBoardList";
	}

	// 글 수정 폼으로 이동//안ㄴ됨
	@RequestMapping("noticeUpdateForm")
	public String noticeUpdateForm(int noticeNo, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		// 세션 만료 시 홈으로 - AOP 대상(cross-cutting concern)
		if (session.getAttribute("mvo") == null)
			return "redirect:home";
		// freeDetail에 freeNo로 포스팅 정보를 전송해준다.
		model.addAttribute("mvo", session);
		model.addAttribute("detail", noticeBoardService.noticeBoardDetailView(noticeNo));
		System.out.println(noticeNo);
		return "noticeBoard/noticeUpdateForm";
	}

	// 게시글수정
	@PostMapping("noticeUpdate")
	public String noticeUpdate(NoticeBoardVO noticeBoardVO) {
		noticeBoardService.noticeUpdate(noticeBoardVO);
		return "redirect:noticeBoardList";
	}
	/*
	// 댓글 작성
	@PostMapping("writeComment")
	public String writeComment(NoticeCommentVO commentVO,Model model,  RedirectAttributes ra) {
		System.out.println(commentVO);
		noticeBoardService.registerComment(commentVO);
		//freeBoardService.findCommentList();
	 //model.addAttribute("commentList",freeBoardService.findCommentList());
		ra.addAttribute("noticeNo", commentVO.getNoticeNo());
		return "redirect:noticeDetail?noticeNo="+commentVO.getNoticeNo();
	}
	
	//댓글목록
	@RequestMapping("getComment")
	public List<NoticeCommentVO> getComment(int noticeNo, Model model) {
		List<NoticeCommentVO> commentList = noticeBoardService.findCommentList(noticeNo);
		model.addAttribute("commentList", commentList);
		//System.out.println(commentList);
		return commentList;
	}
	
*/
}
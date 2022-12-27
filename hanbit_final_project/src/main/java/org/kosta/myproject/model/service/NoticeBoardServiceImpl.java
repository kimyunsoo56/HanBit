package org.kosta.myproject.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.myproject.model.mapper.NoticeBoardMapper;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.kosta.myproject.model.vo.NoticeCommentVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeBoardServiceImpl implements NoticeBoardService {
	private final NoticeBoardMapper noticeBoardMapper;

	// 게시물 목록 조회(페이지네이션 적용 ) 
	@Override
	public List<Map<String, Object>> noticeBoardList1(Criteria cri) {
		return noticeBoardMapper.noticeBoardList1(cri);
	}

	// 게시물 상세보기
	@Override
	public NoticeBoardVO noticeBoardDetailView(int noticeNo) {
		return noticeBoardMapper.noticeBoardDetailView(noticeNo);
	}
	
	@Override
	public void addHits(int noticeNo) {
		noticeBoardMapper.addHits(noticeNo);
	}


	// 글쓰기 ( 세션 연결 ) 
	@Override
	public void noticeWrite(NoticeBoardVO noticeBoardVO) {
		noticeBoardMapper.noticeWrite(noticeBoardVO);	
	}

	// 글쓰기
	@Override
	public void writeNoticeBoardForm(NoticeBoardVO noticeBoardVO) {
	}

	@Override
	public int totalPostListCnt() {
		int count = noticeBoardMapper.totalPostListCnt();
		return count;
	}
	//글삭제
	@Override
	public void noticeDelete(int noticeNo) {
		noticeBoardMapper.noticeDelete(noticeNo);
		
	}

	// 게시물 수정
	@Override
	public void noticeUpdate(NoticeBoardVO noticeBoardVO) {
		noticeBoardMapper.noticeUpdate(noticeBoardVO);
		
	}

	// 댓글 등록
	@Override
	public void registerComment(NoticeCommentVO commentVO) {
		noticeBoardMapper.registerComment(commentVO);
	}
	
	// 댓글 목록 조회
	@Override
	public List<NoticeCommentVO> findCommentList(int noticeNo) {
		List<NoticeCommentVO> commentList = noticeBoardMapper.findCommentList(noticeNo);
		return commentList;
	}
	
	// 댓글 삭제
		@Override
	public void commentDelete(int commentNo) {
		noticeBoardMapper.commentDelete(commentNo);
	}

	//카테고리 별 게시물 조회
	@Override
	public int getTotalPostCountByCategory(String category) {
		int count = noticeBoardMapper.getTotalPostCountByCategory(category);
		return count;
	}

	// 카테고리 별 게시물 조회
	@Override
	public List<Map<String, Object>> findNoticeByCategory(Criteria cri, String category) {
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("cri", cri);
		paramMap.put("category", category);
		return noticeBoardMapper.findNoticeByCategory(paramMap);
	}
}

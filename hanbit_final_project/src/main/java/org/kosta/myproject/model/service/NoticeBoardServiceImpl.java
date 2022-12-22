package org.kosta.myproject.model.service;

import java.util.List;
import java.util.Map;

import org.kosta.myproject.model.mapper.NoticeBoardMapper;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeBoardServiceImpl implements NoticeBoardService {
	private final NoticeBoardMapper noticeBoardMapper;

	// noticeBoardList() : 페이지 번호가 없을 때는 default 1 page
	/*
	 * @Override public NoticeBoardListVO noticeBoardList() { return
	 * noticeBoardList("1"); }
	 */

	// noticeBoardList(String pageNo) 오버로딩
	//@Override
	/*
	 * public NoticeBoardListVO noticeBoardList(String pageNo) { int postTotalCount
	 * = noticeBoardMapper.getTotalPostCount(); PagingBean pagingBean = null; if
	 * (pageNo == null) pagingBean = new PagingBean(postTotalCount); else pagingBean
	 * = new PagingBean(postTotalCount, Integer.parseInt(pageNo)); NoticeBoardListVO
	 * noticeBoardListVO = new
	 * NoticeBoardListVO(noticeBoardMapper.noticeBoardList(pagingBean), pagingBean);
	 * 
	 * return noticeBoardListVO; }
	 */

	// 게시물 목록 조회(페이지네이션 적용 ) 
	@Override
	public List<Map<String, Object>> noticeBoardList1(Criteria cri) {
		return noticeBoardMapper.noticeBoardList1(cri);
	}
	
	// 카테고리별 조회 (페이징 적용)
	@Override
	public List<Map<String, Object>> findByCategory(Criteria cri) {
		return  noticeBoardMapper.findByCategory(cri);
	}
	
	// 게시물 카테고리별 조회
	//@Override
	/* public List<NoticeBoardVO> noticeFindByCategory(NoticeBoardVO noticeBoardVO) {
		
		return noticeBoardMapper.noticeFindByCategory(noticeBoardVO);
	}*/

	// 게시물 상세보기
	@Override
	public NoticeBoardVO noticeBoardDetailView(int noticeNo) {
		return noticeBoardMapper.noticeBoardDetailView(noticeNo);
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


	/*
	 * @Override public List<NoticeBoardVO> findNoticeByCategory(NoticeBoardVO
	 * noticeBoardVO) { return
	 * noticeBoardMapper.findNoticeByCategory(noticeBoardVO); }
	 */




}

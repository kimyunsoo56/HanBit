package org.kosta.myproject.model.service;

import java.util.List;

import org.kosta.myproject.model.mapper.NoticeBoardMapper;
import org.kosta.myproject.model.vo.NoticeBoardListVO;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeBoardServiceImpl implements NoticeBoardService {
	private final NoticeBoardMapper noticeBoardMapper;

	// noticeBoardList() : 페이지 번호가 없을 때는 default 1 page
	@Override
	public NoticeBoardListVO noticeBoardList() {
		return noticeBoardList("1");
	}

	// noticeBoardList(String pageNo) 오버로딩
	@Override
	public NoticeBoardListVO noticeBoardList(String pageNo) {
		int postTotalCount = noticeBoardMapper.getTotalPostCount();
		PagingBean pagingBean = null;
		if (pageNo == null)
			pagingBean = new PagingBean(postTotalCount);
		else
			pagingBean = new PagingBean(postTotalCount, Integer.parseInt(pageNo));
		NoticeBoardListVO noticeBoardListVO = new NoticeBoardListVO(noticeBoardMapper.noticeBoardList(pagingBean), pagingBean);

		return noticeBoardListVO;
	}

	// 게시물 목록 조회(페이지네이션 적용 전) 
	@Override
	public List<NoticeBoardVO> noticeBoardList1() {
		return noticeBoardMapper.noticeBoardList1();
	}

	// 게시물 상세보기
	@Override
	public NoticeBoardVO noticeBoardDetailView(int noticeNo) {
		return noticeBoardMapper.noticeBoardDetailView(noticeNo);
	}

	// 글쓰기
	@Override
	public void writeNoticeBoardForm (NoticeBoardVO noticeBoardVO) {
		noticeBoardMapper.writeNoticeBoardForm(noticeBoardVO);
	}

}

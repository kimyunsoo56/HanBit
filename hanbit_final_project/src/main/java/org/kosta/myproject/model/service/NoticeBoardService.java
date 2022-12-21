package org.kosta.myproject.model.service;

import java.util.List;

import org.kosta.myproject.model.vo.NoticeBoardListVO;
import org.kosta.myproject.model.vo.NoticeBoardVO;

public interface NoticeBoardService {

// noticeBoardList() : 페이지 번호가 없을 때는 default 1 page
NoticeBoardListVO noticeBoardList();

// noticeBoardList(String pageNo) 오버로딩
NoticeBoardListVO noticeBoardList(String pageNo);

// noticeBoardList - 페이지네이션 뺸 거
List<NoticeBoardVO> noticeBoardList1();

// 카테고리별 조회
List<NoticeBoardVO> noticeFindByCategory(NoticeBoardVO noticeBoardVO);

// 게시물 조회 (PagingBean 객체 매개변수로 설정)
// List<NoticeBoardVO> getListWithPaging(Criteria cri);

// noticeBoardDetailView 게시물 상세보기
NoticeBoardVO noticeBoardDetailView(int noticeNo);

// writeNoticeBoardForm 게시물 작성 
void writeNoticeBoardForm(NoticeBoardVO noticeBoardVO);

// noticeWrite 게시물 작성 (세션 연결)
void noticeWrite(NoticeBoardVO noticeBoardVO);


}

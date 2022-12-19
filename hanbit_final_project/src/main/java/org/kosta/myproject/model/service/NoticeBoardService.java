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

// noticeBoardDetailView 게시물 상세보기
NoticeBoardVO noticeBoardDetailView(int noticeNo);

void writeNoticeBoardForm(NoticeBoardVO noticeBoardVO);

}

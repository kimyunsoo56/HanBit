package org.kosta.myproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.model.mapper.NoticeBoardMapper;
import org.kosta.myproject.model.vo.NoticeBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HanbitJunitTestCes {
	private NoticeBoardMapper noticeBoardMapper;

	@Autowired
	public HanbitJunitTestCes(NoticeBoardMapper noticeBoardMapper) {
		super();
		this.noticeBoardMapper = noticeBoardMapper;
	}
	/*
	 * @Test public void boardTest() {
	 * 
	 * // 0. 총 게시물 수 int totalPostCount = noticeBoardMapper.getTotalPostCount();
	 * System.out.println("총 게시물 수 : " + totalPostCount);
	 * 
	 * // 총 페이지 수를 기준으로 PagingBean 객체 생성 PagingBean pagingBean = new
	 * PagingBean(totalPostCount);
	 * 
	 * // 1. 게시물 리스트 List<NoticeBoardVO> list =
	 * noticeBoardMapper.noticeBoardList(pagingBean); for(NoticeBoardVO vo:list) {
	 * System.out.println(vo); }
	 */

	/*
	 * @Test public void NoticeBoardList() { List<NoticeBoardVO> list =
	 * noticeBoardMapper.noticeBoardList1(); Assertions.assertEquals(3,
	 * list.size()); }
	 */

	@Test
	public void NoticeBoardDetailView() {
		int noticeNo = 3;
		NoticeBoardVO vo = noticeBoardMapper.noticeBoardDetailView(noticeNo);
		Assertions.assertEquals("테스트3", vo.getTitle());
		// System.out.println(vo.getTitle());
	}

}
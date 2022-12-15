package org.kosta.myproject.model.vo;

import lombok.Data;

@Data
public class NoticeBoardVO {
	private int noticeNo;
	private String title;
	private String content;
	private String timePosted;
	private int hits;
	private String category;
	private String image;
	private MemberVO memberVO;
}

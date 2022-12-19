package org.kosta.myproject.model.vo;

import lombok.Data;

@Data
public class MatchBoardVO {
	private int matchNo;
	private String title;
	private String content;
	private String timePosted;
	private int hits;
	private String image;
	private MemberVO memberVO;
	
}

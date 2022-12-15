package org.kosta.myproject.model.vo;

import lombok.Data;

@Data
public class CommentVO {
	private int commentNo;
	private String content;
	private String timePosted;
	private MemberVO memberVO;
	private FreeBoardVO freeBoardVO;
}

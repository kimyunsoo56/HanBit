package org.kosta.myproject.model.vo;

import lombok.Data;

@Data
public class CommentVO {
	private int commentNo;
	private int freeNo;
	private String content;
	private String timePosted;
	//private MemberVO memberVO;
	private String id;
	//private FreeBoardVO freeBoardVO;
}

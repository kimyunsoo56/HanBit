package org.kosta.myproject.model.vo;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeCommentVO {
	private int commentNo;
	private int NoticeNo;
	private String content;
	private String timePosted;
	//private MemberVO memberVO;
	private String id;
	//private FreeBoardVO freeBoardVO;
	}

package org.kosta.myproject.model.vo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class NoticeBoardVO {
	private int noticeNo;
	private String title;
	private String content;
	private String timePosted;
	private int hits;
	private String category;
	private String image; // 첨부 이미지명
	private String link; // 링크 
	private MemberVO memberVO;
}

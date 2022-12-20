package org.kosta.myproject.model.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeBoardVO {
	private int noticeNo;
	private String title;
	private String content;
	private String timePosted;
	private int hits;
	private String category;
	private String image; // 첨부 이미지
	private MemberVO memberVO;
}

package org.kosta.myproject.model.vo;

import lombok.Data;

@Data
public class MessageVO {
	private int messageNo;
	private String content;
	private int checking;
	private String timePosted;
	private MemberVO sendMemberVO;
	private MemberVO receiveMemberVO;
}

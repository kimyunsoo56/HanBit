package org.kosta.myproject.model.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO implements Serializable{
	private static final long serialVersionUID = -7501348360157428756L;
	private String id;
	private String password;
	private String name;
	private String nick;
	private String question;
	private String answer;
	private String tel;
	private int enabled;
	private int memberType;
	private int licenseNo;
	private String gender;
	private String workHistory;
	private String location;
	private String workType;
	
	// 회원가입시 필요한 생성자
	public MemberVO(String id, String password, String name, String nick, String question, String answer, String tel) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nick = nick;
		this.question = question;
		this.answer = answer;
		this.tel = tel;
	}
	// 요양보호사 등록 시 필요한 생성자
	public MemberVO(String id, int memberType, int licenseNo, String gender, String workHistory, String location,
			String workType) {
		super();
		this.id = id;
		this.memberType = memberType;
		this.licenseNo = licenseNo;
		this.gender = gender;
		this.workHistory = workHistory;
		this.location = location;
		this.workType = workType;
	}
	// 회원정보 수정시 필요한 생성자
	public MemberVO(String id, String password, String name, String nick, String question, String answer, String tel,
			String gender, String workHistory, String location, String workType) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nick = nick;
		this.question = question;
		this.answer = answer;
		this.tel = tel;
		this.gender = gender;
		this.workHistory = workHistory;
		this.location = location;
		this.workType = workType;
	}
	// 회원 탈퇴 시 필요한 생성자
	public MemberVO(String id, String password, String question, String answer, int enabled) {
		super();
		this.id = id;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.enabled = enabled;
	}

}

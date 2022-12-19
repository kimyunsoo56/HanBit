package org.kosta.myproject.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.vo.MemberVO;

@Mapper
public interface MemberMapper {

	MemberVO login(MemberVO memberVO);

	public MemberVO myPageDetail(String id);

	MemberVO findMemberById(String id);

	int registerMember(MemberVO memberVO);

	int checkNick(String nick);

	int checkTel(String tel);

	String findId(String name, String tel);

	String findPassword(String id, String name, String tel, String question, String answer);

	int checkLicenseNo(int licenseNo);

	void registerCareWorker(MemberVO memberVO);

}

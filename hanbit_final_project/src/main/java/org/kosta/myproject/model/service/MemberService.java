package org.kosta.myproject.model.service;

import org.kosta.myproject.model.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

	MemberVO login(MemberVO memberVO);

	MemberVO myPageDetail(String id);
	
	MemberVO findMemberById(String id);

	int register(MemberVO memberVO);

	int checkTel(String tel);

	String findId(String name, String tel);

	String findPassword(String id, String name, String tel, String question, String answer);

	int checkLicenseNo(int licenseNo);

	void registerCareWorker(MemberVO memberVO);

	void updateMember(MemberVO memberVO);

	void deleteMember(MemberVO memberVO);
	
}

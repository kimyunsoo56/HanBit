package org.kosta.myproject.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.vo.MemberVO;

@Mapper
public interface MemberMapper {

	MemberVO findMemberById(String id);

	int registerMember(MemberVO memberVO);

	int checkNick(String nick);

	int checkTel(String tel);

}

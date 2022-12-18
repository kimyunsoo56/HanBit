package org.kosta.myproject.model.service;

import org.kosta.myproject.model.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

	MemberVO login(MemberVO memberVO);
	
}

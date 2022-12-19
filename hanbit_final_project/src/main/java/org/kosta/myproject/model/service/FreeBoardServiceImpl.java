package org.kosta.myproject.model.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.mapper.FreeBoardMapper;
import org.kosta.myproject.model.vo.FreeBoardVO;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	@Resource
	private FreeBoardMapper freeBoardMapper;
	

	// write(PostVO) : 글쓰기
	@Override
	public void write(FreeBoardVO freeBoardVO) {
		freeBoardMapper.write(freeBoardVO);	
	}
	//글목록

	@Override
	public List<FreeBoardVO> findAll() {
		//List<BoardEntity> boardEntityList = br.findAll();
		List<FreeBoardVO> FreeBoardList = freeBoardMapper.findAll();
		return FreeBoardList;
	}
	//게시글상세보기
	@Override
	public FreeBoardVO getFreeDetail(int freeNo) {
		return freeBoardMapper.getFreeDetail(freeNo);
	}

	@Override
	public void addHits(int freeNo) {
		freeBoardMapper.addHits(freeNo);
	}


	

	//조회수증가
	/*@Override
	public int updateHits(int freeNo, String id, HttpServletRequest request, HttpServletResponse response)  {
		//String id=freeBoardMapper.getFreeDetail(freeNo).getMemberVO().getId();
        Cookie[] cookies = request.getCookies();
        boolean checkCookie = false;
        int result=0;
        if(cookies != null){
            for (Cookie cookie : cookies)
            {
                // 이미 조회를 한 경우 체크
                if (cookie.getName().equals(VIEWCOOKIENAME+id)) checkCookie = true;
            }
            if(!checkCookie){
                Cookie newCookie = createCookieForForNotOverlap(id);
                response.addCookie(newCookie);
                result = freeBoardMapper.updateHits(freeNo);
            }
        } else {
            Cookie newCookie = createCookieForForNotOverlap(id);
            response.addCookie(newCookie);
            result = freeBoardMapper.updateHits(freeNo);
        }
        return result;
    }
	private Cookie createCookieForForNotOverlap(String id) {
        Cookie cookie = new Cookie(VIEWCOOKIENAME+id, String.valueOf(id));
        cookie.setComment("조회수 중복 증가 방지 쿠키");	// 쿠키 용도 설명 기재
        cookie.setMaxAge(getRemainSecondForTommorow()); 	// 하루를 준다.
        cookie.setHttpOnly(true);				// 서버에서만 조작 가능
        return cookie;
    }
	private int getRemainSecondForTommorow() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tommorow = LocalDateTime.now().plusDays(1L).truncatedTo(ChronoUnit.DAYS);
        return (int) now.until(tommorow, ChronoUnit.SECONDS);
    }
	 */
	
	



}

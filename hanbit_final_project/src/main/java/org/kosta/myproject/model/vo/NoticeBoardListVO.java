package org.kosta.myproject.model.vo;

import java.util.List;

import org.kosta.myproject.model.service.PagingBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 알림 게시판 리스트 & 페이징 클래스 

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeBoardListVO {
	private List<NoticeBoardVO> list;
	private PagingBean pagingBean;
}

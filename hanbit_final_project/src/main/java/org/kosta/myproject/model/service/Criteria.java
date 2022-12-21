package org.kosta.myproject.model.service;

import lombok.Data;

// 페이징 처리를 위해서 필요한 파라미터를 생성해준다
// 생성자를 통해 기본값을 지정해준다

@Data
public class Criteria {
	private int pageNum;
	private int amount;
	
	public Criteria( ) {
		this(1, 10);
	}
	
	public Criteria(int pageNum,int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}

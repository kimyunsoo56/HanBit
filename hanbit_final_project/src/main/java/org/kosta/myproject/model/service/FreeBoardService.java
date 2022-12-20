package org.kosta.myproject.model.service;

import java.util.List;

import org.kosta.myproject.model.vo.FreeBoardVO;

public interface FreeBoardService {

	void write(FreeBoardVO freeBoardVO);

	List<FreeBoardVO> findAll();

	FreeBoardVO getFreeDetail(int freeNo);

	void addHits(int freeNo);

	void freeDelete(int freeNo);

	void freeUpdate(FreeBoardVO freeBoardVO);


}

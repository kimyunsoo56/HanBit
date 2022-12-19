package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.vo.FreeBoardVO;

@Mapper
public interface FreeBoardMapper {

	void write(FreeBoardVO freeBoardVO);

	List<FreeBoardVO> findAll();

	Object getFreeDetail(int freeNo);


	

}

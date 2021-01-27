package com.spring.mvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.mvc.dto.BoardDto;

@Mapper
public interface BoardMapper {

	@Select(" SELECT BOARDNO, BOARDWRITER, BOARDTITLE, BOARDCONTENT, BOARDREGDATE FROM BOARDLIST ")
	public List<BoardDto> selectList();
	
	@Insert(" INSERT INTO BOARDLIST(BOARDWRITER, BOARDTITLE, BOARDCONTENT, BOARDREGDATE) VALUES(#{boardwriter}, #{boardtitle}, #{boardcontent}, NOW()) ")
	public int insert(BoardDto dto);
	
}

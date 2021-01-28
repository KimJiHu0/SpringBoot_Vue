package com.spring.mvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.mvc.dto.BoardDto;

@Mapper
public interface BoardMapper {

	@Select(" SELECT BOARDNO, BOARDWRITER, BOARDTITLE, BOARDCONTENT, BOARDREGDATE FROM BOARDLIST ")
	public List<BoardDto> selectList();
	
	@Insert(" INSERT INTO BOARDLIST(BOARDWRITER, BOARDTITLE, BOARDCONTENT, BOARDREGDATE) VALUES(#{boardwriter}, #{boardtitle}, #{boardcontent}, NOW()) ")
	public int insert(BoardDto dto);
	
	@Select(" SELECT BOARDNO, BOARDWRITER, BOARDTITLE, BOARDCONTENT, BOARDREGDATE FROM BOARDLIST WHERE BOARDNO = #{boardno} ")
	public BoardDto selectOne(int boardno);
	
	@Update(" UPDATE BOARDLIST SET BOARDWRITER = #{boardwriter}, BOARDTITLE = #{boardtitle}, BOARDCONTENT = #{boardcontent} WHERE BOARDNO = #{boardno} ")
	public int updateData(BoardDto dto);
	
	@Delete(" DELETE FROM BOARDLIST WHERE BOARDNO = #{boardno} ")
	public int deleteData(int boardno);
	
}

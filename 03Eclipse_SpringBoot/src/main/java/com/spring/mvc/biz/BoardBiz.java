package com.spring.mvc.biz;

import java.util.List;

import com.spring.mvc.dto.BoardDto;

public interface BoardBiz {
	
	public List<BoardDto> selectList();
	
	public int insert(BoardDto dto);
	
	public BoardDto selectOne(int boardno);
	
	public int updateData(BoardDto dto);
	
	public int deleteData(int boardno);

}

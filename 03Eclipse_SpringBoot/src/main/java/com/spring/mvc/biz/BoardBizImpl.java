package com.spring.mvc.biz;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.dto.BoardDto;
import com.spring.mvc.mapper.BoardMapper;


@Service
@Transactional
public class BoardBizImpl implements BoardBiz {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardDto> selectList() {
		return mapper.selectList();
	}

	@Override
	public int insert(BoardDto dto) {
		return mapper.insert(dto);
	}

	@Override
	public BoardDto selectOne(int boardno) {
		// TODO Auto-generated method stub
		return mapper.selectOne(boardno);
	}

	@Override
	public int updateData(BoardDto dto) {
		// TODO Auto-generated method stub
		return mapper.updateData(dto);
	}

	@Override
	public int deleteData(int boardno) {
		// TODO Auto-generated method stub
		return mapper.deleteData(boardno);
	}

}

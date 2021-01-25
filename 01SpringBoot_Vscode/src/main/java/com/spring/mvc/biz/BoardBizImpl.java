package com.spring.mvc.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dto.BoardDto;
import com.spring.mvc.mapper.BoardMapper;
@Service
public class BoardBizImpl implements BoardBiz {

	@Autowired(required = true)
	private BoardMapper mapper;
	
	@Override
	public List<BoardDto> selectList() {
		return mapper.selectList();
	}

}

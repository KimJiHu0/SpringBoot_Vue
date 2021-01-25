package com.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.biz.BoardBiz;
import com.spring.mvc.dto.BoardDto;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private BoardBiz boardbiz;

	
	@GetMapping("/getData")
	@ResponseBody
	// http://localhost:8081 에서도 접근을 허용했기 떄문에
	// Boot에서도 접근을 허용하게 만들어주도록 합니다.
	@CrossOrigin("http://localhost:8081")
	public List<BoardDto> boardList() {
		return boardbiz.selectList();
	}
	
}

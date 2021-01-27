package com.spring.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.mvc.biz.BoardBiz;
import com.spring.mvc.dto.BoardDto;

// http://localhost:8081 에서도 접근을 허용했기 떄문에
// Boot에서도 접근을 허용하게 만들어주도록 합니다.
@CrossOrigin("http://localhost:8081")
@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private BoardBiz boardbiz;

	
	@GetMapping("/getData")
	@ResponseBody
	public List<BoardDto> boardList() {
		System.out.println("List");
		return boardbiz.selectList();
	}
	
	@GetMapping("/insertData")
	@ResponseBody
	public Map<Object, Object> insertData(BoardDto dto) {
		System.out.println("Insert");
		Map<Object, Object> result = new HashMap<Object, Object>();
		if(dto.getBoardwriter() == "" || dto.getBoardtitle() == "" || dto.getBoardcontent() == "") {
			result.put("check", false);
			return result;
		} else {
			result.put("check", true);
			boardbiz.insert(dto);
			return result;
		}
		
	}
	
	
}

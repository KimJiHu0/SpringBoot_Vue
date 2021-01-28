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
	
	// Vue에서 insert를 하면 해당 메소드로 들어오게 됩니다.
	@GetMapping("/insertData")
	@ResponseBody
	public Map<Object, Object> insertData(BoardDto dto) {
		System.out.println("Insert");
		// check라는 이름으로 true인지 false인지 담아주기 위한 result Map 객체를 선언하고,
		Map<Object, Object> result = new HashMap<Object, Object>();
		// 만일 작성자, 제목, 내용 중 하나라도 빈칸이라면 false를 return합니다.
		if(dto.getBoardwriter() == "" || dto.getBoardtitle() == "" || dto.getBoardcontent() == "") {
			result.put("check", false);
			return result;
		} else {
			// 그렇지 않다면 true를 return합니다.
			result.put("check", true);
			boardbiz.insert(dto);
			return result;
		}
		
	}
	
	// Vue에서 상세보기를 클릭했을 떄 비동기통신을 진행하여
	// 해당 메소드와 연결됩니다.
	@GetMapping("/detailData")
	@ResponseBody
	public Map<Object, Object> detailData(int boardno) {
		System.out.println("Detail");
		System.out.println("boardno : " + boardno);
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		BoardDto dto = boardbiz.selectOne(boardno);
		
		result.put("boardno", dto.getBoardno());
		result.put("boardwriter", dto.getBoardwriter());
		result.put("boardtitle", dto.getBoardtitle());
		result.put("boardcontent", dto.getBoardcontent());
		result.put("boardregdate", dto.getBoardregdate());
	
		System.out.println("result : " + result);
		
		return result;
	}
	
	@GetMapping("/updateData")
	@ResponseBody
	public Map<Object, Object>  updataData(BoardDto dto) {
		System.out.println("Update");
		
		System.out.println("boardwriter : " + dto.getBoardwriter());
		System.out.println("boardtitle : " + dto.getBoardtitle());
		System.out.println("boardcontent : " + dto.getBoardcontent());
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		int res = boardbiz.updateData(dto);
		if(res > 0) {
			result.put("check", true);
			System.out.println("성공");
			return result;
		} else {
			result.put("check", false);
			System.out.println("실패");
			return result;
		}
	}
	
	@GetMapping("/deleteData")
	@ResponseBody
	public Map<Object, Object>  deleteData(int boardno) {
		System.out.println("Delete");
		
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		int res = boardbiz.deleteData(boardno);
		if(res > 0) {
			result.put("check", true);
			System.out.println("성공");
			return result;
		} else {
			result.put("check", false);
			System.out.println("실패");
			return result;
		}
	}
	
}

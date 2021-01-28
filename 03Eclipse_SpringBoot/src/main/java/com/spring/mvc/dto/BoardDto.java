package com.spring.mvc.dto;

import java.util.Date;

public class BoardDto {
	
	private int boardno;
	private String boardwriter;
	private String boardtitle;
	private String boardcontent;
	private Date boardregdate;
	
	public BoardDto() {
		super();
	}
	public BoardDto(int boardno, String boardwriter, String boardtitle, String boardcontent, Date boardregdate) {
		super();
		this.boardno = boardno;
		this.boardwriter = boardwriter;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.boardregdate = boardregdate;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getBoardwriter() {
		return boardwriter;
	}
	public void setBoardwriter(String boardwriter) {
		this.boardwriter = boardwriter;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public String getBoardcontent() {
		return boardcontent;
	}
	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}
	public Date getBoardregdate() {
		return boardregdate;
	}
	public void setBoardregdate(Date boardregdate) {
		this.boardregdate = boardregdate;
	}
}

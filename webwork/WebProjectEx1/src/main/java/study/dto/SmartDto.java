package study.dto;

import java.security.Timestamp;

public class SmartDto {
	private int num;
	private String writer;
	private String subject;
	private String content;
	private int readcount;
	private int likes;
	private Timestamp writeday;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
	

}

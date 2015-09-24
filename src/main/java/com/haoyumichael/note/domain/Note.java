package com.haoyumichael.note.domain;

import java.util.Date;

import javax.ws.rs.FormParam;

public class Note {

	int id;

	@FormParam("subject")
	String subject;
	
	@FormParam("content")
	String content;
	
	@FormParam("type")
	String type;
	
	@FormParam("mainType")
	String mainType;
	
	Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMainType() {
		return mainType;
	}
	public void setMainType(String mainType) {
		this.mainType = mainType;
	}
	
}

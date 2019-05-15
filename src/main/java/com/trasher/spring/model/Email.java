package com.trasher.spring.model;

public class Email {
	private String reciever;
	private String subject;
	private String body;
	
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String content) {
		this.body = content;
	}
}

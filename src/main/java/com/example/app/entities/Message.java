package com.example.app.entities;

public class Message {
	
	String content; 
	String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Message(String content, String username) {
		this.content = content;
		this.username = username;
	}

}

package com.example.app.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	public List<String> getFollowedUsers() {
		return followedUsers;
	}

	public void setFollowedUsers(List<String> followedUsers) {
		this.followedUsers = followedUsers;
	}

	String username;
	
	List<String> followedUsers = new ArrayList<>();
	
	public String getUsername() {
		return username;
	}

	public User() {
		this.username = "";
	
	}
	
	public User(String username) {
		this.username = username;
	}

}

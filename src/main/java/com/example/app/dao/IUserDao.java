package com.example.app.dao;

import java.util.List;
import java.util.Set;

import com.example.app.entities.User;

public interface IUserDao {
	
	void addUserIfNew(String username);
	
	List<String> getFollowedUsers(String username);
	
	void addFollowedUser(String user, String followedUser);
	
	Set<User> getUserList();
	
	User getUser(String username);
}

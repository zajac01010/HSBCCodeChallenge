package com.example.app.services;

import java.util.List;
import java.util.Set;

import com.example.app.entities.User;

public interface IUserService {
	
	void addUserIfNew(String username);
	
	void addFollowedUser(String user, String followedUser);
	
	List<String> getFollowedUsers(String username);
	
	List<User> getUserList();
}

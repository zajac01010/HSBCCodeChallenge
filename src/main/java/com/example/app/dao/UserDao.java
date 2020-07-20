package com.example.app.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.app.entities.User;

@Repository
public class UserDao implements IUserDao{
	
	Set<User> users = new HashSet<>();
	
	List<User> users2 = new ArrayList<>();
	
	@Override
	public void addUserIfNew(String username) {
		if(!users.contains(username)) {
		users.add(new User(username));
		}
	}
	
	public void addFollowedUser(String user, String followedUser) {
		User usr = users.stream().filter(us -> us.getUsername().equals(user)).findFirst().get();
		List<String> followedUsers = usr.getFollowedUsers();
		followedUsers.add(followedUser);
	}

	public List<String> getFollowedUsers(String username) {
		User usr = users.stream().filter(us -> us.getUsername().equals(username)).findFirst().get();
		return usr.getFollowedUsers();
	}

	@Override
	public Set<User> getUserList() {
		return users;
	}
	
	public User getUser(String username) {
		return users.stream().filter(us -> us.getUsername().equals(username)).findFirst().get();
	}
}

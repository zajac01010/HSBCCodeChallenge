package com.example.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.UserDao;
import com.example.app.entities.User;

@Service
public class UserService implements IUserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public void addUserIfNew(String username) {
		userDao.addUserIfNew(username);
	}
	
	public void addFollowedUser(String user, String followedUser) {
		userDao.addFollowedUser(user, followedUser);
	}

	@Override
	public List<String> getFollowedUsers(String username) {
		return userDao.getFollowedUsers(username);
	}

	@Override
	public List<User> getUserList() {
		return new ArrayList<>(userDao.getUserList());
	}
	
	public User getUser(String username) {
		return userDao.getUser(username);
	}
}

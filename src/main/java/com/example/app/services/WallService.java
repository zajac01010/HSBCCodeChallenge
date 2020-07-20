package com.example.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.WallDao;
import com.example.app.entities.Message;
import com.example.app.entities.User;

@Service
public class WallService implements IWallService{
	
	@Autowired
	WallDao wallDao;
	
	@Autowired
	UserService userService;

	@Override
	public void addMessageToWall(String content, String username) {
		wallDao.save(content, username);
	}
	
	@Override
	public List<Message> getWallContent() {
		return wallDao.getWallContent();
	}
	
	public List<Message> getTimeline(String username) {
		User user = userService.getUser(username);
		return wallDao.getTimeline(user);
	}

}

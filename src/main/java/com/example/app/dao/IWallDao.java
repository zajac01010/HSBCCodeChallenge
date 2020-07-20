package com.example.app.dao;

import java.util.List;
import java.util.Map;

import com.example.app.entities.Message;
import com.example.app.entities.User;

public interface IWallDao {
	
	void save(String content, String username);
	
	List<Message> getWallContent();
	
	List<Message> getTimeline(User user);
}

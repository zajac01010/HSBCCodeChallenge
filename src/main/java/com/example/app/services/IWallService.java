package com.example.app.services;

import java.util.List;

import com.example.app.entities.Message;
import com.example.app.entities.User;

public interface IWallService {
	
	void addMessageToWall(String content, String username);
	
	List<Message> getWallContent(); 
	
	List<Message> getTimeline(String username);
}

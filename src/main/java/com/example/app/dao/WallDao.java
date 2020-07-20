package com.example.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.app.entities.Message;
import com.example.app.entities.User;

@Repository
public class WallDao implements IWallDao{
			
	List<Message> wall = new ArrayList<>();
		
	@Override
	public void save(String content, String username) {
		 wall.add(new Message(username, content)); 
	}

	@Override
	public List<Message> getWallContent() {
		return wall;
	}
	
	public List<Message> getTimeline(User user) { 
		List<Message> messages = new ArrayList<>();
		for(Message message : wall) {
		for(String followedUser : user.getFollowedUsers()) 
		if(message.getUsername().equals(followedUser)) {
			messages.add(message);
		}
	}
		return messages;
	}
}

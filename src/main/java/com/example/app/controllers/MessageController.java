package com.example.app.controllers;

import static com.example.app.constants.Constants.SEND_SUCCESS;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entities.Message;
import com.example.app.entities.User;
import com.example.app.services.MessageValidationService;
import com.example.app.services.UserService;
import com.example.app.services.WallService;

@RestController
public class MessageController {
	
	@Autowired
	MessageValidationService validationService;
	
	@Autowired
	WallService wallService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/postMessage")
	public List<String> postMessage(@RequestParam(name = "content")String content, @RequestParam(name = "username")String username) {
		
		List<String> validationErrors = validationService.validate(content, username);
		if(!validationErrors.isEmpty()) {
			return validationErrors;
		} else {
			userService.addUserIfNew(username);
			wallService.addMessageToWall(username, content);
			return Collections.singletonList(SEND_SUCCESS);
		}
	}
	
	@PostMapping("/follow")
	public void follow(@RequestParam(name="user")String user, @RequestParam(name="followedUser")String followedUser) {
		userService.addFollowedUser(user, followedUser);
	}
	
	@GetMapping("/getFollowedUsers")
	public List<String> getFollowedUsers(@RequestParam(name="username")String username) {
		return userService.getFollowedUsers(username);
	}
	
	@GetMapping("/getTimeline")
	public List<Message> getTimeline(@RequestParam(name="username")String username) {
		return wallService.getTimeline(username);
	}
	
	@GetMapping("/getUserList")
	public List<User> getUserList() {
		return userService.getUserList();
	}
	
	@GetMapping("/getWallContent")
	public List<Message> getWallContent() {
		return wallService.getWallContent();
	}
	
	@GetMapping("/works")
	public String works() {
		return "Works!";
	}
}

package com.example.app.entities;

import java.util.ArrayList;
import java.util.List;

public class Wall {
	
	public List<String> getWallMessages() {
		return wallMessages;
	}

	public void setWallMessages(List<String> wallMessages) {
		this.wallMessages = wallMessages;
	}

	List<String> wallMessages = new ArrayList<String>();

}

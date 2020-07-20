package com.example.app.services;

import java.util.List;

import com.example.app.entities.Message;

 interface ValidationService {
	
	 List<String> validate(String msg, String username);

}
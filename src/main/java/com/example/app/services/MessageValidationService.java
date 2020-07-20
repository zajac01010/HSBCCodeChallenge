package com.example.app.services;

import static com.example.app.constants.Constants.MAX_LENGTH;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.entities.Message;

@Service
public class MessageValidationService implements ValidationService{
	
	List<String> validationErrors = new ArrayList<>();

	@Override
	public List<String> validate(String msg, String username) {
		if(msg.length() > MAX_LENGTH) {
			validationErrors.add("Post length exceeds 140 characters");
		} else if(msg.isEmpty()) {
			validationErrors.add("Empty content");
		}
		if(username.isEmpty()) {
			validationErrors.add("No user logged");
		}
		return validationErrors;
	}

}

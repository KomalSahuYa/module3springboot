package com.app.service;

import org.springframework.stereotype.Service;

@Service
public class DefaultMsgService implements WelcomeService{

	@Override
	public String greet(String name) {
		return "This is a Default Message";
	}
	

}

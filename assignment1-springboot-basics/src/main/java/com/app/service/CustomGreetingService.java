package com.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.app.util.NameFormatter;
import com.app.util.NameValidator;

@Service
@Primary
public class CustomGreetingService implements WelcomeService{
	private final NameFormatter nameFormatter;
	private final NameValidator nameValidator;
	
	@Value("${app.author}")
	private String author;
	
	public CustomGreetingService(NameFormatter formatter, NameValidator validator) {
		this.nameFormatter = formatter;
		this.nameValidator = validator;
	}

	public String greet(String name) {
		if (nameValidator.isValid(name)) {
			String nameFin = nameFormatter.toUpperCaseFormat(name);
			return "Welcome " + nameFin + " to Spring Boot!"+" (Author: " + author + ")";

		}
		return "Please enter a valid name";

	}
}
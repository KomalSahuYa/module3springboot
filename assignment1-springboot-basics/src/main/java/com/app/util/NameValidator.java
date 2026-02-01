package com.app.util;

import org.springframework.stereotype.Component;

@Component
public class NameValidator {
	public boolean isValid(String name) {
		if (name == null) return false;
	    if (name.trim().isEmpty()) return false;
		return true;
	}

}

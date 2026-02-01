package com.app.util;

import org.springframework.stereotype.Component;



@Component
public class NameFormatter {
	public String toUpperCaseFormat(String name) {
	    name = name.trim();

	    return name.toUpperCase();
	}

}

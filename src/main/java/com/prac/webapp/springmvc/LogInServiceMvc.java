package com.prac.webapp.springmvc;

import org.springframework.stereotype.Service;

@Service
public class LogInServiceMvc {
	public Boolean validateUser(String name, String password) {
		if (name.equalsIgnoreCase("Nilachal") && password.equals("test")) {
			return true;
		} else {
			return false;
		}
	}
}

package com.prac.webapp.jee;

public class LogInService {
	public Boolean validateUser(String name, String password) {
		if (name.equalsIgnoreCase("Nilachal") && password.equals("test")) {
			return true;
		} else {
			return false;
		}
	}
}

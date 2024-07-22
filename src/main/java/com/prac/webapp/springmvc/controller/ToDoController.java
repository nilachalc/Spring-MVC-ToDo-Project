package com.prac.webapp.springmvc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import com.prac.webapp.springmvc.service.ToDoService;

@Controller
public class ToDoController {
	private static Logger logger = Logger.getRootLogger();
	
	@Autowired
	WebApplicationContext applicationContext;
	
	@Autowired
	private ToDoService toDoService;
	
}

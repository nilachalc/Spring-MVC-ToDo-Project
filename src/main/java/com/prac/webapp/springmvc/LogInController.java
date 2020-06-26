package com.prac.webapp.springmvc;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.prac.webapp.jee.LogInService;

@Controller
public class LogInController {
	private static Logger logger = Logger.getRootLogger();
	
	@Autowired
	WebApplicationContext applicationContext;
	
	@Autowired
	private LogInServiceMvc logInServiceMvc;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String testPage() {
		String string = "Welcome To The World of Spring MVC!!! Choose proper URL to explore more!";
		System.out.println("Bean present in the Application Context --> ");
		String[] beans = applicationContext.getBeanDefinitionNames();
		for (int i = 0 ; i < applicationContext.getBeanDefinitionCount(); i++) {
			System.out.println(beans[i]);
		}
		System.out.println("Total number of beans --> " + applicationContext.getBeanDefinitionCount());
		
		return string;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String goToLogInPage() {
		BasicConfigurator.configure();
		
		logger.setLevel(Level.ERROR);
		
		logger.trace("Trace Logging");
		logger.debug("Debug Logging");
		logger.info("Info Logging");
		logger.warn("Warn Logging");
		logger.error("Error Logging");
		
		return "LogInMvc";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String welcomeUser(@RequestParam String name, @RequestParam(name = "password") String userPassword, ModelMap model) {
		Boolean userStatus = logInServiceMvc.validateUser(name, userPassword); 
		if (!userStatus) {
			model.put("ErrorMessage", "Invalid Credentials!!");
			System.out.println(userPassword);
			return "LogInMvc";
		} else {
			model.put("name", name);
			model.put("ErrorMessage", null);
		}		 
		return "WelComeMvc";
	}
}

package com.prac.webapp.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prac.webapp.springmvc.bean.ToDo;
import com.prac.webapp.springmvc.service.ToDoService;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@RequestMapping(value = "/delete-ToDo")
	public String deleteToDosForLoggedInUser(@RequestParam int toDoId, @RequestParam int loggedinUserId, ModelMap model) {
		toDoService.deleteToDosForLoggedInUser(toDoId);
		model.put("allToDos", toDoService.fetchAllToDosForLoggedInUser(loggedinUserId));
		return "WelComeToDo";
	}
	
	@RequestMapping(value = "/add-ToDo", method = RequestMethod.GET)
	public String goToAddToDoPage(ModelMap model) {
		model.addAttribute("newToDo", new ToDo());
		return "AddToDo";
	}
	
	@RequestMapping(value = "/add-ToDo", method = RequestMethod.POST)
	public String addToDosForLoggedInUser(@RequestParam int loggedinUserId, @ModelAttribute("newToDo") ToDo newToDo, ModelMap model) {
		newToDo.setMappedUserId(loggedinUserId);
		List<ToDo> toDosForLoggedInUser = toDoService.addToDosForLoggedInUser(newToDo);
		model.put("allToDos", toDosForLoggedInUser);
		return "WelComeToDo";
	}
}

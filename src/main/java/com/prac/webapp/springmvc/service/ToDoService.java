package com.prac.webapp.springmvc.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prac.webapp.springmvc.bean.ToDo;

@Service
public class ToDoService {
	static List<ToDo> toDos;
	static {
		ToDoService.toDos = Arrays.asList(new ToDo(1, "TestTodoDes1", LocalDate.now())
										,new ToDo(2, "TestTodoDes2", LocalDate.now())
										,new ToDo(3, "TestTodoDes3", LocalDate.now()));
	}
	
	public List<ToDo> fetchAllToDos() {
		return ToDoService.toDos;
	}
}

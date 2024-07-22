package com.prac.webapp.springmvc.bean;

import java.time.LocalDate;

public class ToDo {
	private Integer toDoId;
	private String description;
	private LocalDate targetDate;
	
	public Integer getToDoId() {
		return toDoId;
	}
	public void setToDoId(Integer toDoId) {
		this.toDoId = toDoId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	
	public ToDo(Integer toDoId, String description, LocalDate targetDate) {
		super();
		this.toDoId = toDoId;
		this.description = description;
		this.targetDate = targetDate;
	}
	
	@Override
	public String toString() {
		return "ToDo [toDoId=" + toDoId + ", description=" + description + ", targetDate=" + targetDate + "]";
	}
}

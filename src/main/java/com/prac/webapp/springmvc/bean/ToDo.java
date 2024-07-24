package com.prac.webapp.springmvc.bean;

import org.springframework.stereotype.Component;

@Component
public class ToDo {
	private Integer toDoId;
	private Integer toDoSerialNumber;
	private String description;
	private String targetDate;
	private boolean isCompleted;
	private Integer mappedUserId;
	
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
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public boolean getIsCompleted() {
		return isCompleted;
	}
	public Integer getToDoSerialNumber() {
		return toDoSerialNumber;
	}
	public void setToDoSerialNumber(Integer toDoSerialNumber) {
		this.toDoSerialNumber = toDoSerialNumber;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public Integer getMappedUserId() {
		return mappedUserId;
	}
	public void setMappedUserId(Integer mappedUserId) {
		this.mappedUserId = mappedUserId;
	}
	@Override
	public String toString() {
		return "ToDo [toDoId=" + toDoId + ", toDoSerialNumber=" + toDoSerialNumber + ", description=" + description
				+ ", targetDate=" + targetDate + ", isCompleted=" + isCompleted + ", mappedUserId=" + mappedUserId
				+ "]";
	}
}

package com.todo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int toDoId;
	private String toDoTaskHead;
	private String toDoTaskBody;
	/**
	 * @param toDoId
	 * @param toDoTaskHead
	 * @param toDoTaskBody
	 */
	public ToDo(int toDoId, String toDoTaskHead, String toDoTaskBody) {
		super();
		this.toDoId = toDoId;
		this.toDoTaskHead = toDoTaskHead;
		this.toDoTaskBody = toDoTaskBody;
	}
	/**
	 * 
	 */
	public ToDo() {
		super();
	}
	/**
	 * @return the toDoId
	 */
	public int getToDoId() {
		return toDoId;
	}
	/**
	 * @param toDoId the toDoId to set
	 */
	public void setToDoId(int toDoId) {
		this.toDoId = toDoId;
	}
	/**
	 * @return the toDoTaskHead
	 */
	public String getToDoTaskHead() {
		return toDoTaskHead;
	}
	/**
	 * @param toDoTaskHead the toDoTaskHead to set
	 */
	public void setToDoTaskHead(String toDoTaskHead) {
		this.toDoTaskHead = toDoTaskHead;
	}
	/**
	 * @return the toDoTaskBody
	 */
	public String getToDoTaskBody() {
		return toDoTaskBody;
	}
	/**
	 * @param toDoTaskBody the toDoTaskBody to set
	 */
	public void setToDoTaskBody(String toDoTaskBody) {
		this.toDoTaskBody = toDoTaskBody;
	}
	@Override
	public String toString() {
		return "ToDo [toDoId=" + toDoId + ", toDoTaskHead=" + toDoTaskHead + ", toDoTaskBody=" + toDoTaskBody + "]";
	}
}

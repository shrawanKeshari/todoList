package com.api.todoList.beans;

public class TodoList {
	private int id;
	private String todo_title;
	private String created_time;
	private String updated_time;
	private String isMarked;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodo_title() {
		return todo_title;
	}

	public void setTodo_title(String todo_title) {
		this.todo_title = todo_title;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public String getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}

	public String getIsMarked() {
		return isMarked;
	}

	public void setIsMarked(String isMarked) {
		this.isMarked = isMarked;
	}

}

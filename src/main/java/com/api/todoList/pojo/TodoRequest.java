package com.api.todoList.pojo;

public class TodoRequest {
	private Request request;

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public static class Request {
		private String todo_title;

		public String getTodo_title() {
			return todo_title;
		}

		public void setTodo_title(String todo_title) {
			this.todo_title = todo_title;
		}

	}
}

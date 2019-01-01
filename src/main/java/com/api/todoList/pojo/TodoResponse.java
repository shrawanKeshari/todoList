package com.api.todoList.pojo;

public class TodoResponse {
	private String status;
	private String code;
	private String responseMessage;
	private Response response;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public static class Response {

		private String todo_title;
		private String created_time;
		private String updated_time;
		private String isMarked;

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
}

package com.api.todoList.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.todoList.beans.TodoList;
import com.api.todoList.dao.TodoListDao;
import com.api.todoList.pojo.TodoResponse;
import com.api.todoList.pojo.TodoResponse.Response;

@Controller
@RequestMapping(value = "/")
public class TodoListController {

	@Autowired
	TodoListDao todoListDao;

	private static final String SUCCESS_STATUS = "SUCCESS";
	private static final String SUCCESS_CODE = "SUCCESS";
	private static final String FAILURE_STATUS = "FAILURE";
	private static final String FAILURE_CODE = "FAILURE";

	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public @ResponseBody TodoResponse addItem(@RequestParam(value = "todo_title", required = false) String todo_title) {
		TodoResponse todoResponse = new TodoResponse();

		Response response = new Response();

		if (todo_title == null) {
			todoResponse.setStatus(FAILURE_STATUS);
			todoResponse.setCode(FAILURE_CODE);
			todoResponse.setResponseMessage("Enter todo title is not valid");

			return todoResponse;
		}

		todo_title = todo_title.replaceAll("^\"|\"$", "");

		if (todo_title.length() == 0 || todo_title.equals(" ")) {
			todoResponse.setStatus(FAILURE_STATUS);
			todoResponse.setCode(FAILURE_CODE);
			todoResponse.setResponseMessage("Enter todo title is not valid");
		} else {

			try {

				TodoList todoList = new TodoList();
				todoList.setTodo_title(todo_title);

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date date = new java.util.Date();

				todoList.setCreated_time(dateFormat.format(date).toString());
				todoList.setUpdated_time(dateFormat.format(date).toString());
				todoList.setIsMarked("false");

				todoListDao.insertData(todoList);

				response.setTodo_title(todo_title);
				response.setCreated_time(todoList.getCreated_time());
				response.setIsMarked(todoList.getIsMarked());
				todoResponse.setStatus(SUCCESS_STATUS);
				todoResponse.setCode(SUCCESS_CODE);
				todoResponse.setResponseMessage("data inserted successfully into todo list");

				todoResponse.setResponse(response);
			} catch (Exception e) {
				todoResponse.setStatus(FAILURE_STATUS);
				todoResponse.setCode(FAILURE_CODE);
				todoResponse.setResponseMessage(e.getMessage());
			}
		}

		return todoResponse;
	}

	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public @ResponseBody TodoResponse deleteItem(
			@RequestParam(value = "todo_title", required = false) String todo_title) {
		TodoResponse todoResponse = new TodoResponse();

		if (todo_title == null) {
			todoResponse.setStatus(FAILURE_STATUS);
			todoResponse.setCode(FAILURE_CODE);
			todoResponse.setResponseMessage("Enter todo title is not valid");

			return todoResponse;
		}

		todo_title = todo_title.replaceAll("^\"|\"$", "");

		if (todo_title.length() == 0 || todo_title.equals(" ")) {
			todoResponse.setStatus(FAILURE_STATUS);
			todoResponse.setCode(FAILURE_CODE);
			todoResponse.setResponseMessage("Enter todo title is not valid");
		} else {

			try {

				todoListDao.delete(todo_title);

				todoResponse.setStatus(SUCCESS_STATUS);
				todoResponse.setCode(SUCCESS_CODE);
				todoResponse.setResponseMessage("data deleted successfully into todo list");
			} catch (Exception e) {
				todoResponse.setStatus(FAILURE_STATUS);
				todoResponse.setCode(FAILURE_CODE);
				todoResponse.setResponseMessage(e.getMessage());
			}
		}

		return todoResponse;
	}

	@RequestMapping(value = "/markedItem", method = RequestMethod.GET)
	public @ResponseBody TodoResponse markedItem(
			@RequestParam(value = "todo_title", required = false) String todo_title,
			@RequestParam(value = "marked_value", required = false) String marked_value) {
		TodoResponse todoResponse = new TodoResponse();

		Response response = new Response();

		if (todo_title == null) {
			todoResponse.setStatus(FAILURE_STATUS);
			todoResponse.setCode(FAILURE_CODE);
			todoResponse.setResponseMessage("Enter todo title is not valid");

			return todoResponse;
		}

		todo_title = todo_title.replaceAll("^\"|\"$", "");

		if (todo_title.length() == 0 || todo_title.equals(" ")) {
			todoResponse.setStatus(FAILURE_STATUS);
			todoResponse.setCode(FAILURE_CODE);
			todoResponse.setResponseMessage("Enter todo title is not valid");
		} else {

			try {
				
				if(marked_value == null || marked_value.equals(" ") || marked_value.length() == 0) {
					marked_value = "false";
				}
				
				TodoList todoList = new TodoList();
				todoList.setTodo_title(todo_title);
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date date = new java.util.Date();

				todoList.setUpdated_time(dateFormat.format(date).toString());
				todoList.setIsMarked(marked_value);

				todoListDao.updateData(todoList);
				
				todoList = todoListDao.getItemByTitle(todo_title);
				
				response.setTodo_title(todo_title);
				response.setCreated_time(todoList.getCreated_time());
				response.setUpdated_time(todoList.getUpdated_time());
				response.setIsMarked(todoList.getIsMarked());
				todoResponse.setStatus(SUCCESS_STATUS);
				todoResponse.setCode(SUCCESS_CODE);
				todoResponse.setResponseMessage("data updated successfully into todo list");

				todoResponse.setResponse(response);
			} catch (Exception e) {
				todoResponse.setStatus(FAILURE_STATUS);
				todoResponse.setCode(FAILURE_CODE);
				todoResponse.setResponseMessage(e.getMessage());
			}
		}

		return todoResponse;
	}
}

package com.api.todoList.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.api.todoList.beans.TodoList;

public class TodoListDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insertData(TodoList todoList) {
		String sql = "insert into todoList (todo_title,created_time,isMarked,updated_time) values ('"
				+ todoList.getTodo_title() + "','" + todoList.getCreated_time() + "','" + todoList.getIsMarked() + "','"
				+ todoList.getUpdated_time() + "')";

		return template.update(sql);
	}

	public int updateData(TodoList todoList) {
		String sql = "update todoList set isMarked='" + todoList.getIsMarked() + "',updated_time='"
				+ todoList.getUpdated_time() + "' where todo_title='" + todoList.getTodo_title() + "'";
		return template.update(sql);
	}

	public int delete(String todo_title) {
		String sql = "delete from todoList where todo_title='" + todo_title + "'";
		return template.update(sql);
	}
	
	public TodoList getItemByTitle(String todo_title) {
		String sql = "select * from todoList where todo_title=?";
		return template.queryForObject(sql, new Object[] { todo_title },
				new BeanPropertyRowMapper<TodoList>(TodoList.class));
	}
}

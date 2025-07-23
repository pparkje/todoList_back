package com.java.main.todoList.dao;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoListDao {
	private String writer;
	private List<TodoData> data;
	
	@Getter
	@Setter
	@ToString
	public static class TodoData{
		private String no;
		private String todo;
		private String state;
		private String writeDate;
	}

}

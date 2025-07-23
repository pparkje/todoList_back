package com.java.main.todoList.controller;

import java.io.File;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.java.main.todoList.dao.TodoListDao;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		
		System.out.println("ppark test 1");
		
		return "Hello ppark";
	}
	
	@RequestMapping("/todoList")
	public String todoList(@RequestBody Map<String, String> todoChk) {
		
		
		System.out.println("ppark test 1 : " + todoChk);
		
		String plusBack = todoChk.get("todoChk");
		plusBack += " 박재현 ]";
		
//		System.out.println("ppark test 12 : " + plusBack);
		
		return plusBack;
	}
	
	@RequestMapping("/saveTodoList")
	public String saveTodoList(@RequestBody TodoListDao todoList) throws Exception {
		
		try {
			System.out.println("ppark test 11 : " + todoList.getWriter());
			System.out.println("ppark test 12 : " + todoList.getData().get(0).getNo());
			System.out.println("ppark test 12 : " + todoList.getData().get(0).getState());
			
			// 추후 path처리 수정 필요
			String path = "C:\\app\\STS\\workspace\\frontend\\public\\todoListData.txt";
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			
			for(int i = 0; i < todoList.getData().size(); i++) {
				todoList.getData().get(i).setNo(String.valueOf(i + 1));
			}
			
			mapper.writeValue(new File(path), todoList);
			
			String testCheck = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(todoList);
//			System.out.println("ppark check : " + testCheck);
			
			return "test";
//			String plusBack = todoChk.get("todoChk");
//			plusBack += " 박재현 ]";
		}catch (Exception e) {
			return "오류발생 ppark 비상!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! : " + e.getMessage(); 
		}
	}
}

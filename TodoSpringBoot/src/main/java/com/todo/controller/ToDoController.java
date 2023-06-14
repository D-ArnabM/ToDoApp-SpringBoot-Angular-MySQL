package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entities.ToDo;
import com.todo.services.ToDoServices;

@RestController
@CrossOrigin
@RequestMapping("api/v1/todo")
public class ToDoController {
	
	@Autowired
	private ToDoServices services;
	
	@PostMapping("/saveToDo")
	public ToDo saveToDo(@RequestBody ToDo toDo){
		return services.saveToDo(toDo);
	}
	
	@GetMapping("/fetchToDoById/{id}")
	public ToDo fetchToDoById(@PathVariable(name = "id") int id) {
		return services.getToDoById(id);
	}
	
	@GetMapping("/fetchAllToDo")
	public List<ToDo> fetchAllToDo(){
		return services.getAllToDo();
	}
	
	@PutMapping("/update")
	public ToDo update(@RequestBody ToDo toDo){
		return services.updateToDo(toDo);
	}
	
	@DeleteMapping("/delete/{id}")
	public int delete(@PathVariable(name = "id") int id) {
		return services.deleteToDo(id);
	}
}

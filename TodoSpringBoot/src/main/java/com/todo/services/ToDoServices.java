package com.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entities.ToDo;
import com.todo.repos.ToDoRepository;

@Service
public class ToDoServices {

	@Autowired
	private ToDoRepository toDoRepository;

	public ToDo saveToDo(ToDo toDo) {
		return toDoRepository.save(toDo);
	}

	public ToDo getToDoById(int id) {
		if (toDoRepository.findById(id).get() != null) {
			return toDoRepository.findById(id).get();
		}
		return null;
	}

	public List<ToDo> getAllToDo() {
		return toDoRepository.findAll();
	}

	public ToDo updateToDo(ToDo toDo) {
		return toDoRepository.save(toDo);
	}

	public int deleteToDo(int id) {
		if (toDoRepository.findById(id).get() != null) {
			toDoRepository.deleteById(id);
			return id;
		}
		return -1;
	}

}

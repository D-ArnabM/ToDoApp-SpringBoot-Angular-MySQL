package com.todo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entities.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{

}

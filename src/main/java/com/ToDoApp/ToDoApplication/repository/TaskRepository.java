package com.ToDoApp.ToDoApplication.repository;


import com.ToDoApp.ToDoApplication.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

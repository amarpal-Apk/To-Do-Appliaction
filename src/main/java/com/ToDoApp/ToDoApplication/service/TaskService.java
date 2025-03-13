package com.ToDoApp.ToDoApplication.service;

import com.ToDoApp.ToDoApplication.entity.*;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    public void addTask(String title);

    public void updateTask(Task newTask );

    public Void deleteTask(Long id);

    public List<Task> getAllTasks();

    Optional<Task> findById(Long id);
    void toggleTask(Long id);

}

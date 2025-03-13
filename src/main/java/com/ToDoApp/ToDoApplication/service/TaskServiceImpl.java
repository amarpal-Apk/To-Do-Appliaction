package com.ToDoApp.ToDoApplication.service;


import com.ToDoApp.ToDoApplication.entity.Task;
import com.ToDoApp.ToDoApplication.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    //    @Autowired
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Task newTask) {
//        Optional<Task> task = taskRepository.findById(id);
//        Task task1 = task.get();
//        task1.setTitle(newTask.getTitle());
//        task1.setId(id);
        taskRepository.save(newTask);
    }

    @Override
    public Void deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        } else {
            throw new RuntimeException("Task not found");
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void toggleTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task task1 = task.get();
            task1.setCompleted(!task1.isCompleted());
            taskRepository.save(task1);
        }

    }

}




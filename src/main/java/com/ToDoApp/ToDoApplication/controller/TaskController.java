package com.ToDoApp.ToDoApplication.controller;


import com.ToDoApp.ToDoApplication.entity.Task;
import com.ToDoApp.ToDoApplication.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getLists(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/add")
    public String createTask(@RequestParam String title) {
        taskService.addTask(title);
        return "redirect:/tasks";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/edit-task/{id}")
    public String showTaskForm(@PathVariable Long id, Model model) {
        Optional<Task> task = taskService.findById(id);
        Task task1 = task.get();
        model.addAttribute("task", task1);
        return "edit-task";
    }


    @PostMapping("/update")
    public String updateTask(@ModelAttribute Task task) {
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/toggle/{id}")
    public String toggle(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/amar")
    public String toggle() {
        return "toggle";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}




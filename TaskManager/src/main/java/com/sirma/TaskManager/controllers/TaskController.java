package com.sirma.TaskManager.controllers;

import com.sirma.TaskManager.models.Task;
import com.sirma.TaskManager.repositories.TaskRepository;
import com.sirma.TaskManager.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    //GET ALL TASKS
    @GetMapping
    public Iterable<Task> getAllTasks() {
        return this.taskService.findAllTasks();
    }

    //GET TASK BY ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id)
    {
        return this.taskService.findTaskById(id);
    }

    //CREATE TASK
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return this.taskService.createTask(task);
    }

    //UPDATE TASK
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task)
    {
        return this.taskService.updateTask(id, task);
    }

    //DELETE TASK
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id)
    {
        this.taskService.deleteTaskById(id);
    }
}

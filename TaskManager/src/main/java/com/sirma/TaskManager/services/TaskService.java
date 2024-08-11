package com.sirma.TaskManager.services;

import com.sirma.TaskManager.models.Task;
import com.sirma.TaskManager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    public Iterable<Task> findAllTasks()
    {
        return this.taskRepository.findAll();
    }

    public Task findTaskById(Long taskId)
    {
        return this.taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task with id " + taskId +
            " not found."));
    }

    public Task createTask(Task task)
    {
        return this.taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task task)
    {
        Task t = this.taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task with id " + taskId +
                " not found."));
        t.setTitle(task.getTitle());
        t.setDescription(task.getDescription());
        t.setStatus(task.getStatus());
        t.setDueDate(task.getDueDate());
        return this.taskRepository.save(t);
    }

    public void deleteTaskById(Long taskId)
    {
        this.taskRepository.deleteById(taskId);
    }

    public void deleteTask(Task task)
    {
        this.taskRepository.delete(task);
    }
}

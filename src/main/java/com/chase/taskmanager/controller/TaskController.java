package com.chase.taskmanager.controller;

import com.chase.taskmanager.model.Task;
import com.chase.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get all tasks
    @GetMapping()
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }
    
    // Get task by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.findTaskById(id);
        return task.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // Create a task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }
    
    // Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.deleteTaskById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Find the task by status
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return taskService.findByStatus(status);
    }
    
    // Find task by user
    @GetMapping("/user/{user}")
    public List<Task> getTasksByUser(@PathVariable String user) {
    	return taskService.findByUser(user);
    }
    
    // Update a task
    // TODO: User should be able to update just parts of a task and not all of it.
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Optional<Task> task = taskService.findTaskById(id);
        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setStatus(updatedTask.getStatus());
            existingTask.setTitle(updatedTask.getTitle());
            Task savedTask = taskService.save(existingTask);
            return ResponseEntity.ok(savedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
package com.chase.taskmanager.service;

import com.chase.taskmanager.model.Task;
import com.chase.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	public Task save(Task task) {
		return taskRepository.save(task);
	}
	
	public List<Task> findByStatus(String status) {
		return taskRepository.findByStatus(status);
	}

	public Optional<Task> findTaskById(Long id) {
		return taskRepository.findById(id);
	}
	
	public boolean deleteTaskById(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

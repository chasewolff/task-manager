package com.chase.taskmanager.repository;

import com.chase.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByStatus(String status);
}

package com.chase.taskmanager.repository;

import com.chase.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByStatus(String status);
	List<Task> findByUser(String user);
	Optional<Task> findById(Long id);
}

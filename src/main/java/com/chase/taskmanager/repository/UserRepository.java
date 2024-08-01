package com.chase.taskmanager.repository;

import com.chase.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}

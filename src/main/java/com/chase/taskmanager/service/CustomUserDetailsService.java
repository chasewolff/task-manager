package com.chase.taskmanager.service;

import com.chase.taskmanager.model.User;
import com.chase.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class.getName());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Loading user by username: " + username);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            logger.warning("User not found with username: " + username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        logger.info("User found: " + username);
        return user;
    }
}

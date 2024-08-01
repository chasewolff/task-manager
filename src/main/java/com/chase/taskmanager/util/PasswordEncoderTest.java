package com.chase.taskmanager.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


// This file is meant to be run alone so that I can check if my passwords are encoding correctly. It prints me the correct password to use. 
public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }
}

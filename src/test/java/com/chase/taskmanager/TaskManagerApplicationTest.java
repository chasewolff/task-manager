package com.chase.taskmanager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.chase.taskmanager")
class TaskManagerApplicationTest {

    @Test
    void contextLoads() {
    }
}

package com.chase.taskmanager.repository;

import com.chase.taskmanager.model.Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testSaveAndFindTask() {
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("This is a test task");
        task.setStatus("PENDING");
        task.setDueDate(new Date());

        taskRepository.save(task);

        List<Task> tasks = taskRepository.findAll();
        Assertions.assertFalse(tasks.isEmpty());
        Assertions.assertEquals("Test Task", tasks.get(0).getTitle());
    }
}

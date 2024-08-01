package com.chase.taskmanager.service;

import com.chase.taskmanager.model.Task;
import com.chase.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    public TaskServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllTasks() {
        Task task1 = new Task();
        task1.setTitle("Task 1");
        task1.setDescription("Description 1");
        task1.setStatus("PENDING");
        task1.setDueDate(new Date());

        Task task2 = new Task();
        task2.setTitle("Task 2");
        task2.setDescription("Description 2");
        task2.setStatus("COMPLETED");
        task2.setDueDate(new Date());

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        List<Task> tasks = taskService.findAll();
        Assertions.assertEquals(2, tasks.size());
        Assertions.assertEquals("Task 1", tasks.get(0).getTitle());
    }
}

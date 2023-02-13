package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DbServiceTest {

    @Mock
    private TaskRepository taskRepository;
    @InjectMocks
    private DbService dbService;

    @Test
    void shouldFetchEmptyList() {
        //Given
        when(taskRepository.findAll()).thenReturn(List.of());

        //When
        List<Task> retrievedTaskList = dbService.getAllTasks();
        //Then
        assertNotNull(retrievedTaskList);
        assertEquals(0, retrievedTaskList.size());
    }
}
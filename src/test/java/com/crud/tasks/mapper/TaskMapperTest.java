package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(12L, "title", "content");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals("title", task.getTitle());
        assertEquals("content", task.getContent());
        assertEquals(12L, task.getId());
    }

    @Test
    void testMapToTaskDto() {
        //Given
        Task task = new Task(12L, "title", "content");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals("title", taskDto.getTitle());
        assertEquals("content", taskDto.getContent());
        assertEquals(12L, taskDto.getId());
    }

    @Test
    void testMapToTaskDtoList() {
        //Given
        Task task = new Task(12L, "title", "content");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(1, taskDtoList.size());
        assertEquals("title", taskDtoList.get(0).getTitle());
        assertEquals("content", taskDtoList.get(0).getContent());
        assertEquals(12L, taskDtoList.get(0).getId());
    }

}
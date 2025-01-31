package com.mono.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mono.dto.TaskDto;
import com.mono.mapper.TaskMapper;
import com.mono.models.Task;
import com.mono.repository.TaskRepository;

@Service
public class TaskService {

    final TaskRepository taskRepository;
    final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toDto)
                .toList();
    }

    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDto(savedTask);
    }

    public Optional<TaskDto> getTaskById(Long id) {
        return taskRepository.findById(id).map(taskMapper::toDto);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

package com.example.tasks.application.service;

import com.example.tasks.domain.model.Task;
import com.example.tasks.domain.repository.TaskRepository;
import com.example.tasks.domain.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import com.example.tasks.application.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final AuthorRepository authorRepository;

    public TaskService(TaskRepository taskRepository, AuthorRepository authorRepository) {
        this.taskRepository = taskRepository;
        this.authorRepository = authorRepository;
    }

    public Task create(String name, LocalDate dueDate, Long authorId) {
        var author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author", authorId));
        Task task = Task.newTask(name, dueDate, author);
        return taskRepository.save(task);
    }

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task", id));
    }

    public Task update(Long id, String name, LocalDate dueDate, Long authorId) {
        Task existing = getById(id);
        var author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author", authorId));
        existing.update(name, dueDate, author);
        return taskRepository.save(existing);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
} 
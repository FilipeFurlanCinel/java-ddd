package com.example.tasks.domain.repository;

import com.example.tasks.domain.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Task save(Task task);

    List<Task> findAll();

    Optional<Task> findById(Long id);

    void deleteById(Long id);
} 
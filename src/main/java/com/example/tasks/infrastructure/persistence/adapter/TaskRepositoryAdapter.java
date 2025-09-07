package com.example.tasks.infrastructure.persistence.adapter;

import com.example.tasks.domain.model.Task;
import com.example.tasks.domain.repository.TaskRepository;
import com.example.tasks.infrastructure.persistence.entity.TaskJpaEntity;
import com.example.tasks.infrastructure.persistence.mapper.TaskMapper;
import com.example.tasks.infrastructure.persistence.repository.TaskJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskRepositoryAdapter implements TaskRepository {

    private final TaskJpaRepository jpaRepository;
    private final TaskMapper mapper;

    public TaskRepositoryAdapter(TaskJpaRepository jpaRepository, TaskMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Task save(Task task) {
        TaskJpaEntity entity = mapper.toEntity(task);
        TaskJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public List<Task> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
} 
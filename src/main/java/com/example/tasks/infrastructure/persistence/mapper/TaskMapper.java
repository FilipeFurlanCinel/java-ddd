package com.example.tasks.infrastructure.persistence.mapper;

import com.example.tasks.domain.model.Task;
import com.example.tasks.infrastructure.persistence.entity.TaskJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    private final AuthorMapper authorMapper;

    public TaskMapper(AuthorMapper authorMapper) {
        this.authorMapper = authorMapper;
    }

    public TaskJpaEntity toEntity(Task domain) {
        if (domain == null) return null;
        return new TaskJpaEntity(domain.getId(), domain.getName(), domain.getDueDate(), authorMapper.toEntity(domain.getAuthor()));
    }

    public Task toDomain(TaskJpaEntity entity) {
        if (entity == null) return null;
        return Task.withId(entity.getId(), entity.getName(), entity.getDueDate(), authorMapper.toDomain(entity.getAuthor()));
    }
} 
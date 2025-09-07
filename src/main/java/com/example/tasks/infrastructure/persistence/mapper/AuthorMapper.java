package com.example.tasks.infrastructure.persistence.mapper;

import com.example.tasks.domain.model.Author;
import com.example.tasks.infrastructure.persistence.entity.AuthorJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorJpaEntity toEntity(Author domain) {
        if (domain == null) return null;
        return new AuthorJpaEntity(domain.getId(), domain.getName());
    }

    public Author toDomain(AuthorJpaEntity entity) {
        if (entity == null) return null;
        return Author.withId(entity.getId(), entity.getName());
    }
} 
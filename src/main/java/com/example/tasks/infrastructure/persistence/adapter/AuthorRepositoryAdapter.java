package com.example.tasks.infrastructure.persistence.adapter;

import com.example.tasks.domain.model.Author;
import com.example.tasks.domain.repository.AuthorRepository;
import com.example.tasks.infrastructure.persistence.entity.AuthorJpaEntity;
import com.example.tasks.infrastructure.persistence.mapper.AuthorMapper;
import com.example.tasks.infrastructure.persistence.repository.AuthorJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AuthorRepositoryAdapter implements AuthorRepository {

    private final AuthorJpaRepository jpaRepository;
    private final AuthorMapper mapper;

    public AuthorRepositoryAdapter(AuthorJpaRepository jpaRepository, AuthorMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Author save(Author author) {
        AuthorJpaEntity entity = mapper.toEntity(author);
        AuthorJpaEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Author> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
} 
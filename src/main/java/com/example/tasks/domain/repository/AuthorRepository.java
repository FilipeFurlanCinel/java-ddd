package com.example.tasks.domain.repository;

import com.example.tasks.domain.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    Author save(Author author);

    Optional<Author> findById(Long id);

    List<Author> findAll();

    void deleteById(Long id);
} 
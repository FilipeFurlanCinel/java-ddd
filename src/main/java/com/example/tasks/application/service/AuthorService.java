package com.example.tasks.application.service;

import com.example.tasks.domain.model.Author;
import com.example.tasks.domain.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.tasks.application.exception.ResourceNotFoundException;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author create(String name) {
        return authorRepository.save(Author.newAuthor(name));
    }

    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    public Author getById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", id));
    }

    public Author update(Long id, String name) {
        Author author = getById(id);
        author.update(name);
        return authorRepository.save(author);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
} 
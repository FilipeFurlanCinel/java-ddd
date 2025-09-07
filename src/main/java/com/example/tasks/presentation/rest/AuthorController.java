package com.example.tasks.presentation.rest;

import com.example.tasks.application.service.AuthorService;
import com.example.tasks.presentation.contracts.AuthorRequest;
import com.example.tasks.presentation.contracts.AuthorResponse;
import com.example.tasks.presentation.mapper.ContractMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final ContractMapper mapper;

    public AuthorController(AuthorService authorService, ContractMapper mapper) {
        this.authorService = authorService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> create(@RequestBody @Valid AuthorRequest request) {
        var author = authorService.create(request.name());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toAuthorResponse(author));
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> listAll() {
        var authors = authorService.listAll().stream().map(mapper::toAuthorResponse).collect(Collectors.toList());
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getById(@PathVariable Long id) {
        var author = authorService.getById(id);
        return ResponseEntity.ok(mapper.toAuthorResponse(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponse> update(@PathVariable Long id, @RequestBody @Valid AuthorRequest request) {
        var author = authorService.update(id, request.name());
        return ResponseEntity.ok(mapper.toAuthorResponse(author));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
} 
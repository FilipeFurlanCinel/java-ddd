package com.example.tasks.presentation.rest;

import com.example.tasks.application.service.TaskService;
import com.example.tasks.presentation.contracts.TaskRequest;
import com.example.tasks.presentation.contracts.TaskResponse;
import com.example.tasks.presentation.mapper.ContractMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ContractMapper mapper;

    public TaskController(TaskService taskService, ContractMapper mapper) {
        this.taskService = taskService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody @Valid TaskRequest request) {
        var task = taskService.create(request.name(), request.dueDate(), request.authorId());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toTaskResponse(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> listAll() {
        var tasks = taskService.listAll()
                .stream()
                .map(mapper::toTaskResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getById(@PathVariable Long id) {
        var task = taskService.getById(id);
        return ResponseEntity.ok(mapper.toTaskResponse(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(@PathVariable Long id, @RequestBody @Valid TaskRequest request) {
        var task = taskService.update(id, request.name(), request.dueDate(), request.authorId());
        return ResponseEntity.ok(mapper.toTaskResponse(task));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
} 
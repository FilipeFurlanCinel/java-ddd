package com.example.tasks.domain.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Domain aggregate root that represents a Task in the system.
 */
public class Task extends BaseEntity {

    private String name;
    private LocalDate dueDate;
    private Author author;

    private Task(Long id, String name, LocalDate dueDate, Author author) {
        super(id);
        this.name = validateName(name);
        this.dueDate = Objects.requireNonNull(dueDate, "dueDate must not be null");
        this.author = Objects.requireNonNull(author, "author must not be null");
    }

    public static Task newTask(String name, LocalDate dueDate, Author author) {
        return new Task(null, name, dueDate, author);
    }

    public static Task withId(Long id, String name, LocalDate dueDate, Author author) {
        return new Task(id, name, dueDate, author);
    }

    private String validateName(String name) {
        Objects.requireNonNull(name, "name must not be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Task name cannot be blank");
        }
        return name.trim();
    }

    // Business behavior
    public void update(String name, LocalDate dueDate, Author author) {
        this.name = validateName(name);
        this.dueDate = Objects.requireNonNull(dueDate, "dueDate must not be null");
        this.author = Objects.requireNonNull(author, "author must not be null");
    }

    // Getters
    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", dueDate=" + dueDate +
                ", author=" + author +
                '}';
    }
} 
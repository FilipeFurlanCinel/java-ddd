package com.example.tasks.domain.model;

import java.util.Objects;

public class Author extends BaseEntity {

    private String name;

    private Author(Long id, String name) {
        super(id);
        this.name = validateName(name);
    }

    public static Author newAuthor(String name) {
        return new Author(null, name);
    }

    public static Author withId(Long id, String name) {
        return new Author(id, name);
    }

    private String validateName(String name) {
        Objects.requireNonNull(name, "Author name must not be null");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Author name cannot be blank");
        }
        return name.trim();
    }

    public String getName() {
        return name;
    }

    public void update(String name) {
        this.name = validateName(name);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
} 
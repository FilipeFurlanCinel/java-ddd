package com.example.tasks.domain.model;

/**
 * Base class for all domain aggregate roots/value objects that need an identifier.
 */
public abstract class BaseEntity {
    private Long id;

    protected BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
} 
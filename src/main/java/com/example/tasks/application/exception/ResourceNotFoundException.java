package com.example.tasks.application.exception;

/**
 * Exception thrown when a requested resource is not found at the application/use case level.
 */
public class ResourceNotFoundException extends RuntimeException {

    private final String resource;
    private final Object identifier;

    public ResourceNotFoundException(String resource, Object identifier) {
        super(resource + " not found: " + identifier);
        this.resource = resource;
        this.identifier = identifier;
    }

    public String getResource() {
        return resource;
    }

    public Object getIdentifier() {
        return identifier;
    }
} 
package com.example.tasks.presentation.contracts;

import jakarta.validation.constraints.NotBlank;

/**
 * Contract representing an author creation/update payload.
 */
public record AuthorRequest(@NotBlank String name) {
} 
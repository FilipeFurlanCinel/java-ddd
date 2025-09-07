package com.example.tasks.presentation.contracts;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * Contract representing task creation/update payload.
 */
public record TaskRequest(
        @NotBlank String name,
        @NotNull @FutureOrPresent LocalDate dueDate,
        @NotNull Long authorId
) {
} 
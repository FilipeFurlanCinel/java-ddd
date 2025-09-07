package com.example.tasks.presentation.contracts;

import java.time.LocalDate;

public record TaskResponse(
        Long id,
        String name,
        LocalDate dueDate,
        AuthorResponse author
) {
} 
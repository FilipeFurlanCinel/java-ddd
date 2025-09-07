package com.example.tasks.presentation.api;

import java.time.Instant;
import java.util.Map;

public record ValidationErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        Map<String, String> fieldErrors
) {
    public static ValidationErrorResponse of(int status, String error, String message, String path, Map<String, String> fieldErrors) {
        return new ValidationErrorResponse(Instant.now(), status, error, message, path, fieldErrors);
    }
} 
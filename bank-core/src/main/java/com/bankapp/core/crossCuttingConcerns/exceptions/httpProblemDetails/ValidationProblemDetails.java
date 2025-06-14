package com.bankapp.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class ValidationProblemDetails extends ProblemDetails {
    public ValidationProblemDetails(Map<String, String> validationErrors) {
        super("Validation Rule Violation", HttpStatus.BAD_REQUEST.value(), "Validation errors occurred");
        setType("https://bankapp.com/exceptions/validation");
        setExtensions(Map.of("validationErrors", validationErrors));
    }
} 
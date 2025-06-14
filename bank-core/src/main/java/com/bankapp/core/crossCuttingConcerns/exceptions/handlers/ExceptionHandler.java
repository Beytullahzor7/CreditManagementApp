package com.bankapp.core.crossCuttingConcerns.exceptions.handlers;

import com.bankapp.core.crossCuttingConcerns.exceptions.httpProblemDetails.ProblemDetails;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public abstract class ExceptionHandler {
    public abstract ResponseEntity<ProblemDetails> handleException(Exception exception, HttpServletRequest request);
} 
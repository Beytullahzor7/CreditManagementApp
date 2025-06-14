package com.bankapp.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;

public class NotFoundProblemDetails extends ProblemDetails {
    public NotFoundProblemDetails(String detail) {
        super("Resource Not Found", HttpStatus.NOT_FOUND.value(), detail);
        setType("https://bankapp.com/exceptions/not-found");
    }
} 
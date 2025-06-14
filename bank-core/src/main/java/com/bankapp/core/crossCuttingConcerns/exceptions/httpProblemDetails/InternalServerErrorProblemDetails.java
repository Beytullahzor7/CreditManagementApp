package com.bankapp.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;

public class InternalServerErrorProblemDetails extends ProblemDetails {
    public InternalServerErrorProblemDetails() {
        super("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred");
        setType("https://bankapp.com/exceptions/internal");
    }
} 
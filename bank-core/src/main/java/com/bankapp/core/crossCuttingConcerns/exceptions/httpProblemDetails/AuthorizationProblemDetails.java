package com.bankapp.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;

public class AuthorizationProblemDetails extends ProblemDetails {
    public AuthorizationProblemDetails() {
        super("Authorization Error", HttpStatus.UNAUTHORIZED.value(), "You are not authorized to perform this operation");
        setType("https://bankapp.com/exceptions/authorization");
    }
} 
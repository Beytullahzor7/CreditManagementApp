package com.bankapp.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import org.springframework.http.HttpStatus;

public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails(String detail) {
        super("Business Rule Violation", HttpStatus.BAD_REQUEST.value(), detail);
        setType("https://bankapp.com/exceptions/business");
    }
} 
package com.bankapp.core.crossCuttingConcerns.exceptions.types;

public class AuthorizationException extends RuntimeException {
    public AuthorizationException(String message) {
        super(message);
    }
} 
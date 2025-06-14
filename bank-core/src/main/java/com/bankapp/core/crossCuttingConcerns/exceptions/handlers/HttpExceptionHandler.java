package com.bankapp.core.crossCuttingConcerns.exceptions.handlers;

import com.bankapp.core.crossCuttingConcerns.exceptions.httpProblemDetails.*;
import com.bankapp.core.crossCuttingConcerns.exceptions.types.AuthorizationException;
import com.bankapp.core.crossCuttingConcerns.exceptions.types.ValidationException;
import com.bankapp.core.exceptions.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class HttpExceptionHandler extends com.bankapp.core.crossCuttingConcerns.exceptions.handlers.ExceptionHandler {

    @Override
    @ExceptionHandler
    public ResponseEntity<ProblemDetails> handleException(Exception exception, HttpServletRequest request) {
        ProblemDetails problemDetails = new InternalServerErrorProblemDetails();
        problemDetails.setDetail(exception.getMessage());
        return new ResponseEntity<>(problemDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetails> handleBusinessException(BusinessException exception, HttpServletRequest request) {
        ProblemDetails problemDetails = new BusinessProblemDetails(exception.getMessage());
        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetails> handleValidationException(MethodArgumentNotValidException exception,
                                                                  HttpServletRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
                validationErrors.put(error.getField(), error.getDefaultMessage()));

        ProblemDetails problemDetails = new ValidationProblemDetails(validationErrors);
        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetails> handleValidationException(ValidationException exception,
                                                                  HttpServletRequest request) {
        ProblemDetails problemDetails = new ValidationProblemDetails(exception.getValidationErrors());
        return new ResponseEntity<>(problemDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetails> handleAuthorizationException(AuthorizationException exception,
                                                                     HttpServletRequest request) {
        ProblemDetails problemDetails = new AuthorizationProblemDetails();
        return new ResponseEntity<>(problemDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<ProblemDetails> handleNotFoundException(NoSuchElementException exception,
                                                                HttpServletRequest request) {
        ProblemDetails problemDetails = new NotFoundProblemDetails(exception.getMessage());
        return new ResponseEntity<>(problemDetails, HttpStatus.NOT_FOUND);
    }
} 
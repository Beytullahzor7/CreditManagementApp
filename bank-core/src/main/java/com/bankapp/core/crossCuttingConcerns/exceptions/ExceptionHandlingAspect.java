package com.bankapp.core.crossCuttingConcerns.exceptions;

import com.bankapp.core.crossCuttingConcerns.exceptions.handlers.ExceptionHandler;
import com.bankapp.core.crossCuttingConcerns.exceptions.httpProblemDetails.ProblemDetails;
import com.bankapp.core.utilities.results.ErrorDataResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@RequiredArgsConstructor
public class ExceptionHandlingAspect {
    private final ExceptionHandler exceptionHandler;

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object handleException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Exception exception) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                    .getRequest();
            return exceptionHandler.handleException(exception, request);
        }
    }
} 
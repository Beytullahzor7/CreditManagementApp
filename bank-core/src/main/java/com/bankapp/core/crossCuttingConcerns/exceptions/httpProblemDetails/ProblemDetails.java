package com.bankapp.core.crossCuttingConcerns.exceptions.httpProblemDetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemDetails {
    private String type;
    private String title;
    private int status;
    private String detail;
    private String instance;
    private Map<String, Object> extensions;

    public ProblemDetails(String title, int status, String detail) {
        this.title = title;
        this.status = status;
        this.detail = detail;
    }
} 
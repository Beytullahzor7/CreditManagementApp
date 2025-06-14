package com.bankapp.business.abstracts;

import java.util.List;

public interface BaseService<TRequest, TResponse> {
    TResponse add(TRequest request);
    TResponse update(Long id, TRequest request);
    void delete(Long id);
    TResponse getById(Long id);
    List<TResponse> getAll();
} 
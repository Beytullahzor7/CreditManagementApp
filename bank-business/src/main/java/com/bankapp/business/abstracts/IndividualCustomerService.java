package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.CreateIndividualCustomerRequest;
import com.bankapp.business.dtos.responses.CreatedIndividualCustomerResponse;
import com.bankapp.business.dtos.responses.GetAllIndividualCustomersResponse;
import com.bankapp.core.utilities.results.DataResult;
import com.bankapp.core.utilities.results.Result;

import java.util.List;

public interface IndividualCustomerService {
    DataResult<CreatedIndividualCustomerResponse> add(CreateIndividualCustomerRequest request);
    DataResult<GetAllIndividualCustomersResponse> update(Long id, CreateIndividualCustomerRequest request);
    Result delete(Long id);
    DataResult<GetAllIndividualCustomersResponse> getById(Long id);
    DataResult<List<GetAllIndividualCustomersResponse>> getAll();
    DataResult<GetAllIndividualCustomersResponse> getByNationalId(String nationalId);
    boolean existsByNationalId(String nationalId);
} 
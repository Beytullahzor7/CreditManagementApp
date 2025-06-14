package com.bankapp.business.abstracts;

import com.bankapp.business.dtos.requests.CreateCorporateCustomerRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;

public interface CorporateCustomerService extends BaseService<CreateCorporateCustomerRequest, CorporateCustomerResponse> {
    CorporateCustomerResponse getByTaxNumber(String taxNumber);
    boolean existsByTaxNumber(String taxNumber);
} 
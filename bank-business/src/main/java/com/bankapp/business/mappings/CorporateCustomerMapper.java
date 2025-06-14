package com.bankapp.business.mappings;

import com.bankapp.business.dtos.requests.CreateCorporateCustomerRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.entities.CorporateCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.InheritConfiguration;

@Mapper(componentModel = "spring", uses = CustomerMapper.class)
public interface CorporateCustomerMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customerNumber", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    CorporateCustomer requestToEntity(CreateCorporateCustomerRequest request);

    @InheritConfiguration
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customerNumber", source = "customerNumber")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "companyName", source = "companyName")
    @Mapping(target = "taxNumber", source = "taxNumber")
    @Mapping(target = "annualRevenue", source = "annualRevenue")
    @Mapping(target = "employeeCount", source = "employeeCount")
    @Mapping(target = "sector", source = "sector")
    CorporateCustomerResponse entityToResponse(CorporateCustomer customer);
} 
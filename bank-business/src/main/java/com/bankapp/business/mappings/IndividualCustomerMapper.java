package com.bankapp.business.mappings;

import com.bankapp.business.dtos.requests.CreateIndividualCustomerRequest;
import com.bankapp.business.dtos.responses.CreatedIndividualCustomerResponse;
import com.bankapp.business.dtos.responses.GetAllIndividualCustomersResponse;
import com.bankapp.entities.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.InheritConfiguration;

@Mapper(componentModel = "spring", uses = CustomerMapper.class)
public interface IndividualCustomerMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customerNumber", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    IndividualCustomer requestToEntity(CreateIndividualCustomerRequest request);

    @InheritConfiguration
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customerNumber", source = "customerNumber")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "nationalId", source = "nationalId")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "monthlyIncome", source = "monthlyIncome")
    CreatedIndividualCustomerResponse entityToCreatedResponse(IndividualCustomer customer);

    @InheritConfiguration
    @Mapping(target = "id", source = "id")
    @Mapping(target = "customerNumber", source = "customerNumber")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "nationalId", source = "nationalId")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "monthlyIncome", source = "monthlyIncome")
    GetAllIndividualCustomersResponse entityToResponse(IndividualCustomer customer);
} 
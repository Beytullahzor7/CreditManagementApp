package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.IndividualCustomerService;
import com.bankapp.business.constants.Messages;
import com.bankapp.business.dtos.requests.CreateIndividualCustomerRequest;
import com.bankapp.business.dtos.responses.CreatedIndividualCustomerResponse;
import com.bankapp.business.dtos.responses.GetAllIndividualCustomersResponse;
import com.bankapp.business.mappings.IndividualCustomerMapper;
import com.bankapp.business.rules.IndividualCustomerBusinessRules;
import com.bankapp.core.exceptions.BusinessException;
import com.bankapp.core.utilities.results.DataResult;
import com.bankapp.core.utilities.results.Result;
import com.bankapp.core.utilities.results.SuccessDataResult;
import com.bankapp.core.utilities.results.SuccessResult;
import com.bankapp.entities.IndividualCustomer;
import com.bankapp.repositories.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndividualCustomerMapper individualCustomerMapper;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;

    @Override
    public DataResult<CreatedIndividualCustomerResponse> add(CreateIndividualCustomerRequest request) {
        individualCustomerBusinessRules.checkIfNationalIdValid(request.getNationalId());
        individualCustomerBusinessRules.checkIfNationalIdExists(request.getNationalId());

        IndividualCustomer customer = individualCustomerMapper.requestToEntity(request);
        customer.setCustomerNumber(individualCustomerBusinessRules.generateCustomerNumber());

        individualCustomerRepository.save(customer);
        return new SuccessDataResult<>(individualCustomerMapper.entityToCreatedResponse(customer), 
            Messages.Customer.ADDED.getMessage());
    }

    @Override
    public DataResult<GetAllIndividualCustomersResponse> update(Long id, CreateIndividualCustomerRequest request) {
        IndividualCustomer existingCustomer = individualCustomerRepository.findById(id)
                .orElseThrow(() -> new BusinessException(Messages.Customer.NOT_FOUND.getMessage()));

        if (!existingCustomer.getNationalId().equals(request.getNationalId())) {
            individualCustomerBusinessRules.checkIfNationalIdValid(request.getNationalId());
            individualCustomerBusinessRules.checkIfNationalIdExists(request.getNationalId());
        }

        IndividualCustomer updatedCustomer = individualCustomerMapper.requestToEntity(request);
        updatedCustomer.setId(id);
        updatedCustomer.setCustomerNumber(existingCustomer.getCustomerNumber());

        individualCustomerRepository.save(updatedCustomer);
        return new SuccessDataResult<>(individualCustomerMapper.entityToResponse(updatedCustomer),
            Messages.Customer.UPDATED.getMessage());
    }

    @Override
    public Result delete(Long id) {
        individualCustomerRepository.findById(id)
                .orElseThrow(() -> new BusinessException(Messages.Customer.NOT_FOUND.getMessage()));
        individualCustomerRepository.deleteById(id);
        return new SuccessResult(Messages.Customer.DELETED.getMessage());
    }

    @Override
    public DataResult<GetAllIndividualCustomersResponse> getById(Long id) {
        IndividualCustomer customer = individualCustomerRepository.findById(id)
                .orElseThrow(() -> new BusinessException(Messages.Customer.NOT_FOUND.getMessage()));
        return new SuccessDataResult<>(individualCustomerMapper.entityToResponse(customer));
    }

    @Override
    public DataResult<List<GetAllIndividualCustomersResponse>> getAll() {
        List<IndividualCustomer> customers = individualCustomerRepository.findAll();
        return new SuccessDataResult<>(customers.stream()
                .map(individualCustomerMapper::entityToResponse)
                .toList());
    }

    @Override
    public DataResult<GetAllIndividualCustomersResponse> getByNationalId(String nationalId) {
        IndividualCustomer customer = individualCustomerRepository.findByNationalId(nationalId);
        if (customer == null) {
            throw new BusinessException(Messages.Customer.NOT_FOUND.getMessage());
        }
        return new SuccessDataResult<>(individualCustomerMapper.entityToResponse(customer));
    }

    @Override
    public boolean existsByNationalId(String nationalId) {
        return individualCustomerRepository.existsByNationalId(nationalId);
    }
} 
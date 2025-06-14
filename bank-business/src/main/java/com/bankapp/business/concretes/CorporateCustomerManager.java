package com.bankapp.business.concretes;

import com.bankapp.business.abstracts.CorporateCustomerService;
import com.bankapp.business.dtos.requests.CreateCorporateCustomerRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.business.mappings.CorporateCustomerMapper;
import com.bankapp.business.rules.CorporateCustomerBusinessRules;
import com.bankapp.core.exceptions.BusinessException;
import com.bankapp.entities.CorporateCustomer;
import com.bankapp.repositories.abstracts.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final CorporateCustomerMapper corporateCustomerMapper;
    private final CorporateCustomerBusinessRules corporateCustomerBusinessRules;

    @Override
    public CorporateCustomerResponse add(CreateCorporateCustomerRequest request) {
        corporateCustomerBusinessRules.checkIfTaxNumberValid(request.getTaxNumber());
        corporateCustomerBusinessRules.checkIfTaxNumberExists(request.getTaxNumber());

        CorporateCustomer customer = corporateCustomerMapper.requestToEntity(request);
        customer.setCustomerNumber(corporateCustomerBusinessRules.generateCustomerNumber());

        corporateCustomerRepository.save(customer);
        return corporateCustomerMapper.entityToResponse(customer);
    }

    @Override
    public CorporateCustomerResponse update(Long id, CreateCorporateCustomerRequest request) {
        CorporateCustomer existingCustomer = corporateCustomerRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Müşteri bulunamadı"));

        if (!existingCustomer.getTaxNumber().equals(request.getTaxNumber())) {
            corporateCustomerBusinessRules.checkIfTaxNumberValid(request.getTaxNumber());
            corporateCustomerBusinessRules.checkIfTaxNumberExists(request.getTaxNumber());
        }

        CorporateCustomer updatedCustomer = corporateCustomerMapper.requestToEntity(request);
        updatedCustomer.setId(id);
        updatedCustomer.setCustomerNumber(existingCustomer.getCustomerNumber());

        corporateCustomerRepository.save(updatedCustomer);
        return corporateCustomerMapper.entityToResponse(updatedCustomer);
    }

    @Override
    public void delete(Long id) {
        corporateCustomerRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Müşteri bulunamadı"));
        corporateCustomerRepository.deleteById(id);
    }

    @Override
    public CorporateCustomerResponse getById(Long id) {
        CorporateCustomer customer = corporateCustomerRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Müşteri bulunamadı"));
        return corporateCustomerMapper.entityToResponse(customer);
    }

    @Override
    public List<CorporateCustomerResponse> getAll() {
        List<CorporateCustomer> customers = corporateCustomerRepository.findAll();
        return customers.stream()
                .map(corporateCustomerMapper::entityToResponse)
                .toList();
    }

    @Override
    public CorporateCustomerResponse getByTaxNumber(String taxNumber) {
        CorporateCustomer customer = corporateCustomerRepository.findByTaxNumber(taxNumber);
        if (customer == null) {
            throw new BusinessException("Müşteri bulunamadı");
        }
        return corporateCustomerMapper.entityToResponse(customer);
    }

    @Override
    public boolean existsByTaxNumber(String taxNumber) {
        return corporateCustomerRepository.existsByTaxNumber(taxNumber);
    }
} 
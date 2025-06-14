package com.bankapp.business.rules;

import com.bankapp.business.constants.Messages;
import com.bankapp.core.exceptions.BusinessException;
import com.bankapp.repositories.abstracts.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class CorporateCustomerBusinessRules {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final Random random = new Random();

    public String generateCustomerNumber() {
        String customerNumber;
        do {
            // 10 haneli müşteri numarası oluştur (2 ile başlayan)
            customerNumber = "2" + String.format("%09d", Math.abs(random.nextInt(999999999)));
        } while (corporateCustomerRepository.existsByCustomerNumber(customerNumber));

        return customerNumber;
    }

    public void checkIfTaxNumberExists(String taxNumber) {
        if (corporateCustomerRepository.existsByTaxNumber(taxNumber)) {
            throw new BusinessException(Messages.Customer.TAX_NUMBER_EXISTS.getMessage());
        }
    }

    public void checkIfTaxNumberValid(String taxNumber) {
        if (!isValidTaxNumber(taxNumber)) {
            throw new BusinessException(Messages.Customer.INVALID_TAX_NUMBER.getMessage());
        }
    }

    private boolean isValidTaxNumber(String taxNumber) {
        if (taxNumber == null || taxNumber.length() != 10) {
            return false;
        }

        try {
            // Vergi numarası sadece rakamlardan oluşmalı
            return taxNumber.matches("^[0-9]{10}$");
        } catch (Exception e) {
            return false;
        }
    }
} 
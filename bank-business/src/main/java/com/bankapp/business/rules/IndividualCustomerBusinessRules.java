package com.bankapp.business.rules;

import com.bankapp.business.constants.Messages;
import com.bankapp.core.exceptions.BusinessException;
import com.bankapp.repositories.abstracts.IndividualCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class IndividualCustomerBusinessRules {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final Random random = new Random();

    public String generateCustomerNumber() {
        String customerNumber;
        do {
            // 10 haneli müşteri numarası oluştur (1 ile başlayan)
            customerNumber = "1" + String.format("%09d", Math.abs(random.nextInt(999999999)));
        } while (individualCustomerRepository.existsByCustomerNumber(customerNumber));

        return customerNumber;
    }

    public void checkIfNationalIdExists(String nationalId) {
        if (individualCustomerRepository.existsByNationalId(nationalId)) {
            throw new BusinessException(Messages.Customer.NATIONAL_ID_EXISTS.getMessage());
        }
    }

    public void checkIfNationalIdValid(String nationalId) {
        if (!isValidNationalId(nationalId)) {
            throw new BusinessException(Messages.Customer.INVALID_NATIONAL_ID.getMessage());
        }
    }

    private boolean isValidNationalId(String nationalId) {
        if (nationalId == null || nationalId.length() != 11) {
            return false;
        }

        try {
            int[] digits = new int[11];
            for (int i = 0; i < 11; i++) {
                digits[i] = Integer.parseInt(nationalId.substring(i, i + 1));
            }

            // TC kimlik numarası algoritması kontrolü
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < 9; i += 2) {
                sum1 += digits[i];
            }
            for (int i = 1; i < 8; i += 2) {
                sum2 += digits[i];
            }

            boolean rule1 = ((sum1 * 7) - sum2) % 10 == digits[9];
            boolean rule2 = (sum1 + sum2 + digits[9]) % 10 == digits[10];

            return rule1 && rule2;
        } catch (NumberFormatException e) {
            return false;
        }
    }
} 
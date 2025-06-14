package com.bankapp.business.dtos.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class IndividualCustomerResponse extends CustomerResponse {
    private String nationalId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Double monthlyIncome;
} 
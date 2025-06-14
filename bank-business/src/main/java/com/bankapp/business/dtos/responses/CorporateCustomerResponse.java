package com.bankapp.business.dtos.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CorporateCustomerResponse extends CustomerResponse {
    private String companyName;
    private String taxNumber;
    private Double annualRevenue;
    private Integer employeeCount;
    private String sector;
} 
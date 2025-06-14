package com.bankapp.business.dtos.requests;

import com.bankapp.business.constants.Messages;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCorporateCustomerRequest {

    @NotBlank(message = "#{T(com.bankapp.business.constants.Messages.Validation).COMPANY_NAME_REQUIRED.getMessage()}")
    @Size(max = 100, message = "#{T(com.bankapp.business.constants.Messages.Validation).COMPANY_NAME_SIZE.getMessage()}")
    private String companyName;

    @NotBlank(message = "#{T(com.bankapp.business.constants.Messages.Validation).TAX_NUMBER_REQUIRED.getMessage()}")
    @Size(min = 10, max = 10, message = "#{T(com.bankapp.business.constants.Messages.Validation).TAX_NUMBER_SIZE.getMessage()}")
    private String taxNumber;

    @NotBlank(message = "#{T(com.bankapp.business.constants.Messages.Validation).PHONE_REQUIRED.getMessage()}")
    @Pattern(regexp = "^[0-9]{10}$", message = "#{T(com.bankapp.business.constants.Messages.Validation).PHONE_PATTERN.getMessage()}")
    private String phoneNumber;

    @Email(message = "#{T(com.bankapp.business.constants.Messages.Validation).EMAIL_PATTERN.getMessage()}")
    private String email;

    @NotBlank(message = "#{T(com.bankapp.business.constants.Messages.Validation).ADDRESS_REQUIRED.getMessage()}")
    @Size(max = 500, message = "#{T(com.bankapp.business.constants.Messages.Validation).ADDRESS_SIZE.getMessage()}")
    private String address;

    @NotNull(message = "#{T(com.bankapp.business.constants.Messages.Validation).ANNUAL_REVENUE_REQUIRED.getMessage()}")
    @Positive(message = "#{T(com.bankapp.business.constants.Messages.Validation).ANNUAL_REVENUE_POSITIVE.getMessage()}")
    private Double annualRevenue;

    @NotNull(message = "#{T(com.bankapp.business.constants.Messages.Validation).EMPLOYEE_COUNT_REQUIRED.getMessage()}")
    @Positive(message = "#{T(com.bankapp.business.constants.Messages.Validation).EMPLOYEE_COUNT_POSITIVE.getMessage()}")
    private Integer employeeCount;

    @NotBlank(message = "#{T(com.bankapp.business.constants.Messages.Validation).SECTOR_REQUIRED.getMessage()}")
    @Size(max = 50, message = "#{T(com.bankapp.business.constants.Messages.Validation).SECTOR_SIZE.getMessage()}")
    private String sector;
} 
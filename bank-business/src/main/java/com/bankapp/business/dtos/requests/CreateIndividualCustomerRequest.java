package com.bankapp.business.dtos.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateIndividualCustomerRequest {

    @NotBlank(message = "#{T(com.bankapp.business.constants.Messages.Validation).NATIONAL_ID_REQUIRED.getMessage()}")
    @Size(min = 11, max = 11, message = "#{T(com.bankapp.business.constants.Messages.Validation).NATIONAL_ID_SIZE.getMessage()}")
    private String nationalId;

    @NotBlank(message = "#{T(com.bankapp.business.constants.Messages.Validation).FIRST_NAME_REQUIRED.getMessage()}")
    @Size(max = 50, message = "#{T(com.bankapp.business.constants.Messages.Validation).FIRST_NAME_SIZE.getMessage()}")
    private String firstName;

    @NotBlank(message = "#{T(com.bankapp.business.constants.Messages.Validation).LAST_NAME_REQUIRED.getMessage()}")
    @Size(max = 50, message = "#{T(com.bankapp.business.constants.Messages.Validation).LAST_NAME_SIZE.getMessage()}")
    private String lastName;

    @NotNull(message = "#{T(com.bankapp.business.constants.Messages.Validation).BIRTH_DATE_REQUIRED.getMessage()}")
    @Past(message = "#{T(com.bankapp.business.constants.Messages.Validation).BIRTH_DATE_PAST.getMessage()}")
    private LocalDate birthDate;

    @NotBlank(message = "#{T(com.bankapp.business.constants.Messages.Validation).PHONE_REQUIRED.getMessage()}")
    @Pattern(regexp = "^[0-9]{10}$", message = "#{T(com.bankapp.business.constants.Messages.Validation).PHONE_PATTERN.getMessage()}")
    private String phoneNumber;

    @Email(message = "#{T(com.bankapp.business.constants.Messages.Validation).EMAIL_PATTERN.getMessage()}")
    private String email;

    @NotBlank(message = "#{T(com.bankapp.business.constants.Messages.Validation).ADDRESS_REQUIRED.getMessage()}")
    @Size(max = 500, message = "#{T(com.bankapp.business.constants.Messages.Validation).ADDRESS_SIZE.getMessage()}")
    private String address;

    @NotNull(message = "#{T(com.bankapp.business.constants.Messages.Validation).MONTHLY_INCOME_REQUIRED.getMessage()}")
    @Positive(message = "#{T(com.bankapp.business.constants.Messages.Validation).MONTHLY_INCOME_POSITIVE.getMessage()}")
    private Double monthlyIncome;
} 
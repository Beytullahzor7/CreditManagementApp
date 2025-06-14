package com.bankapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "corporate_customers")
@PrimaryKeyJoinColumn(name = "customer_id")
public class CorporateCustomer extends Customer {

    @Column(name = "company_name", length = 100, nullable = false)
    private String companyName;

    @Column(name = "tax_number", length = 10, unique = true, nullable = false)
    private String taxNumber;

    @Column(name = "annual_revenue")
    private Double annualRevenue;

    @Column(name = "employee_count")
    private Integer employeeCount;

    @Column(name = "sector", length = 50)
    private String sector;
} 
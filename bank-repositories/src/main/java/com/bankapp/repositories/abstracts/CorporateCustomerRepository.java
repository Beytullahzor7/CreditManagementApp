package com.bankapp.repositories.abstracts;

import com.bankapp.entities.CorporateCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerRepository extends JpaRepository<CorporateCustomer, Long> {
    boolean existsByTaxNumber(String taxNumber);
    boolean existsByCustomerNumber(String customerNumber);
    CorporateCustomer findByTaxNumber(String taxNumber);
} 
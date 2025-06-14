package com.bankapp.entities;

import com.bankapp.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Customer extends BaseEntity<Long> {

    @Column(name = "customer_number", unique = true, nullable = false)
    private String customerNumber;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "address", length = 500)
    private String address;

    @PrePersist
    public void onCreateCustomer() {
        super.setCreatedDate(LocalDateTime.now());
        if (this.customerNumber == null) {
            Random random = new Random();
            this.customerNumber = String.format("%010d", random.nextInt(1000000000));
        }
    }
} 
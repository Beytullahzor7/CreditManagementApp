package com.bankapp.webapi.controllers;

import com.bankapp.business.abstracts.CorporateCustomerService;
import com.bankapp.business.dtos.requests.CreateCorporateCustomerRequest;
import com.bankapp.business.dtos.responses.CorporateCustomerResponse;
import com.bankapp.core.utilities.results.DataResult;
import com.bankapp.core.utilities.results.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corporate-customers")
@AllArgsConstructor
@Tag(name = "Corporate Customers", description = "Corporate Customer API")
public class CorporateCustomerController {
    private final CorporateCustomerService corporateCustomerService;

    @PostMapping
    @Operation(summary = "Create a new corporate customer")
    public ResponseEntity<DataResult<CorporateCustomerResponse>> add(@Valid @RequestBody CreateCorporateCustomerRequest request) {
        var result = this.corporateCustomerService.add(request);
        return new ResponseEntity<>(new DataResult<>(result, true), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all corporate customers")
    public ResponseEntity<DataResult<List<CorporateCustomerResponse>>> getAll() {
        var result = this.corporateCustomerService.getAll();
        return new ResponseEntity<>(new DataResult<>(result, true), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get corporate customer by ID")
    public ResponseEntity<DataResult<CorporateCustomerResponse>> getById(@PathVariable Long id) {
        var result = this.corporateCustomerService.getById(id);
        return new ResponseEntity<>(new DataResult<>(result, true), HttpStatus.OK);
    }

    @GetMapping("/by-tax-number/{taxNumber}")
    @Operation(summary = "Get corporate customer by tax number")
    public ResponseEntity<DataResult<CorporateCustomerResponse>> getByTaxNumber(@PathVariable String taxNumber) {
        var result = this.corporateCustomerService.getByTaxNumber(taxNumber);
        return new ResponseEntity<>(new DataResult<>(result, true), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update corporate customer")
    public ResponseEntity<DataResult<CorporateCustomerResponse>> update(@PathVariable Long id, @Valid @RequestBody CreateCorporateCustomerRequest request) {
        var result = this.corporateCustomerService.update(id, request);
        return new ResponseEntity<>(new DataResult<>(result, true), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete corporate customer")
    public ResponseEntity<Result> delete(@PathVariable Long id) {
        this.corporateCustomerService.delete(id);
        return new ResponseEntity<>(new Result(true), HttpStatus.OK);
    }
} 
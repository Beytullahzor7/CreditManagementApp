package com.bankapp.webapi.controllers;

import com.bankapp.business.abstracts.IndividualCustomerService;
import com.bankapp.business.dtos.requests.CreateIndividualCustomerRequest;
import com.bankapp.business.dtos.responses.CreatedIndividualCustomerResponse;
import com.bankapp.business.dtos.responses.GetAllIndividualCustomersResponse;
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
@RequestMapping("/individual-customers")
@AllArgsConstructor
@Tag(name = "Individual Customers", description = "Individual Customer API")
public class IndividualCustomerController {
    private final IndividualCustomerService individualCustomerService;

    @PostMapping
    @Operation(summary = "Create a new individual customer")
    public ResponseEntity<DataResult<CreatedIndividualCustomerResponse>> add(@Valid @RequestBody CreateIndividualCustomerRequest request) {
        var result = this.individualCustomerService.add(request);
        return new ResponseEntity<>(result, result.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    @Operation(summary = "Get all individual customers")
    public ResponseEntity<DataResult<List<GetAllIndividualCustomersResponse>>> getAll() {
        var result = this.individualCustomerService.getAll();
        return new ResponseEntity<>(result, result.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get individual customer by ID")
    public ResponseEntity<DataResult<GetAllIndividualCustomersResponse>> getById(@PathVariable Long id) {
        var result = this.individualCustomerService.getById(id);
        return new ResponseEntity<>(result, result.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete individual customer")
    public ResponseEntity<Result> delete(@PathVariable Long id) {
        var result = this.individualCustomerService.delete(id);
        return new ResponseEntity<>(result, result.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
} 
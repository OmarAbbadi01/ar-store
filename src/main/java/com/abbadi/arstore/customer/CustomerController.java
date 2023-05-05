package com.abbadi.arstore.customer;

import com.abbadi.arstore.common.validation.OnUpdate;
import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.customer.model.CustomerRequest;
import com.abbadi.arstore.customer.model.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    private final CustomerControllerMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") final Long id) {
        CustomerDto customerDto = service.findById(id);
        return ResponseEntity.ok(mapper.toResponse(customerDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        List<CustomerResponse> response = service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerRequest> update(@RequestBody @Validated(value = OnUpdate.class) final CustomerRequest request,
                                                  @PathVariable("id") final Long id) {
        if (!request.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        service.update(mapper.toDto(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerRequest> delete(@PathVariable("id") final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

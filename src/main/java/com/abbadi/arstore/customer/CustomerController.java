package com.abbadi.arstore.customer;

import com.abbadi.arstore.common.validation.OnUpdate;
import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.customer.model.CustomerRequest;
import com.abbadi.arstore.customer.model.CustomerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abbadi.arstore.customer.CustomerControllerMapper.toDto;
import static com.abbadi.arstore.customer.CustomerControllerMapper.toResponse;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Validated
@Secured("CUSTOMER")
public class CustomerController {

    private final CustomerService service;

    @GetMapping()
    public ResponseEntity<CustomerResponse> findById() {
        Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        CustomerDto customerDto = service.findById(id);
        return ResponseEntity.ok(toResponse(customerDto));
    }

//    @GetMapping
//    public ResponseEntity<List<CustomerResponse>> findAll() {
//        List<CustomerResponse> response = service.findAll()
//                .stream()
//                .map(CustomerControllerMapper::toResponse)
//                .toList();
//        return ResponseEntity.ok(response);
//    }

    @PutMapping("/{id}")
    @Validated(value = OnUpdate.class)
    public ResponseEntity<CustomerRequest> update(@RequestBody @Valid final CustomerRequest request,
                                                  @PathVariable("id") final Long id) {
        if (!request.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        service.update(toDto(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerRequest> delete(@PathVariable("id") final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

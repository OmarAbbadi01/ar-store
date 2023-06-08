package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.address.model.AddressRequest;
import com.abbadi.arstore.address.model.AddressResponse;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.abbadi.arstore.address.AddressControllerMapper.toDto;
import static com.abbadi.arstore.address.AddressControllerMapper.toResponse;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
@Validated
@Secured("CUSTOMER")
public class AddressController {

    private final AddressService service;

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable("id") final Long addressId) {
        Long customerId = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        AddressDto dto = service.findByCustomerIdAndAddressId(customerId, addressId);
        return ResponseEntity.ok(toResponse(dto));
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAll() {
        Long customerId = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        List<AddressResponse> responses = service.findAllByCustomerId(customerId)
                .stream()
                .map(AddressControllerMapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    @Validated(value = OnCreate.class)
    public ResponseEntity<AddressResponse> create(@RequestBody @Valid final AddressRequest request) {
        AddressDto dto = service.create(toDto(request));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated(value = OnUpdate.class)
    public ResponseEntity<AddressResponse> update(@RequestBody @Valid final AddressRequest request,
                                                  @PathVariable("id") final Long id) {
        if (!request.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        service.update(toDto(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressResponse> delete(@PathVariable("id") final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

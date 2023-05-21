package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.address.model.AddressRequest;
import com.abbadi.arstore.address.model.AddressResponse;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
@Validated
public class AddressController {

    private final AddressService service;

    private final AddressControllerMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable("id") final Long id) {
        AddressDto dto = service.findById(id);
        return ResponseEntity.ok(mapper.toResponse(dto));
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAll() {
        List<AddressResponse> responses = service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    @Validated(value = OnUpdate.class)
    public ResponseEntity<AddressResponse> update(@RequestBody @Valid final AddressRequest request,
                                                  @PathVariable("id") final Long id) {
        if (!request.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        service.update(mapper.toDto(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AddressResponse> delete(@PathVariable("id") final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

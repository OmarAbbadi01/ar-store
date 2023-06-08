package com.abbadi.arstore.brand;

import com.abbadi.arstore.brand.model.BrandDto;
import com.abbadi.arstore.brand.model.BrandRequest;
import com.abbadi.arstore.brand.model.BrandResponse;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.abbadi.arstore.brand.BrandControllerMapper.toDto;
import static com.abbadi.arstore.brand.BrandControllerMapper.toResponse;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
@Secured({"STORE", "ADMIN"})
public class BrandController {

    private final BrandService service;

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> findById(@PathVariable("id") final Long id) {
        BrandDto dto = service.findById(id);
        return ResponseEntity.ok(toResponse(dto));
    }

    @GetMapping
    public ResponseEntity<List<BrandResponse>> findAll() {
        List<BrandResponse> responses = service.findAll()
                .stream()
                .map(BrandControllerMapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    @Validated(value = OnCreate.class)
    public ResponseEntity<URI> create(@RequestBody @Valid final BrandRequest request) {
        BrandDto dto = service.create(toDto(request));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated(value = OnUpdate.class)
    public ResponseEntity<BrandResponse> update(@RequestBody @Valid final BrandRequest request,
                                      @PathVariable("id") final Long id) {
        if (!request.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        service.update(toDto(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BrandResponse> delete(@PathVariable("id") final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}

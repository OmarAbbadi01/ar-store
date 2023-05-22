package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.glasses.model.GlassesRequest;
import com.abbadi.arstore.item.glasses.model.GlassesResponse;
import com.abbadi.arstore.item.glasses.model.RateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/glasses")
@RequiredArgsConstructor
public class GlassesController {

    private final GlassesService service;

    private final GlassesControllerMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<GlassesResponse> findById(@PathVariable("id") final Long id) {
        GlassesDto dto = service.findById(id);
        return ResponseEntity.ok(mapper.toResponse(dto));
    }

    @GetMapping
    public ResponseEntity<List<GlassesResponse>> findAll() {
        List<GlassesResponse> responses = service.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    @Validated(value = OnCreate.class)
    @Secured("STORE")
    public ResponseEntity<URI> create(@RequestBody @Valid final GlassesRequest request) {
        GlassesDto dto = service.create(mapper.toDto(request));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Validated(value = OnUpdate.class)
    @Secured("STORE")
    public ResponseEntity<GlassesResponse> update(@RequestBody @Valid final GlassesRequest request,
                                                  @PathVariable("id") final Long id) {
        if (!request.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        service.update(mapper.toDto(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Secured({"STORE", "ADMIN"})
    public ResponseEntity<GlassesResponse> delete(@PathVariable("id") final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rate")
    @Secured("CUSTOMER")
    public ResponseEntity<?> rate(@RequestBody @Valid RateRequest request) {
        service.rate(request.getItemId(), request.getRating());
        return ResponseEntity.ok().build();
    }
}

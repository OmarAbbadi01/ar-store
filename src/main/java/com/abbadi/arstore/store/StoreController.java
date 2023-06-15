package com.abbadi.arstore.store;

import com.abbadi.arstore.common.validation.OnUpdate;
import com.abbadi.arstore.store.model.StoreDto;
import com.abbadi.arstore.store.model.StoreRequest;
import com.abbadi.arstore.store.model.StoreResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abbadi.arstore.store.StoreControllerMapper.toDto;
import static com.abbadi.arstore.store.StoreControllerMapper.toResponse;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class StoreController {

    private final StoreService service;

    @GetMapping("me/stores")
    @Secured("STORE")
    public ResponseEntity<StoreResponse> findById() {
        final Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        StoreDto dto = service.findById(id);
        return ResponseEntity.ok(toResponse(dto));
    }

    @GetMapping("/stores")
    public ResponseEntity<List<StoreResponse>> findAll() {
        List<StoreResponse> responses = service.findAll()
                .stream()
                .map(StoreControllerMapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/me/stores")
    @Validated(value = OnUpdate.class)
    @Secured("STORE")
    public ResponseEntity<StoreResponse> update(@RequestBody @Valid final StoreRequest request) {
        service.update(toDto(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/me/stores")
    @Secured("STORE")
    public ResponseEntity<StoreResponse> delete() {
        final Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

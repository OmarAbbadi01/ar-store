package com.abbadi.arstore.store;

import com.abbadi.arstore.common.validation.OnUpdate;
import com.abbadi.arstore.store.model.StoreDto;
import com.abbadi.arstore.store.model.StoreRequest;
import com.abbadi.arstore.store.model.StoreResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.abbadi.arstore.store.StoreControllerMapper.toDto;
import static com.abbadi.arstore.store.StoreControllerMapper.toResponse;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
@Validated
public class StoreController {

    private final StoreService service;

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponse> findById(@PathVariable("id") final Long id) {
        StoreDto dto = service.findById(id);
        return ResponseEntity.ok(toResponse(dto));
    }

    @GetMapping
    public ResponseEntity<List<StoreResponse>> findAll() {
        List<StoreResponse> responses = service.findAll()
                .stream()
                .map(StoreControllerMapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    @Validated(value = OnUpdate.class)
    public ResponseEntity<StoreResponse> update(@RequestBody @Valid final StoreRequest request,
                                                @PathVariable("id") final Long id) {
        if (!request.getId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        service.update(toDto(request));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StoreResponse> delete(@PathVariable("id") final Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

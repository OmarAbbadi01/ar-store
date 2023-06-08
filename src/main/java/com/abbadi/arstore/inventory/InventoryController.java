package com.abbadi.arstore.inventory;

import com.abbadi.arstore.inventory.model.InventoryItemDto;
import com.abbadi.arstore.inventory.model.InventoryItemId;
import com.abbadi.arstore.inventory.model.InventoryItemRequest;
import com.abbadi.arstore.inventory.model.InventoryItemResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.abbadi.arstore.inventory.InventoryControllerMapper.toDto;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Secured("STORE")
public class InventoryController {

    private final InventoryService service;

    @GetMapping
    public ResponseEntity<List<InventoryItemResponse>> findAllItems() {
        Long storeId = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        List<InventoryItemResponse> responses = service.findAll(storeId)
                .stream()
                .map(InventoryControllerMapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<InventoryItemResponse> addItem(@RequestBody @Valid final InventoryItemRequest request) {
        InventoryItemDto dto = toDto(request);
        InventoryItemId id = service.create(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<InventoryItemResponse> updateQuantity(@RequestBody @Valid final InventoryItemRequest request) {
        InventoryItemDto dto = toDto(request);
        service.update(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<InventoryItemResponse> deleteItem(@PathVariable("itemId") final Long itemId) {
        Long storeId = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        InventoryItemId id = InventoryItemId.builder()
                .itemId(itemId)
                .storeId(storeId)
                .build();
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

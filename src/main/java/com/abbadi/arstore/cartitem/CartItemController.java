package com.abbadi.arstore.cartitem;

import com.abbadi.arstore.cartitem.model.CartItemDto;
import com.abbadi.arstore.cartitem.model.CartItemId;
import com.abbadi.arstore.cartitem.model.CartItemRequest;
import com.abbadi.arstore.cartitem.model.CartItemResponse;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import com.abbadi.arstore.item.parent.ItemControllerMapper;
import com.abbadi.arstore.item.parent.model.ItemResponse;
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

@RestController
@RequestMapping("/api/cartItems")
@RequiredArgsConstructor
@Secured("CUSTOMER")
public class CartItemController {

    private final CartItemService service;

    private final CartItemControllerMapper mapper;

    @GetMapping
    public ResponseEntity<List<CartItemResponse>> findAllItems() {
        Long customerId = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        List<CartItemResponse> responses = service.findAll(customerId)
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<CartItemResponse> addItem(@RequestBody @Valid final CartItemRequest request) {
        CartItemDto dto = mapper.toDto(request);
        CartItemId id = service.create(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<CartItemResponse> updateQuantity(@RequestBody @Valid final CartItemRequest request) {
        CartItemDto dto = mapper.toDto(request);
        service.update(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<CartItemResponse> deleteItem(@PathVariable("itemId") final Long itemId) {
        Long customerId = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        CartItemId id = CartItemId.builder()
                .itemId(itemId)
                .customerId(customerId)
                .build();
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}

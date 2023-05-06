package com.abbadi.arstore.cartitem;

import com.abbadi.arstore.cartitem.model.CartItemDto;
import com.abbadi.arstore.cartitem.model.CartItemId;
import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.common.exception.ArStoreExceptionMessages;
import com.abbadi.arstore.customer.CustomerRepository;
import com.abbadi.arstore.item.parent.ItemRepository;
import com.abbadi.arstore.item.parent.model.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository repository;

    private final ItemRepository itemRepository;

    private final CustomerRepository customerRepository;

    @Override
    public List<CartItemDto> findAll(Long customerId) {
        return repository.findAllItemsInCart(customerId);
    }

    @Override
    public void delete(CartItemId id) {
        repository.deleteById(id);
    }

    @Override
    public void update(CartItemDto dto) {
        if (!repository.existsById(dto.getId())) {
            throw ArStoreException.builder()
                    .message(ArStoreExceptionMessages.NO_SUCH_ITEM_IN_THE_CART)
                    .params(null)
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        validateCustomer(dto);
        validateItem(dto);
        repository.update(dto);
    }

    @Override
    public void create(CartItemDto dto) {
        if (repository.existsById(dto.getId())) {
            Integer oldQuantity = repository.findById(dto.getId()).getQuantity();
            dto.setQuantity(dto.getQuantity() + oldQuantity);
            repository.update(dto);
        } else {
            validateCustomer(dto);
            validateItem(dto);
            repository.create(dto);
        }
    }

    private void validateCustomer(CartItemDto dto) {
        Long customerId = dto.getId().getCustomerId();
        if (!customerRepository.existsById(customerId)) {
            throw ArStoreException.builder()
                    .message(ArStoreExceptionMessages.ID_NOT_FOUND)
                    .params(Collections.singletonList(customerId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        dto.setCustomerDto(customerRepository.findById(customerId));
    }

    private void validateItem(CartItemDto dto) {
        Long itemId = dto.getId().getItemId();
        if (!itemRepository.existsById(itemId)) {
            throw ArStoreException.builder()
                    .message(ArStoreExceptionMessages.ID_NOT_FOUND)
                    .params(Collections.singletonList(itemId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        dto.setItemDto(itemRepository.findById(itemId));
    }
}

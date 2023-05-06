package com.abbadi.arstore.cartitem;

import com.abbadi.arstore.cartitem.model.CartItem;
import com.abbadi.arstore.cartitem.model.CartItemDto;
import com.abbadi.arstore.cartitem.model.CartItemId;
import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import com.abbadi.arstore.item.parent.ItemRepositoryMapper;
import com.abbadi.arstore.item.parent.model.ItemDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartItemRepositoryImpl extends GenericRepositoryImpl<CartItemId, CartItem, CartItemDto> implements CartItemRepository {

    private final CartItemDao dao;

    private final CartItemRepositoryMapper mapper;


    public CartItemRepositoryImpl(CartItemDao dao, CartItemRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<CartItemDto> findAllItemsInCart(Long customerId) {
        return dao.findAllItemsByCustomerId(customerId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}

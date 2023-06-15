package com.abbadi.arstore.store;

import com.abbadi.arstore.item.parent.ItemRepository;
import com.abbadi.arstore.user.UserRepository;
import com.abbadi.arstore.user.model.UserDto;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.store.model.StoreDto;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl extends GenericServiceImpl<Long, StoreDto> implements StoreService {

    private final StoreRepository repository;

    private final UserRepository userRepository;

    private final ItemRepository itemRepository;

    public StoreServiceImpl(StoreRepository repository, UserRepository userRepository, ItemRepository itemRepository) {
        super(repository);
        this.repository = repository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    protected StoreDto beforeUpdate(StoreDto dto) {
        UserDto userDto = userRepository.findById(dto.getId());
        dto.setUserDto(userDto);
        return dto;
    }

    @Override
    protected void beforeDelete(Long id) {
        itemRepository.deleteAllByStoreId(id);
    }
}

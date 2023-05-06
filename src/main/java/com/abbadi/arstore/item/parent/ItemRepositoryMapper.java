package com.abbadi.arstore.item.parent;

import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.item.glasses.GlassesRepositoryMapper;
import com.abbadi.arstore.item.glasses.model.Glasses;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.parent.model.Item;
import com.abbadi.arstore.item.parent.model.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemRepositoryMapper extends GenericRepositoryMapper<Long, Item, ItemDto> {

    private final GlassesRepositoryMapper mapper;

    @Override
    public ItemDto mapToDto(Item entity) {
        return entity instanceof Glasses ? mapper.toDto((Glasses) entity) : null;
    }

    @Override
    public Item mapToEntity(ItemDto dto) {
        return dto instanceof GlassesDto ? mapper.toEntity((GlassesDto) dto) : null;
    }
}

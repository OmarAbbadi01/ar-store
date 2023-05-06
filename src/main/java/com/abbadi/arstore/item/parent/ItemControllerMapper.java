package com.abbadi.arstore.item.parent;

import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import com.abbadi.arstore.item.glasses.GlassesControllerMapper;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.glasses.model.GlassesRequest;
import com.abbadi.arstore.item.parent.model.ItemDto;
import com.abbadi.arstore.item.parent.model.ItemRequest;
import com.abbadi.arstore.item.parent.model.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemControllerMapper extends GenericControllerMapper<Long, ItemDto, ItemRequest, ItemResponse> {

    private final GlassesControllerMapper glassesMapper;

    @Override
    public ItemDto mapToDto(ItemRequest request) {
        return request instanceof GlassesRequest ? glassesMapper.toDto((GlassesRequest) request) : null;
    }

    @Override
    public ItemResponse mapToResponse(ItemDto dto) {
        return dto instanceof GlassesDto ? glassesMapper.toResponse((GlassesDto) dto) : null;
    }
}

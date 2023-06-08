package com.abbadi.arstore.item.parent;

import com.abbadi.arstore.item.glasses.GlassesControllerMapper;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.parent.model.ItemDto;
import com.abbadi.arstore.item.parent.model.ItemResponse;

public class ItemControllerMapper {

    public static ItemResponse toResponse(ItemDto dto) {
        return dto instanceof GlassesDto ? GlassesControllerMapper.toResponse((GlassesDto) dto) : null;
    }
}

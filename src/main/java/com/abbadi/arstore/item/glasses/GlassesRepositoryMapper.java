package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.item.glasses.model.Glasses;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import org.springframework.stereotype.Component;

@Component
public class GlassesRepositoryMapper implements GenericRepositoryMapper<Long, Glasses, GlassesDto> {

    @Override
    public GlassesDto toDto(Glasses entity) {
        return GlassesDto.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .store(entity.getStore())
                .brand(entity.getBrand())
                .model(entity.getModel())
                .color(entity.getColor())
                .type(entity.getType())
                .gender(entity.getGender())
                .price(entity.getPrice())
                .border(entity.getBorder())
                .shape(entity.getShape())
                .build();
    }

    @Override
    public Glasses toEntity(GlassesDto dto) {
        return Glasses.glassesBuilder()
                .id(dto.getId())
                .description(dto.getDescription())
                .store(dto.getStore())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .color(dto.getColor())
                .type(dto.getType())
                .gender(dto.getGender())
                .price(dto.getPrice())
                .border(dto.getBorder())
                .shape(dto.getShape())
                .build();
    }
}

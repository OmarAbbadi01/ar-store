package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.brand.BrandRepositoryMapper;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.item.glasses.model.Glasses;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.photo.PhotoRepositoryMapper;
import com.abbadi.arstore.store.StoreRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GlassesRepositoryMapper extends GenericRepositoryMapper<Long, Glasses, GlassesDto> {

    private final StoreRepositoryMapper storeRepositoryMapper;

    private final BrandRepositoryMapper brandRepositoryMapper;

    private final PhotoRepositoryMapper photoRepositoryMapper;

    @Override
    public GlassesDto mapToDto(Glasses entity) {
        return GlassesDto.glassesDtoBuilder()
                .id(entity.getId())
                .description(entity.getDescription())
                .storeDto(storeRepositoryMapper.toDto(entity.getStore()))
                .storeId(entity.getStore().getId())
                .brandDto(brandRepositoryMapper.toDto(entity.getBrand()))
                .brandId(entity.getBrand().getId())
                .model(entity.getModel())
                .color(entity.getColor())
                .type(entity.getType())
                .gender(entity.getGender())
                .price(entity.getPrice())
                .rating(entity.getRating())
                .numberOfVotes(entity.getNumberOfVotes())
                .border(entity.getBorder())
                .shape(entity.getShape())
                .photosDtos(entity.getPhotos() != null ? entity.getPhotos()
                        .stream()
                        .map(photoRepositoryMapper::toDto)
                        .toList() : null)
                .build();
    }

    @Override
    public Glasses mapToEntity(GlassesDto dto) {
        return Glasses.glassesBuilder()
                .id(dto.getId())
                .description(dto.getDescription())
                .store(storeRepositoryMapper.toEntity(dto.getStoreDto()))
                .brand(brandRepositoryMapper.toEntity(dto.getBrandDto()))
                .model(dto.getModel())
                .color(dto.getColor())
                .type(dto.getType())
                .gender(dto.getGender())
                .price(dto.getPrice())
                .rating(dto.getRating())
                .numberOfVotes(dto.getNumberOfVotes())
                .border(dto.getBorder())
                .shape(dto.getShape())
                .photos(dto.getPhotosDtos() != null ? dto.getPhotosDtos()
                        .stream()
                        .map(photoRepositoryMapper::toEntity)
                        .toList() : null)
                .build();
    }
}

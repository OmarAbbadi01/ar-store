package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import com.abbadi.arstore.item.glasses.model.Glasses;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import org.springframework.stereotype.Repository;

@Repository
public class GlassesRepositoryImpl extends GenericRepositoryImpl<Long, Glasses, GlassesDto> implements GlassesRepository {

    private final GlassesDao dao;

    private final GlassesRepositoryMapper mapper;

    public GlassesRepositoryImpl(GlassesDao dao, GlassesRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }
}

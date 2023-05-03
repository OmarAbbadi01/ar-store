package com.abbadi.arstore.brand;

import com.abbadi.arstore.brand.model.Brand;
import com.abbadi.arstore.brand.model.BrandDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class BrandRepositoryImpl extends GenericRepositoryImpl<Long, Brand, BrandDto> implements BrandRepository {

    private final BrandDao dao;

    private final BrandRepositoryMapper mapper;

    public BrandRepositoryImpl(BrandDao dao, BrandRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }
}

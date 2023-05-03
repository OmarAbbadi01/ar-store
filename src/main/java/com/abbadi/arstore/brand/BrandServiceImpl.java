package com.abbadi.arstore.brand;

import com.abbadi.arstore.brand.model.Brand;
import com.abbadi.arstore.brand.model.BrandDto;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends GenericServiceImpl<Long, BrandDto, Brand> implements BrandService {

    private final BrandRepository repository;

    private final BrandRepositoryMapper mapper;

    public BrandServiceImpl(BrandRepository repository, BrandRepositoryMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}

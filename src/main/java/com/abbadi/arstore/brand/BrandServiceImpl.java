package com.abbadi.arstore.brand;

import com.abbadi.arstore.brand.model.BrandDto;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends GenericServiceImpl<Long, BrandDto> implements BrandService {

    private final BrandRepository repository;

    public BrandServiceImpl(BrandRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

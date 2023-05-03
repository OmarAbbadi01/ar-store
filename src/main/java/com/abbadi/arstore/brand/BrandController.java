package com.abbadi.arstore.brand;

import com.abbadi.arstore.brand.model.BrandDto;
import com.abbadi.arstore.brand.model.BrandRequest;
import com.abbadi.arstore.brand.model.BrandResponse;
import com.abbadi.arstore.common.generic.service.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/brands")
public class BrandController extends GenericController<Long, BrandDto, BrandRequest, BrandResponse> {

    private final BrandService service;

    private final BrandControllerMapper mapper;

    public BrandController(BrandService service, BrandControllerMapper mapper) {
        super(service, mapper);
        this.service = service;
        this.mapper = mapper;
    }
}

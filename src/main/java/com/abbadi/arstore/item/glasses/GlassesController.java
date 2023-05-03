package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.generic.service.GenericController;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.glasses.model.GlassesRequest;
import com.abbadi.arstore.item.glasses.model.GlassesResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/glasses")
public class GlassesController extends GenericController<Long, GlassesDto, GlassesRequest, GlassesResponse> {

    private final GlassesService service;

    private final GlassesControllerMapper mapper;

    public GlassesController(GlassesService service, GlassesControllerMapper mapper) {
        super(service, mapper);
        this.service = service;
        this.mapper = mapper;
    }
}

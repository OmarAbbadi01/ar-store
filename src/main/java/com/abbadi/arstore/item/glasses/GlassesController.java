package com.abbadi.arstore.item.glasses;

import com.abbadi.arstore.common.generic.service.GenericController;
import com.abbadi.arstore.item.glasses.model.GlassesDto;
import com.abbadi.arstore.item.glasses.model.GlassesRequest;
import com.abbadi.arstore.item.glasses.model.GlassesResponse;
import com.abbadi.arstore.item.glasses.model.RateRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Secured("CUSTOMER")
    @PostMapping("/rate")
    public ResponseEntity<?> rate(@RequestBody @Valid RateRequest request) {
        service.rate(request.getItemId(), request.getRating());
        return ResponseEntity.ok().build();
    }
}

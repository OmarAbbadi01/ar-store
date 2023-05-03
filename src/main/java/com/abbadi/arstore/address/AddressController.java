package com.abbadi.arstore.address;

import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.address.model.AddressRequest;
import com.abbadi.arstore.address.model.AddressResponse;
import com.abbadi.arstore.common.generic.service.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/addresses")
public class AddressController extends GenericController<Long, AddressDto, AddressRequest, AddressResponse> {

    private final AddressService service;

    private final AddressControllerMapper mapper;

    public AddressController(AddressService service, AddressControllerMapper mapper) {
        super(service, mapper);
        this.service = service;
        this.mapper = mapper;
    }
}

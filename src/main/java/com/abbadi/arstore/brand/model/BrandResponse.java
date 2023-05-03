package com.abbadi.arstore.brand.model;

import com.abbadi.arstore.common.generic.model.GenericResponse;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BrandResponse implements GenericResponse<Long> {

    Long id;

    String name;

    String countryOfOrigin;

}

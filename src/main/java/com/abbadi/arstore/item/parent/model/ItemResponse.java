package com.abbadi.arstore.item.parent.model;

import com.abbadi.arstore.brand.model.BrandResponse;
import com.abbadi.arstore.common.generic.model.GenericResponse;
import com.abbadi.arstore.store.model.StoreResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ItemResponse implements GenericResponse<Long> {

    protected final Long id;

    protected final String description;

    protected final Double price;

    protected final StoreResponse storeResponse;

    protected final BrandResponse brandResponse;
}

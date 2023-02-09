package com.es.innoit.prices.pricesrest.infrastructure.mapper;

import com.es.innoit.prices.pricesrest.infrastructure.adapters.persistence.entities.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    public com.es.innoit.prices.pricesrest.domain.models.Price toPriceDomain(Price price);

}

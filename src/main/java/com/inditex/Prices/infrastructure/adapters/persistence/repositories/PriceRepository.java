package com.es.innoit.prices.pricesrest.infrastructure.adapters.persistence.repositories;

import com.es.innoit.prices.pricesrest.infrastructure.adapters.persistence.crud.PriceCrudRepository;
import com.es.innoit.prices.pricesrest.infrastructure.mapper.PriceMapper;
import com.es.innoit.prices.pricesrest.domain.models.Price;
import com.es.innoit.prices.pricesrest.domain.repositories.IPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class PriceRepository implements IPriceRepository {

    @Autowired
    private PriceCrudRepository crudRepository;

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public Optional<Price> getProductByDate(LocalDateTime applicationDate, Long productId, Short  brandId) {
        return Optional.of(
                this.crudRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                        brandId, productId, applicationDate, applicationDate)
                ).map(prices -> prices.size()>0? priceMapper.toPriceDomain(prices.get(0)): null);
    }
}

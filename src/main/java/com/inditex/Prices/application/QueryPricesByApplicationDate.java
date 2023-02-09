package com.es.innoit.prices.pricesrest.application;

import com.es.innoit.prices.pricesrest.domain.models.Price;
import com.es.innoit.prices.pricesrest.domain.repositories.IPriceRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@NoArgsConstructor
@Service
public class QueryPricesByApplicationDate {

    @Autowired
    private IPriceRepository priceRepository;

    public Optional<Price> handle(LocalDateTime applicationDate, Long productId, Short brandId) {
        return this.priceRepository.getProductByDate(applicationDate, productId, brandId);
    }
}

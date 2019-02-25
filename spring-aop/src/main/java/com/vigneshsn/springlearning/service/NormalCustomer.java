package com.vigneshsn.springlearning.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Qualifier("main")
public class NormalCustomer implements CustomerService {
    @Override
    public BigDecimal calculatePrice(BigDecimal originalPrice) {
        return originalPrice.add(BigDecimal.valueOf(100L));
    }
}

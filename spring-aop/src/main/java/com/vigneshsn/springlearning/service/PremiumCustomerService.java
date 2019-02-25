package com.vigneshsn.springlearning.service;

import com.vigneshsn.springlearning.aop.Gst;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PremiumCustomerService implements CustomerService {
    @Gst
    @Override
    public BigDecimal calculatePrice(BigDecimal originalPrice) {
        return originalPrice.subtract(BigDecimal.valueOf(100L));
    }
}

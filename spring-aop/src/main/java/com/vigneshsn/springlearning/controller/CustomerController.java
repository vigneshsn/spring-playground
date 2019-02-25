package com.vigneshsn.springlearning.controller;

import com.vigneshsn.springlearning.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class CustomerController {

    @Resource(name="normalCustomer")
    CustomerService customerService;

//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }

    @GetMapping("/price")
    public BigDecimal calculatePrice(@RequestParam int originalPrice) {
        return customerService.calculatePrice(BigDecimal.valueOf(originalPrice));
    }

    @GetMapping("/test-ex")
    public void testException() {
        throw new RuntimeException("some exception message");
    }
}

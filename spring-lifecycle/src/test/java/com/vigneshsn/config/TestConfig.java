package com.vigneshsn.config;

import com.vigneshsn.InstantiationTracingBeanPostProcessor;
import com.vigneshsn.products.ProductController;
import com.vigneshsn.products.ProductService;
import com.vigneshsn.products.ProductServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TestConfig {

    @Bean
    public ProductController productController() {
        return new ProductController(productServiceFactory("flipkart"));
    }

    @Bean
    public ProductService productServiceFactory(String type) {
        return ProductServiceFactory.getProductService(type);
    }

    @Bean
    public InstantiationTracingBeanPostProcessor instantiationTracingBeanPostProcessor() {
        return new InstantiationTracingBeanPostProcessor();
    }
}

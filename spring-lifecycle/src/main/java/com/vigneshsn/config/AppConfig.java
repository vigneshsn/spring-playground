package com.vigneshsn.config;

import com.vigneshsn.products.ProductService;
import com.vigneshsn.products.ProductServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.vigneshsn")
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public ProductService productService() {
        return ProductServiceFactory.getProductService("flipkart");
    }
}
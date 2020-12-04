package com.kzmpekos.productsservice;

import com.kzmpekos.productsservice.ApplicationLayer.services.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @Bean
    ProductServiceImpl productService(){return new ProductServiceImpl();}
}

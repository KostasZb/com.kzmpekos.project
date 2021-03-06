package com.kzmpekos.commissionservice;

import com.kzmpekos.commissionservice.ApplicationLayer.services.CommissionServiceImpl;
import com.kzmpekos.commissionservice.ApplicationLayer.services.ProductsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @Bean
    CommissionServiceImpl commissionService(){return new CommissionServiceImpl();}
    @Bean
    ProductsService productsService(){return new ProductsService();}
}

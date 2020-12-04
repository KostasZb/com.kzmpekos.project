package com.kzmpekos.addressservice;

import com.kzmpekos.addressservice.ApplicationLayer.services.AddressServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @Bean
    AddressServiceImpl addressService() {
        return new AddressServiceImpl();
    }
    
}

package com.kzmpekos.postcodesdistancecalculatorservice;


import com.kzmpekos.postcodesdistancecalculatorservice.ApplicationLayer.services.DistanceCalculatorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @Bean
    DistanceCalculatorServiceImpl distanceCalculatorService(){return new DistanceCalculatorServiceImpl();}
}

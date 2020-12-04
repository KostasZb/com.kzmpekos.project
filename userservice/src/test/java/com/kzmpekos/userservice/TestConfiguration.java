package com.kzmpekos.userservice;

import com.kzmpekos.userservice.ApplicationLayer.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @Bean
    UserServiceImpl userService(){return new UserServiceImpl();}
}

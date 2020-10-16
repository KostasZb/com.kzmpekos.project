package com.kzmpekos.commissionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CommissionserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommissionserviceApplication.class, args);
    }

}

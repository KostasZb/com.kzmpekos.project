package com.kzmpekos.productsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProductsserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsserviceApplication.class, args);
    }

}

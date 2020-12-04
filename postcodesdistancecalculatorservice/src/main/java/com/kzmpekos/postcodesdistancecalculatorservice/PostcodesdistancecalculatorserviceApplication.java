package com.kzmpekos.postcodesdistancecalculatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EntityScan("com/kzmpekos/postcodesdistancecalculatorservice/DomainLayer/entities")
@SpringBootApplication
public class PostcodesdistancecalculatorserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostcodesdistancecalculatorserviceApplication.class, args);
    }

}

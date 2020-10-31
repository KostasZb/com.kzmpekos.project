package com.example.demo.controllers;

import com.example.demo.models.NewUserWithAddress;
import com.example.demo.services.AddressService;
import com.example.demo.services.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.proto.address.addressDetails;
import com.proto.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableCircuitBreaker
@RequestMapping("/signup")
public class SingUpController {

    @Autowired
    private UserService userservice;
    @Autowired
    private AddressService addressService;

    @GetMapping
    public String getSignUp() {
        return "signUp/signup";
    }

    //Setting a fallback method in case the circuit breaker is open, REFERENCE: https://spring.io/guides/gs/circuit-breaker/, https://www.tutorialspoint.com/spring_boot/spring_boot_hystrix.htm
    @HystrixCommand(fallbackMethod = "somethingWentWrong", commandProperties =
            {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    @PostMapping(value = {"/adduser"})
    public String adduser(NewUserWithAddress userWithDetails) {
        addressDetails details=addressDetails.newBuilder().
                setAddress(userWithDetails.getAddress()).
                setCity(userWithDetails.getCity()).
                setPostcode(userWithDetails.getPostcode()).build();

        int addressId=addressService.addAddress(details);
        User user=User.newBuilder().
                setEmail(userWithDetails.getEmail()).
                setName(userWithDetails.getName()).
                setPassword(userWithDetails.getPassword()).
                setIsFarmer(userWithDetails.isFarmer()).
                setAddressId(addressId).build();

        userservice.signUpUser(user);

        return "login/login";
    }
    public String somethingWentWrong(NewUserWithAddress userWithAddress){
        return "somethingWrong/somethingWrong";
    }

}

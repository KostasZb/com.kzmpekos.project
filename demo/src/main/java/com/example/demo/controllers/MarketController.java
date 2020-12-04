package com.example.demo.controllers;

import com.example.demo.security.UserDetailsImpl;
import com.example.demo.services.CommissionService;
import com.example.demo.services.DistanceCalculatorService;
import com.example.demo.services.ProductsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.proto.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/market")
public class MarketController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private CommissionService commissionService;
    @Autowired
    private DistanceCalculatorService distanceCalculatorService;

    //Setting a fallback method in case the circuit breaker is open, REFERENCE: https://spring.io/guides/gs/circuit-breaker/, https://www.tutorialspoint.com/spring_boot/spring_boot_hystrix.htm
    @HystrixCommand(fallbackMethod = "getProductsFallback", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
    @GetMapping(value = {""})
    public String getProducts(Model model) {
        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principal.getUserId();
        List products = distanceCalculatorService.getListWithDistance(userId);
        model.addAttribute("products", products);
        return "market/productslist";
    }

    //Setting a fallback method in case the circuit breaker is open, REFERENCE: https://spring.io/guides/gs/circuit-breaker/, https://www.tutorialspoint.com/spring_boot/spring_boot_hystrix.htm
    @HystrixCommand(fallbackMethod = "orderProductFallback", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100000")})
    @PostMapping(value = {"/order"})
    @ResponseBody
    public String orderProduct(String productId) {

        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int prodId = Integer.parseInt(productId);
        int userId = principal.getUserId();
        Product product = productsService.retrieveProduct(prodId);
        float totalPrice = product.getPricePerUnit() * product.getQuantity();
        String data = commissionService.addCommission(prodId, userId, totalPrice);
        productsService.deleteProductById(prodId);
        return data;
    }

    public String getProductsFallback(Model model) {
        return "somethingWrong/somethingWrong";
    }

    public String orderProductFallback(String productId) {
        return "Something went wrong, please try again";
    }

}

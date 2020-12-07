package com.example.demo.controllers;

import com.example.demo.models.NewProduct;
import com.example.demo.models.OrderWithDetails;
import com.example.demo.models.ProductChange;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.services.AddressService;
import com.example.demo.services.CommissionService;
import com.example.demo.services.ProductsService;
import com.example.demo.services.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.proto.address.addressDetails;
import com.proto.commissions.CommissionWithDetails;
import com.proto.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/farmerhome")
public class FarmerHomeController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private CommissionService commissionService;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    //Setting a fallback method in case the circuit breaker is open, REFERENCE: https://spring.io/guides/gs/circuit-breaker/, https://www.tutorialspoint.com/spring_boot/spring_boot_hystrix.htm
    @HystrixCommand(fallbackMethod = "getOwnProductsFallback", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
    @GetMapping("")
    public String getOwnProducts(Model model) {
        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id = principal.getUserId();
        model.addAttribute("products", productsService.getProductsByFarmerId(id));
        return "farmerHome/products";
    }

    //Setting a fallback method in case the circuit breaker is open, REFERENCE: https://spring.io/guides/gs/circuit-breaker/, https://www.tutorialspoint.com/spring_boot/spring_boot_hystrix.htm
    @HystrixCommand(fallbackMethod = "updateProductFallback", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
    @PostMapping("/changeProduct")
    public String updateProduct(ProductChange productChange) {

        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principal.getUserId();
        Product product = Product.newBuilder()
                .setFarmerId(userId)
                .setProductId(productChange.getProductId())
                .setPricePerUnit(productChange.getPricePerUnit())
                .setQuantity(productChange.getQuantity())
                .build();

        if (product.getQuantity() == 0) {
            productsService.deleteProductById(product.getProductId());
        } else {
            productsService.updateProduct(product);
        }
        return "farmerHome/update";
    }


    @GetMapping("/orders")
    //Setting a fallback method in case the circuit breaker is open, REFERENCE: https://spring.io/guides/gs/circuit-breaker/, https://www.tutorialspoint.com/spring_boot/spring_boot_hystrix.htm
    @HystrixCommand(fallbackMethod = "ordersFallback", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
    public String getOrders(Model model) {
        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id = principal.getUserId();
        List<CommissionWithDetails> commissions = commissionService.getCommissions(id);
        ArrayList<OrderWithDetails> orderWithDetailsArrayList = new ArrayList<>();

        for (CommissionWithDetails commission : commissions
        ) {
            OrderWithDetails orderWithDetails = new OrderWithDetails();
            orderWithDetails.setTotalPrice(commission.getTotalPrice());
            orderWithDetails.setName(commission.getProductName());
            orderWithDetails.setQuantity(commission.getQuantity());
            orderWithDetails.setUserId(commission.getUserId());
            orderWithDetailsArrayList.add(orderWithDetails);
        }
        model.addAttribute("orders", orderWithDetailsArrayList);
        return "farmerHome/orders";
    }

    @PostMapping("/addressDetails")
    @ResponseBody
    public String seeAddressDetails(String userId) {
        int id = Integer.parseInt(userId);
        int addressId = userService.getUserWithId(id).getAddressId();
        addressDetails address = addressService.getAddress(addressId);
        String details = address.getAddress() + "," + address.getCity() + "," + address.getPostcode();
        return details;
    }

    @GetMapping("/addProduct")
    public String addProduct() {
        return "farmerHome/addProduct";
    }

    //Setting a fallback method in case the circuit breaker is open, REFERENCE: https://spring.io/guides/gs/circuit-breaker/, https://www.tutorialspoint.com/spring_boot/spring_boot_hystrix.htm
    @HystrixCommand(fallbackMethod = "addNewProductFallback", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000")})
    @PostMapping("/farmerhome/addNewProduct")
    public String addNewProduct(NewProduct product) {
        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principal.getUserId();
        product.setFarmerId(userId);
        productsService.addProduct(product);
        return "farmerHome/productAdded";
    }

    public String addNewProductFallback(NewProduct product) {
        return "somethingWrong/somethingWrong";
    }

    public String updateProductFallback(ProductChange productChange) {
        return "somethingWrong/somethingWrong";
    }

    public String getOwnProductsFallback(Model model) {
        return "somethingWrong/somethingWrong";
    }

    public String ordersFallback() {
        return "somethingWrong/somethingWrong";
    }
}

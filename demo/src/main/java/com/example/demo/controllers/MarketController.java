package com.example.demo.controllers;

import com.example.demo.security.UserDetailsImpl;
import com.example.demo.services.CommissionService;
import com.example.demo.services.DistanceCalculatorService;
import com.example.demo.services.ProductsService;
import com.proto.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
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

    @GetMapping(value = {""})
    public String getProducts(Model model) {
        UserDetailsImpl principal= (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId=principal.getUserId();
        List products=distanceCalculatorService.getListwithDistance(userId);
        model.addAttribute("products", distanceCalculatorService.getListwithDistance(userId));
        return "market/productslist";
    }

    @PostMapping(value = {"/order"})
    @ResponseBody
    public String orderProduct(String productId) {

        UserDetailsImpl principal= (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int prodId=Integer.parseInt(productId);
        int userId=principal.getUserId();
        Product product=productsService.deleteProductById(prodId);
        float totalPrice=product.getPricePerUnit()*product.getQuantity();
        String data=commissionService.addCommission(prodId,userId,totalPrice);
        return data;
    }

    @PostMapping(value = {"/distance"})
    @ResponseBody
    public String calculateDistance(int productId){
        return "";
    }

}

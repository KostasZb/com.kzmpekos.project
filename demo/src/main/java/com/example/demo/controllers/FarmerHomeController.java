package com.example.demo.controllers;

import com.example.demo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/farmerhome")
public class FarmerHomeController {
    @Autowired
    private ProductsService productsService;
    @GetMapping("")
    public String getOwnProducts(Model model){
        int id=1;
        model.addAttribute(productsService.getProductsByFarmerId(id));
        return "farmerHome/products";
    }
}

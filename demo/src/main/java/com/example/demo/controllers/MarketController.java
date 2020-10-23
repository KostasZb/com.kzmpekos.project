package com.example.demo.controllers;

import com.example.demo.services.CommissionService;
import com.example.demo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/market")
public class MarketController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private CommissionService commissionService;

    @GetMapping(value = {""})
    public String getProducts(Model model) {
        model.addAttribute("products", productsService.getProducts());
        return "market/productslist";
    }

    @PostMapping(value = {"/order"})
    public String orderProduct(int id) {

        /*TODO add the id and userid in method*/
        commissionService.addCommission();
        return "";
    }

}

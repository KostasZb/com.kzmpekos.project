package com.example.demo.controllers;

import com.example.demo.models.NewProduct;
import com.example.demo.models.ProductChange;
import com.example.demo.security.UserDetailsImpl;
import com.example.demo.services.ProductsService;
import com.proto.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/farmerhome")
public class FarmerHomeController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("")
    public String getOwnProducts(Model model) {
        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id = principal.getUserId();
        model.addAttribute("products", productsService.getProductsByFarmerId(id));
        return "farmerHome/products";
    }

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

    @GetMapping("/addProduct")
    public String addProduct(){
        return "farmerHome/addProduct";
    }

    @PostMapping("/farmerhome/addNewProduct")
    public String addNewProduct(NewProduct product){
        UserDetailsImpl principal = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userId = principal.getUserId();
        product.setFarmerId(userId);
        productsService.addProduct(product);
        return "farmerHome/productAdded";
    }
}

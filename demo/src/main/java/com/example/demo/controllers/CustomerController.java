package com.example.demo.controllers;

import com.example.demo.services.AddressService;
import com.example.demo.services.CustomerService;
import com.example.demo.services.ProductsService;
import com.example.demo.viewmodels.CustomerHomeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private AddressService service;

    private final String pageFolder = "customer/";
    private CustomerService customerService;

    public CustomerController() {
        customerService = new CustomerService();
    }

    @GetMapping(value = {"", "/", "/home", "/index"})
    public ModelAndView home() {
        CustomerHomeViewModel viewModel = new CustomerHomeViewModel(customerService.getCustomers());
        ModelAndView customerHome = createModelAndView(pageFolder + "home", "home_customer", viewModel);

        //AddressService service=new AddressService();
        service.getAddress(2);

        return customerHome;
    }

    private ModelAndView createModelAndView(String viewName, String objectName, Object t) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(viewName);
        mav.addObject(objectName, t);
        return mav;
    }
}

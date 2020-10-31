package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers;

    public CustomerService() {
        initialize();
    }
    private void initialize() {
        customers=new ArrayList<Customer>();
        customers.add(new Customer(1,"Nick","Johnson","nickJohnson@aaa.com","077777777",23,false));
    }
    public List<Customer> getCustomers(){
        return customers;
    }
}

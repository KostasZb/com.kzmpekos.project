package com.example.demo.viewmodels;

import java.util.ArrayList;
import java.util.List;

public class CustomerHomeViewModel extends BaseViewModel{

    private List<Customer> customers;

    public CustomerHomeViewModel() {
        this(new ArrayList<Customer>());
    }

    public CustomerHomeViewModel(List<Customer> customers) {
        super("Customers","Customer Home Page");
        setCustomers(customers);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

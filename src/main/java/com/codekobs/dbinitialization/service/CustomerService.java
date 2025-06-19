package com.codekobs.dbinitialization.service;

import com.codekobs.dbinitialization.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
    // Read operation
    List<Customer> fetchCustomerList();
    // Update operation
    Customer updateCustomer(Customer customer,
                                Long customerId);

    Customer findCustomerById(Long customerId);
    // Delete operation
    void deleteCustomerById(Long customerId);
}

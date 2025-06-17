package com.codekobs.dbinitialization.service;

import com.codekobs.dbinitialization.entity.Customer;
import com.codekobs.dbinitialization.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepositoryRepository;
    @Override
    public Customer saveCustomer(Customer customer) {

        return customerRepositoryRepository.save(customer);
    }

    @Override
    public List<Customer> fetchCustomerList() {
        return (List<Customer>) customerRepositoryRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Customer customer, Long customerId) {
        Customer customerRecord
                = customerRepositoryRepository.findById(customerId)
                .get();
        return customerRepositoryRepository.save(customerRecord);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepositoryRepository.deleteById(customerId);

    }
}

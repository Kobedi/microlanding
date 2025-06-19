package com.codekobs.dbinitialization.controller;

import com.codekobs.dbinitialization.entity.Customer;
import com.codekobs.dbinitialization.entity.CustomerLoanApplication;
import com.codekobs.dbinitialization.model.CustomerLoanApplicationModel;
import com.codekobs.dbinitialization.service.CustomerLoanApplicationService;
import com.codekobs.dbinitialization.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LoanController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerLoanApplicationService customerLoanApplicationService;

    @PostMapping("/customers")
    public Customer saveCustomer(@RequestBody Customer customer)
    {
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/loans")
    public CustomerLoanApplication saveCustomerLoanApplication(@RequestBody CustomerLoanApplicationModel customerLoanApplicationModel)
    {
        return customerLoanApplicationService.saveCustomerLoanApplication(
                customerLoanApplicationModel);
    }

    @GetMapping("/customers/{customerId}")
    public Customer findCustomer(@PathVariable long customerId)
    {
        return customerService.findCustomerById(customerId);
    }

    @GetMapping("/customers")
    public List<Customer> listCustomers()
    {
        return customerService.fetchCustomerList();
    }

    @GetMapping("/loans")
    public List<CustomerLoanApplication> listCustomerLoanApplications()
    {
        return customerLoanApplicationService
                .fetchCustomerLoanApplicationList();
    }

    @GetMapping("/loans/{loanId}")
    public CustomerLoanApplication findCustomerLoanApplications(@PathVariable long loanId)
    {
         Optional<CustomerLoanApplication> foundLoan =  customerLoanApplicationService
                .findCustomerLoanApplicationById(loanId);
         return foundLoan.get();
    }

}

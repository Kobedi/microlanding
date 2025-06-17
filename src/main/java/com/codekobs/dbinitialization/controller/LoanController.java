package com.codekobs.dbinitialization.controller;

import com.codekobs.dbinitialization.entity.Customer;
import com.codekobs.dbinitialization.entity.CustomerLoanApplication;
import com.codekobs.dbinitialization.model.CustomerLoanApplicationModel;
import com.codekobs.dbinitialization.service.CustomerLoanApplicationService;
import com.codekobs.dbinitialization.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}

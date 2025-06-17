package com.codekobs.dbinitialization.service;

import com.codekobs.dbinitialization.entity.CustomerLoanApplication;
import com.codekobs.dbinitialization.model.CustomerLoanApplicationModel;

import java.util.List;
import java.util.Optional;

public interface CustomerLoanApplicationService {

    CustomerLoanApplication saveCustomerLoanApplication(CustomerLoanApplication customerLoanApplication);

    CustomerLoanApplication saveCustomerLoanApplication(CustomerLoanApplicationModel customerLoanApplicationModel);
    // Read operation
    List<CustomerLoanApplication> fetchCustomerLoanApplicationList();
    // Update operation
    CustomerLoanApplication updateCustomerLoanApplication(CustomerLoanApplication customerLoanApplication,
                            Long customerIdLoanApplicationId);

    Optional<CustomerLoanApplication> findCustomerLoanApplicationById (Long customerIdLoanApplicationId);
    // Delete operation
    void deleteCustomerLoanApplicationById(Long customerLoanApplicationId);
}

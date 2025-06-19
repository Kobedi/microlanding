package com.codekobs.dbinitialization.service;

import com.codekobs.dbinitialization.entity.Customer;
import com.codekobs.dbinitialization.entity.CustomerLoanApplication;
import com.codekobs.dbinitialization.model.CustomerLoanApplicationModel;
import com.codekobs.dbinitialization.model.CustomerModel;
import com.codekobs.dbinitialization.model.LoanModel;
import com.codekobs.dbinitialization.payment.service.LoanPaymentHistoryServiceImpl;
import com.codekobs.dbinitialization.repository.CustomerLoanApplicationRepository;
import com.codekobs.dbinitialization.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerLoanApplicationServiceImpl implements CustomerLoanApplicationService{

    Date date = new Date();
    Timestamp ts = new Timestamp(date.getTime());

    public enum LoanStatus
    {
        ACTIVE,SETTLED
    }

    @Autowired
    private CustomerLoanApplicationRepository customerLoanApplicationRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerLoanApplication saveCustomerLoanApplication(CustomerLoanApplication customerLoanApplication) {

        return customerLoanApplicationRepository.save(customerLoanApplication);
    }

    @Override
    public CustomerLoanApplication saveCustomerLoanApplication(CustomerLoanApplicationModel
                                                                           customerLoanApplicationModel) {
        if(customerLoanApplicationModel!=null)
        {
            CustomerModel customerModel = customerLoanApplicationModel.getCustomerModel();
            //build the customer copy to save
            Customer customer  = Customer.builder().name(customerModel.getName()).
                    lastName(customerModel.getLastName()).applicationDate(ts.toString()).build();
            //Now retrieve the customer id and associate with the loan application
            Customer savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getId() != 0)
            {
                LoanModel loanModel = customerLoanApplicationModel.getLoanModel();
                System.out.println("<<<<<<<<<<<< Load >>>>>>>>>>>>> "+ loanModel.toString());
                CustomerLoanApplication customerLoanApplication = CustomerLoanApplication.builder()
                        .loanId(loanModel.getLoanId()).customerId(savedCustomer.getId()).
                        loanAmount(loanModel.getLoanAmount()).
                        latestBalance(loanModel.getLoanAmount()).loanStatus(LoanStatus.ACTIVE.toString()).
                        lastPaymentDate("").build();
                return customerLoanApplicationRepository.save(customerLoanApplication);
            }
        }
        return null;
    }

    @Override
    public List<CustomerLoanApplication> fetchCustomerLoanApplicationList() {
        return (List<CustomerLoanApplication>) customerLoanApplicationRepository.findAll();
    }

    @Override
    public CustomerLoanApplication updateCustomerLoanApplication(CustomerLoanApplication customerLoanApplication, Long customerIdLoanApplicationId) {
        CustomerLoanApplication customerRecord
                = customerLoanApplicationRepository.findById(customerIdLoanApplicationId)
                .get();
        return customerLoanApplicationRepository.save(customerRecord);
    }

    @Override
    public Optional<CustomerLoanApplication> findCustomerLoanApplicationById(Long customerIdLoanApplicationId) {
        return customerLoanApplicationRepository.findById(customerIdLoanApplicationId);
    }


    @Override
    public void deleteCustomerLoanApplicationById(Long customerLoanApplicationId) {

        customerLoanApplicationRepository.deleteById(customerLoanApplicationId);

    }
}

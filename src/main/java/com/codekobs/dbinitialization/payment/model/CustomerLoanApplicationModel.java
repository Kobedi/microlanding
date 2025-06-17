package com.codekobs.dbinitialization.payment.model;



import java.io.Serializable;
import java.util.UUID;

public class CustomerLoanApplicationModel implements Serializable {

    private final String uuid = UUID.randomUUID().toString();
private CustomerModel customerModel;

private LoanModel loanModel;

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public LoanModel getLoanModel() {
        return loanModel;
    }

    public void setLoanModel(LoanModel loanModel) {
        this.loanModel = loanModel;
    }
}

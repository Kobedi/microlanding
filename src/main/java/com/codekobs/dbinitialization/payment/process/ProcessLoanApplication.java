package com.codekobs.dbinitialization.payment.process;

import com.codekobs.dbinitialization.entity.Customer;
import com.codekobs.dbinitialization.entity.CustomerLoanApplication;
import com.codekobs.dbinitialization.model.CustomerLoanApplicationModel;
import com.codekobs.dbinitialization.payment.entity.LoanPaymentHistory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;

@Component
public class ProcessLoanApplication {

    Date date = new Date();
    Timestamp ts = new Timestamp(date.getTime());

    enum LoanStatus {
        SETTLED, ACTIVE
    }


    public CustomerLoanApplication updateLoanApplication(CustomerLoanApplication existingCustomerLoanApplication,
                                                         Double PaymentAmount)
    {
        return processLoanPayment(existingCustomerLoanApplication,
                PaymentAmount);
    }

    public LoanPaymentHistory createPayment(CustomerLoanApplication existingCustomerLoanApplication,
                                                         Double PaymentAmount)
    {
        return createPaymentHistoryRecord(existingCustomerLoanApplication,
                PaymentAmount);
    }

    private CustomerLoanApplication processLoanPayment(CustomerLoanApplication existingLoan, Double paymentAmount)
    {
        Random random = new Random();
        long randomPaymentId = random.nextLong(1000);
        CustomerLoanApplication customerLoanApplication=null;
            if(Objects.equals(existingLoan.getLoanStatus(), LoanStatus.ACTIVE.toString()))
            {//pull the latest balance
                double latestBalance = existingLoan.getLatestBalance();
                //Create a record for payment
                LoanPaymentHistory loanPayment = LoanPaymentHistory.builder().build();
                loanPayment.setId(randomPaymentId);
                loanPayment.setCustomerId(existingLoan.getCustomerId());
                if(paymentAmount==latestBalance)//Money to be paid by Customer will settle the loan
                {//Settle the loan and update loan status to SETTLED
                    loanPayment.setLoanStatus(LoanStatus.SETTLED.toString());
                    loanPayment.setLastUpdated(ts.toString());
                    loanPayment.setPaymentAmount(paymentAmount);
                    //Update customer current loan to reflect latest balance owed minus paid amount
                    existingLoan.setLatestBalance(existingLoan.getLatestBalance() - paymentAmount);
                    existingLoan.setLoanStatus(LoanStatus.SETTLED.toString());
                    existingLoan.setLastPaymentDate(ts.toString());
                    //Create the record in the database
                    customerLoanApplication = existingLoan;
                }
                if(paymentAmount < latestBalance)
                {//Normal flow
                    loanPayment.setLoanStatus(LoanStatus.ACTIVE.toString());
                    loanPayment.setLastUpdated(ts.toString());
                    loanPayment.setPaymentAmount(paymentAmount);
                    //Update customer current loan to reflect latest balance owed minus paid amount
                    existingLoan.setLatestBalance(existingLoan.getLatestBalance() - paymentAmount);
                    existingLoan.setLastPaymentDate(ts.toString());
                    //Create the record in the database
                    customerLoanApplication = existingLoan;
                }
                if(paymentAmount > latestBalance)
                {
                    customerLoanApplication = new CustomerLoanApplication();
                    customerLoanApplication.setLoanStatus("Invalid Payment");
                }
            }
            else {
                customerLoanApplication = new CustomerLoanApplication();
                customerLoanApplication.setLoanStatus("Invalid Search Params");
                return customerLoanApplication;
            }
            return customerLoanApplication;
    }

    private LoanPaymentHistory createPaymentHistoryRecord(CustomerLoanApplication existingLoan,
                                                                      Double paymentAmount) {
        Random random = new Random();
        long randomPaymentId = random.nextLong(1000);
        LoanPaymentHistory loanPayment = LoanPaymentHistory.builder().build();
        loanPayment.setId(randomPaymentId);
        loanPayment.setCustomerId(existingLoan.getCustomerId());
        switch(existingLoan.getLoanStatus())
        {
            case "SETTLED": loanPayment.setLoanStatus(LoanStatus.SETTLED.toString());
            break;
            case "ACTIVE": loanPayment.setLoanStatus(LoanStatus.ACTIVE.toString());
            break;
            default: loanPayment.setLoanStatus("");
        }
        loanPayment.setLastUpdated(ts.toString());
        loanPayment.setPaymentAmount(paymentAmount);
        return loanPayment;
    }

    private CustomerLoanApplication processLoanPayment(Customer soughtCustomer, Long soughtLoanId, Map<Long, CustomerLoanApplication> loans, Double paymentAmount)
    {
        Set<Long> keys = loans.keySet();
        Random random = new Random();
        long randomPaymentId = random.nextLong(1000);
        CustomerLoanApplication customerLoanApplication=null;
        for(Long key: keys)
        {
            customerLoanApplication = loans.get(key);
            if(Objects.equals(customerLoanApplication.getLoanId(), soughtLoanId) &&//For the selected loan to be paid by the unique customer
                    Objects.equals(customerLoanApplication.getCustomerId(), soughtCustomer.getId()) &&// which is still active
                    Objects.equals(customerLoanApplication.getLoanStatus(), LoanStatus.ACTIVE.toString()))
            {
                //pull the lasted balance
                double latestBalance = customerLoanApplication.getLatestBalance();
                //Create a record for payment
                LoanPaymentHistory loanPayment = LoanPaymentHistory.builder().build();
                loanPayment.setId(randomPaymentId);
                loanPayment.setCustomerId(customerLoanApplication.getCustomerId());
                if(paymentAmount==latestBalance)//Money to be paid by Customer will settle the loan
                {
                    //Settle the loan and update loan status to SETTLED
                    loanPayment.setLoanStatus(LoanStatus.SETTLED.toString());
                    loanPayment.setLastUpdated(ts.toString());
                    loanPayment.setPaymentAmount(paymentAmount);
                    //Update customer current loan to reflect latest balance owed minus paid amount
                    customerLoanApplication.setLatestBalance(customerLoanApplication.getLatestBalance() - paymentAmount);
                    customerLoanApplication.setLoanStatus(LoanStatus.SETTLED.toString());
                    customerLoanApplication.setLastPaymentDate(ts.toString());
                    //Create the record in the database
                    break;
                }
                if(paymentAmount < latestBalance)
                {
                    //Normal flow
                    loanPayment.setLoanStatus(LoanStatus.ACTIVE.toString());
                    loanPayment.setLastUpdated(ts.toString());
                    loanPayment.setPaymentAmount(paymentAmount);
                    //Update customer current loan to reflect latest balance owed minus paid amount
                    customerLoanApplication.setLatestBalance(customerLoanApplication.getLatestBalance() - paymentAmount);
                    customerLoanApplication.setLastPaymentDate(ts.toString());
                    //Create the record in the database
                    break;
                }
                if(paymentAmount > latestBalance)
                {
                    customerLoanApplication = new CustomerLoanApplication();
                    customerLoanApplication.setLoanStatus("Invalid Payment");
                    break;
                }
            }
            else {
               return null;
            }
        }
        return customerLoanApplication;
    }



}

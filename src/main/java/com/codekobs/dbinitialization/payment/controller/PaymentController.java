package com.codekobs.dbinitialization.payment.controller;

import com.codekobs.dbinitialization.entity.CustomerLoanApplication;
import com.codekobs.dbinitialization.model.CustomerLoanApplicationModel;
import com.codekobs.dbinitialization.payment.entity.LoanPaymentHistory;
import com.codekobs.dbinitialization.payment.model.PaymentHistoryModel;
import com.codekobs.dbinitialization.payment.service.LoanPaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;


@RestController
public class PaymentController {
    Date date = new Date();
    Timestamp ts = new Timestamp(date.getTime());

    @Autowired
    private LoanPaymentHistoryService loanPaymentHistoryService;

    @PostMapping("/payments")
    public ResponseEntity<LoanPaymentHistory> payLoan(@RequestBody PaymentHistoryModel paymentHistory)
    {
        LoanPaymentHistory loan =  loanPaymentHistoryService.saveLoanPaymentHistory(paymentHistory);
        return ResponseEntity.ok(loan);
    }

    @PutMapping("/payments/{id}")
    public ResponseEntity<CustomerLoanApplication> updateLoan(@PathVariable Long id, @RequestBody CustomerLoanApplicationModel
            customerLoanApplicationModel)
    {
         /*
        Optional<CustomerLoanApplication> customerLoanApplication = customerLoanApplicationService.findCustomerLoanApplicationById(id);

        if(customerLoanApplication!=null)
        {
            LoanModel loanModel = customerLoanApplicationModel.getLoanModel();
            CustomerLoanApplication customerLoanApplication1 = CustomerLoanApplication.builder()
                    .loanId(customerLoanApplication.getLoanId()).customerId(customerLoanApplication.getCustomerId()).
                    loanAmount(loanModel.getLoanAmount()).
                    latestBalance(10000 - loanModel.getLatestBalance()).lastPaymentDate(ts.toString()).build();
                    customerLoanApplicationService.save(customerLoanApplication1);
                    ResponseEntity.ok(customerLoanApplication1);
        }
        return ResponseEntity.ok(user);
        */
        //return ResponseEntity.ok(customerLoanApplication.get());
        return null;
    }
}

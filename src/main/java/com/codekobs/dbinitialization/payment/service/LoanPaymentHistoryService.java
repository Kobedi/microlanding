package com.codekobs.dbinitialization.payment.service;

import com.codekobs.dbinitialization.payment.entity.LoanPaymentHistory;
import com.codekobs.dbinitialization.payment.model.PaymentHistoryModel;

import java.util.List;

public interface LoanPaymentHistoryService {
    LoanPaymentHistory saveLoanPaymentHistory(LoanPaymentHistory loanPaymentHistory);

    LoanPaymentHistory saveLoanPaymentHistory(PaymentHistoryModel paymentHistory);

    // Read operation
    List<LoanPaymentHistory> fetchLoanPaymentHistory();
    // Update operation
    LoanPaymentHistory updateLoanPaymentHistory(LoanPaymentHistory loanPaymentHistory,
                                                     Long loanPaymentHistoryId);
    // Delete operation
    void deleteLoanPaymentHistoryById(Long customerLoanApplicationId);

}

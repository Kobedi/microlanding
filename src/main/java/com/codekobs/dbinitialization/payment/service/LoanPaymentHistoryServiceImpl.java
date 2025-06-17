package com.codekobs.dbinitialization.payment.service;

import com.codekobs.dbinitialization.payment.entity.LoanPaymentHistory;
import com.codekobs.dbinitialization.payment.model.PaymentHistoryModel;
import com.codekobs.dbinitialization.payment.repository.LoanPaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanPaymentHistoryServiceImpl implements LoanPaymentHistoryService{



    @Autowired
    private LoanPaymentHistoryRepository loanPaymentHistoryRepository;

    Date date = new Date();
    Timestamp ts = new Timestamp(date.getTime());
    @Override
    public LoanPaymentHistory saveLoanPaymentHistory(LoanPaymentHistory loanPaymentHistory) {
        return loanPaymentHistoryRepository.save(loanPaymentHistory);
    }

    @Override
    public LoanPaymentHistory saveLoanPaymentHistory(PaymentHistoryModel paymentHistory) {

        LoanPaymentHistory loanPaymentHistory = LoanPaymentHistory.builder().build();
        loanPaymentHistory.setLoanId(paymentHistory.getLoanId());
        loanPaymentHistory.setCustomerId(paymentHistory.getCustomerId());
        loanPaymentHistory.setPaymentAmount(paymentHistory.getPaymentAmount());
        loanPaymentHistory.setLoanStatus(paymentHistory.getLoanStatus());
        loanPaymentHistory.setLastUpdated(ts.toString());
        return loanPaymentHistoryRepository.save(loanPaymentHistory);
    }

    @Override
    public List<LoanPaymentHistory> fetchLoanPaymentHistory() {
        return (List<LoanPaymentHistory>) loanPaymentHistoryRepository.findAll();
    }

    @Override
    public LoanPaymentHistory updateLoanPaymentHistory(LoanPaymentHistory loanPaymentHistory, Long loanPaymentHistoryId) {
        Optional<LoanPaymentHistory> loan = loanPaymentHistoryRepository.findById(loanPaymentHistoryId);
        return loanPaymentHistoryRepository.save(loan.get());
    }

    @Override
    public void deleteLoanPaymentHistoryById(Long customerLoanApplicationId) {
        loanPaymentHistoryRepository.deleteById(customerLoanApplicationId);
    }
}

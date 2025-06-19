package com.codekobs.dbinitialization.payment.service;

import com.codekobs.dbinitialization.entity.CustomerLoanApplication;
import com.codekobs.dbinitialization.payment.entity.LoanPaymentHistory;
import com.codekobs.dbinitialization.payment.model.PaymentHistoryModel;
import com.codekobs.dbinitialization.payment.process.ProcessLoanApplication;
import com.codekobs.dbinitialization.payment.repository.LoanPaymentHistoryRepository;
import com.codekobs.dbinitialization.service.CustomerLoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanPaymentHistoryServiceImpl implements LoanPaymentHistoryService{

    @Autowired
    private LoanPaymentHistoryRepository loanPaymentHistoryRepository;

    @Autowired
    private CustomerLoanApplicationService customerLoanApplicationService;

    @Autowired
    private ProcessLoanApplication processLoanApplication;

    Date date = new Date();
    Timestamp ts = new Timestamp(date.getTime());

    public enum LoanStatus
    {
        ACTIVE,SETTLED

    }
    @Override
    public LoanPaymentHistory saveLoanPaymentHistory(LoanPaymentHistory loanPaymentHistory) {
        return loanPaymentHistoryRepository.save(loanPaymentHistory);
    }

    @Override
    public synchronized LoanPaymentHistory saveLoanPaymentHistory(PaymentHistoryModel paymentHistory) {

        LoanPaymentHistory loanPaymentHistory = LoanPaymentHistory.builder().build();
        Optional<CustomerLoanApplication> soughtCustomerLoanApplication = customerLoanApplicationService.
                findCustomerLoanApplicationById(paymentHistory.getLoanId());
        if(soughtCustomerLoanApplication.isPresent())
        {
            CustomerLoanApplication existingCustomerLoanApplication = soughtCustomerLoanApplication.get();
            Double paymentAmount = paymentHistory.getPaymentAmount();

            existingCustomerLoanApplication = processLoanApplication.updateLoanApplication(existingCustomerLoanApplication,
                    paymentAmount);
            if(existingCustomerLoanApplication!=null)
            {
                if(existingCustomerLoanApplication.getLoanStatus().equalsIgnoreCase("ACTIVE") ||
                        existingCustomerLoanApplication.getLoanStatus().equalsIgnoreCase("SETTLED"))
                {
                    //customerLoanApplicationService.saveCustomerLoanApplication(existingCustomerLoanApplication);
                     loanPaymentHistory = processLoanApplication.createPayment(existingCustomerLoanApplication,
                            paymentAmount);
                     //save to db
                    CustomerLoanApplication savedState = customerLoanApplicationService.saveCustomerLoanApplication(existingCustomerLoanApplication);

                    //Throws persimistic relate errors
                    //saveRecord(loanPaymentHistory);
                }
            }
        }
        else {
            //Display message to say loan Id does not exist
        }
        return loanPaymentHistory;
    }


    private synchronized void saveRecord(LoanPaymentHistory record)
    {
        loanPaymentHistoryRepository.save(record);
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

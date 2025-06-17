package com.codekobs.dbinitialization.payment.model;


public class LoanModel {

    private Long Id;

    private Long loanId;

    private Double loanAmount;

    private Double latestBalance;

    private String latestPaymentDate;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getLatestBalance() {
        return latestBalance;
    }

    public void setLatestBalance(Double latestBalance) {
        this.latestBalance = latestBalance;
    }

    public String getLatestPaymentDate() {
        return latestPaymentDate;
    }

    public void setLatestPaymentDate(String latestPaymentDate) {
        this.latestPaymentDate = latestPaymentDate;
    }
}

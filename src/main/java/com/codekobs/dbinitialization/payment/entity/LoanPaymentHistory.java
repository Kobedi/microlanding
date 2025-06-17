package com.codekobs.dbinitialization.payment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="LOAN_PAYMENTS_HISTORY")
public class LoanPaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Long id;

    @Column(name = "LOAN_ID")
    private Long loanId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "PAYMENT_AMOUNT")
    private Double paymentAmount;

    @Column(name = "LOAN_STATUS")
    private String loanStatus;

    @Column(name = "LAST_UPDATED")
    private String lastUpdated;

}

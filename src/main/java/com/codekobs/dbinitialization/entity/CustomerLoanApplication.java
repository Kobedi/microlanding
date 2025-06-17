package com.codekobs.dbinitialization.entity;

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
@Table(name ="CUSTOMER_LOAN_APPLICATION")
public class CustomerLoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Long id;

    @Column(name = "LOAN_ID")
    private Long loanId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "LOAN_AMOUNT")
    private Double loanAmount;

    @Column(name = "LATEST_BALANCE")
    private Double latestBalance;

    @Column(name = "LAST_PAYMENT_DATE")
    private String lastPaymentDate;

}

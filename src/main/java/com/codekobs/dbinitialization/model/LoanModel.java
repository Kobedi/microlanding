package com.codekobs.dbinitialization.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanModel {

    private Long Id;

    private Long loanId;

    private Double loanAmount;

    private Double latestBalance;

    private String loanStatus;

    private String latestPaymentDate;


}

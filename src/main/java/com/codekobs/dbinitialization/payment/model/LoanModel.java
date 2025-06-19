package com.codekobs.dbinitialization.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private String loanStatus;

    private String latestPaymentDate;


}

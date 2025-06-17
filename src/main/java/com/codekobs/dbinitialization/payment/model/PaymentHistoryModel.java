package com.codekobs.dbinitialization.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentHistoryModel implements Serializable {

    private Long id;

    private Long loanId;

    private Long customerId;

    private Double paymentAmount;

    private String loanStatus;

    private String lastUpdated;

}

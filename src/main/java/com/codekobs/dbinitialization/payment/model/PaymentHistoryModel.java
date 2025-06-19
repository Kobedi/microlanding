package com.codekobs.dbinitialization.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private Long id;

    private Long loanId;

    @JsonIgnore
    private Long customerId;

    private Double paymentAmount;

    @JsonIgnore
    private String loanStatus;
    @JsonIgnore
    private String lastUpdated;

}

package com.codekobs.dbinitialization.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerLoanApplicationModel implements Serializable {

    private final String uuid = UUID.randomUUID().toString();
private CustomerModel customerModel;

private LoanModel loanModel;


}

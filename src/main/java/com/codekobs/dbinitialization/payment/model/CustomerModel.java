package com.codekobs.dbinitialization.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerModel {

    private Long Id;

    private String name;

    private String lastName;

    private String applicationDate;


}

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
@Table(name ="CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name ="LAST_NAME")
    private String lastName;

    @Column(name = "APPLICATION_DATE")
    private String applicationDate;

}

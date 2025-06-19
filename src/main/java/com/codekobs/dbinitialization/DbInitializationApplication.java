package com.codekobs.dbinitialization;

import com.codekobs.dbinitialization.entity.Customer;
import com.codekobs.dbinitialization.entity.CustomerLoanApplication;
import com.codekobs.dbinitialization.payment.entity.LoanPaymentHistory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.*;

@SpringBootApplication
public class DbInitializationApplication {


	public static void main(String[] args) {

		SpringApplication.run(DbInitializationApplication.class, args);

	}

}

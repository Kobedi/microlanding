package com.codekobs.dbinitialization.payment.repository;

import com.codekobs.dbinitialization.payment.entity.LoanPaymentHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanPaymentHistoryRepository extends CrudRepository<LoanPaymentHistory, Long> {

}

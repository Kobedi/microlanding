package com.codekobs.dbinitialization.repository;


import com.codekobs.dbinitialization.entity.CustomerLoanApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerLoanApplicationRepository extends CrudRepository<CustomerLoanApplication, Long> {


}

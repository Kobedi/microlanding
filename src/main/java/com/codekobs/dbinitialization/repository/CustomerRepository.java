package com.codekobs.dbinitialization.repository;

import com.codekobs.dbinitialization.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}

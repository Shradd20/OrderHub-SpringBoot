package com.sts.ps.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sts.ps.entity.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {

}

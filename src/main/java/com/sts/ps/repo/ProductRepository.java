package com.sts.ps.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sts.ps.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

}

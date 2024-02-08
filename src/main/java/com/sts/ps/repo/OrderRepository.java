package com.sts.ps.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sts.ps.entity.OrderEntity;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity,Integer>{

	List<OrderEntity> findByCustomer_Id(int customerId);
	 //List<OrderEntity> findByCustomer_Id(int customerId);
}

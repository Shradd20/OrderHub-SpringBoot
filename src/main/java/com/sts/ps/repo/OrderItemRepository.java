package com.sts.ps.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sts.ps.entity.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem,Integer> {

}

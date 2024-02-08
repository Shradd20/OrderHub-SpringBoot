package com.sts.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.ps.entity.OrderItem;
import com.sts.ps.repo.OrderItemRepository;

@Service
public class OrderItemService {
	  @Autowired
	    private OrderItemRepository orderItemRepository;

	    public Iterable<OrderItem> getAllOrderItems() {
	        return orderItemRepository.findAll();
	    }

	    public OrderItem getOrderItemById(Integer orderItemId) {
	        return orderItemRepository.findById(orderItemId).orElse(null);
	    }

	    public OrderItem saveOrderItem(OrderItem orderItem) {
	        return orderItemRepository.save(orderItem);
	    }
}

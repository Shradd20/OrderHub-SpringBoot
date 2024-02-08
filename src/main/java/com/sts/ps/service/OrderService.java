package com.sts.ps.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.ps.entity.OrderEntity;
import com.sts.ps.entity.OrderItem;
import com.sts.ps.entity.Product;
import com.sts.ps.repo.OrderRepository;

@Service
public class OrderService {
	@Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private OrderItemService orderItemService;
    
  //The class autowires the OrderRepository to interact with order data in the database and the 
    //ProductService to retrieve product information.

    public Iterable<OrderEntity> getAllOrders() {
        return orderRepo.findAll();
    }

    public OrderEntity getOrderById(Integer orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }

    public OrderEntity saveOrder(OrderEntity order) {
        return orderRepo.save(order);
    }

    
 //The calculateTotalAmount method calculates the total amount to be paid based on the list of 
//product IDs provided. It retrieves product prices from the ProductService and calculates 
//the cumulative total amount.
    public double calculateTotalAmount(Iterable<Integer> productIds) {
        double totalAmount = 0.0;
        for (Integer productId : productIds) {
            Product product = productService.getProductById(productId);
            if (product != null) {
                totalAmount += product.getPrice();
            }
        }
        return totalAmount;
    }
    
 // Add the new method to calculate total purchase amount for a given customer
    public Map<Integer, List<Integer>> calculateTotalPurchaseAmountForCustomer(int customerId) {
        Map<Integer, List<Integer>> purchases = new HashMap<>();
        List<OrderEntity> customerOrders = orderRepo.findByCustomer_Id(customerId);
        
        for (OrderEntity order : customerOrders) {
            List<Integer> productIds = new ArrayList<>();
            Iterable<OrderItem> orderItems = orderItemService.getAllOrderItems(); // Assuming this method retrieves all order items
            
            for (OrderItem orderItem : orderItems) {
                if (orderItem.getOrder().getOid() == order.getOid()) {
                    productIds.add(orderItem.getProduct().getPid());
                }
            }
            
            purchases.put(order.getOid(), productIds);
        }
        return purchases;
    }
    
    
    
}

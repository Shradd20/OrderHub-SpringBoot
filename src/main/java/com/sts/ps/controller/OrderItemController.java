package com.sts.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.ps.dto.OrderItemDTO;
import com.sts.ps.entity.OrderEntity;
import com.sts.ps.entity.OrderItem;
import com.sts.ps.entity.Product;
import com.sts.ps.service.OrderItemService;
import com.sts.ps.service.OrderService;
import com.sts.ps.service.ProductService;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<OrderItem>> getAllOrderItems() {
        Iterable<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }


    @GetMapping("/{orderItemId}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Integer orderItemId) {
        OrderItem orderItem = orderItemService.getOrderItemById(orderItemId);
        if (orderItem != null) {
            return ResponseEntity.ok(orderItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
//    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
//        OrderItem savedOrderItem = orderItemService.saveOrderItem(orderItem);
//        return ResponseEntity.ok(savedOrderItem);
//    }
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        // Fetch order and product from their respective services
        OrderEntity order = orderService.getOrderById(orderItemDTO.getOrderId());
        Product product = productService.getProductById(orderItemDTO.getProductId());

        // Create OrderItem object and save it
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);

        OrderItem savedOrderItem = orderItemService.saveOrderItem(orderItem);
        return ResponseEntity.ok(savedOrderItem);
    }
    
    
}

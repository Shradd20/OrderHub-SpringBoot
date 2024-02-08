package com.sts.ps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sts.ps.dto.OrderDTO;
import com.sts.ps.entity.Customer;
import com.sts.ps.entity.OrderEntity;
import com.sts.ps.service.CustomerService;
import com.sts.ps.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
    private OrderService orderService;
	@Autowired
	private CustomerService customerService;

//retrieves all orders, and returns them.
    @GetMapping
    public ResponseEntity<Iterable<OrderEntity>> getAllOrders() {
        Iterable<OrderEntity> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

//retrieves an order by ID, and returns it.
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable Integer orderId) {
        OrderEntity order = orderService.getOrderById(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
//saves a new order to the database, and returns the saved order object.
//    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
//        OrderEntity savedOrder = orderService.saveOrder(order);
//        return ResponseEntity.ok(savedOrder);
//    }
    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderDTO orderDTO) {
        // Convert OrderDTO to OrderEntity
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDate(orderDTO.getOrderDate());

        // Fetch the customer from the database based on customer ID
        Customer customer = customerService.getCustomerById(orderDTO.getCustomerId());
        if (customer != null) {
            orderEntity.setCustomer(customer);
        } else {
            return ResponseEntity.badRequest().body(null); // Customer not found
        }

        // Save the order
        OrderEntity savedOrder = orderService.saveOrder(orderEntity);
        return ResponseEntity.ok(savedOrder);
    }

//Handles HTTP GET requests to /orders/totalAmount with a list of product IDs as query parameters,
// calculates the total amount based on the prices of the products, and returns the total amount.
//    public ResponseEntity<Double> calculateTotalAmount(@RequestParam("productIds") Iterable<Integer> productIds) {
//        double totalAmount = orderService.calculateTotalAmount(productIds);
//        return ResponseEntity.ok(totalAmount);
//    }
    @GetMapping("/totalAmount")
    public ResponseEntity<Double> calculateTotalAmount(@RequestParam("productIds") String productIds) {
        // Split the comma-separated string of product IDs into an array of strings
        String[] productIdStrings = productIds.split(",");

        // Create a list to store the parsed product IDs
        List<Integer> productIdList = new ArrayList<>();

        // Parse each string element into an integer and add it to the list
        for (String productIdString : productIdStrings) {
            try {
                int productId = Integer.parseInt(productIdString.trim()); // Trim to remove any leading/trailing whitespace
                productIdList.add(productId);
            } catch (NumberFormatException e) {
                // Handle parsing errors if necessary
            }
        }

        // Now you have a list of product IDs, pass it to the service method to calculate the total amount
        double totalAmount = orderService.calculateTotalAmount(productIdList);

        // Return the calculated total amount in the response
        return ResponseEntity.ok(totalAmount);
    }
//method, the request is expected to be sent to the /orders/totalAmount endpoint, and the list of
//product IDs is passed as query parameters in the URL.For example, if you want to calculate the
//total amount for a list of product IDs [1, 2, 3] url will be GET /orders/totalAmount?productIds=1,2,3
// where '/orders/totalAmount' is the endpoint to calculate the total amount.'?' signifies the start
//of the query parameters.'productIds=1,2,3' represents the list of product IDs separated by commas.

    @GetMapping("/calculateTotalPurchaseAmount/{customerId}")
    public ResponseEntity<Map<Integer, List<Integer>>> calculateTotalPurchaseAmount(@PathVariable Integer customerId) {
        Map<Integer, List<Integer>> purchaseAmount = orderService.calculateTotalPurchaseAmountForCustomer(customerId);
        return ResponseEntity.ok(purchaseAmount);
    }

}

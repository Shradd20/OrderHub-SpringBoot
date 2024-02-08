package com.sts.ps.dto;

public class OrderItemDTO {
	private int orderId;
    private int productId;

    // Constructors, getters, and setters
    public OrderItemDTO() {
        // Default constructor
    }

    public OrderItemDTO(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    // Getters and setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}

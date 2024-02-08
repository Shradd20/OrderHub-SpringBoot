package com.sts.ps.dto;

import java.time.LocalDate;

public class OrderDTO {
	private LocalDate orderDate;
    private int customerId;

    // Constructors, getters, and setters

    public OrderDTO() {
        // Default constructor
    }

    public OrderDTO(LocalDate orderDate, int customerId) {
        this.orderDate = orderDate;
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

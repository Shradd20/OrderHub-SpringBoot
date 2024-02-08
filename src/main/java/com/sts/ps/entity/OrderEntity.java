package com.sts.ps.entity;

import java.time.LocalDate;

import com.sts.ps.dto.OrderDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int oid;
    private LocalDate orderDate;
    
    
    //@ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne(fetch = FetchType.EAGER) // Adjust the fetch type
    @JoinColumn(name = "id") // Add join column mapping
    private Customer customer;  //kyu ki ek single customer many order place karsakta hai.


	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor with OrderDTO parameter for conversion
    public OrderEntity(OrderDTO orderDTO) {
        this.orderDate = orderDTO.getOrderDate();
    }

	public OrderEntity(int oid, LocalDate orderDate, Customer customer) {
		super();
		this.oid = oid;
		this.orderDate = orderDate;
		this.customer = customer;
	}


	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    
    
}

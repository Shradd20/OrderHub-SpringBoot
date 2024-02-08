package com.sts.ps.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int oiid;

    // Other attributes

    @ManyToOne
    private OrderEntity order; //kyu ki ek order mai ham multiple items order karsakte

    @ManyToOne
    private Product product;  // ek user ne ek product ke bhut sare items mangaye hosakte hai

    
    
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(int oiid, OrderEntity order, Product product) {
		super();
		this.oiid = oiid;
		this.order = order;
		this.product = product;
	}

	public int getOiid() {
		return oiid;
	}

	public void setOiid(int oiid) {
		this.oiid = oiid;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
    
}

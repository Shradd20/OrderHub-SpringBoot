package com.sts.ps.service;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.ps.entity.Product;
import com.sts.ps.repo.ProductRepository;

@Service
public class ProductService {

	 @Autowired
	    private ProductRepository productRepo;

	    public Iterable<Product> getAllProducts() {
	        return productRepo.findAll();
	    }

	    public Product getProductById(Integer productId) {
	        return productRepo.findById(productId).orElse(null);
	    }

	    public Product saveProduct(Product product) {
	        return productRepo.save(product);
	    }
}

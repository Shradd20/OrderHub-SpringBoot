package com.sts.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.ps.entity.Product;
import com.sts.ps.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	 @Autowired
	    private ProductService productService;
//Handles HTTP GET requests to /products, retrieves all products, and returns them.
	 public ResponseEntity<Iterable<Product>> getAllProducts() {
	        Iterable<Product> products = productService.getAllProducts();
	        return ResponseEntity.ok(products);
	    }
//Handles HTTP GET requests to /products/{productId}, retrieves a product by ID, and returns it.
	    @GetMapping("/{productId}")
	    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
	        Product product = productService.getProductById(productId);
	        if (product != null) {
	            return ResponseEntity.ok(product);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
//Handles HTTP POST requests to /products, saves a new product to the database, and returns the 
//saved product object.
	    @PostMapping
	    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	        Product savedProduct = productService.saveProduct(product);
	        return ResponseEntity.ok(savedProduct);
	    }
	    
}

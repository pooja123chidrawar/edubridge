package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Product;
import com.springboot.model.User;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
	
	public Product findByProductName(String productName);

}

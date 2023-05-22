package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer> {
	public Cart findByCartProductName(String cartProductName);
	
	public List<Cart> findByUserUserId(long userId);
	

}

package com.springboot.service;

import java.util.List;

import com.springboot.model.Cart;
import com.springboot.model.Product;

public interface CartService {
	
	public Cart saveCartProduct(long productId,long userId,Cart cart);
	public List<Cart> getCartProductByUserId(long userId); 
	public List<Cart> getAllCarts();
	public Cart getCartProductByCartId(int cartId);
    public void deleteCartProductByCartId(int cartId);
    public Cart updateCartProductByCartId(int cartId,Cart cart);
    public Cart getCartByCartProductName(String cartProductName);
    
}
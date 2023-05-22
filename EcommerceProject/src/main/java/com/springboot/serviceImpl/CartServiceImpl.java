package com.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Cart;
import com.springboot.model.Product;
import com.springboot.model.User;
import com.springboot.repository.CartRepository;
import com.springboot.service.CartService;
import com.springboot.service.ProductService;
import com.springboot.service.UserService;


@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;
	public CartServiceImpl() {
		this.cartRepository=cartRepository;
	}
	@Override
	public Cart saveCartProduct(long productId,long userId,Cart cart) {
		System.out.println("inside cart service");
		double total_price=0.0;
	User user=	userService.getUserById(userId);
	Product product=productService.getProductById(productId);
	cart.setUser(user);
	cart.setProduct(product);
	cart.setCartProductName(product.getProductName());
	cart.setQuantity(product.getQuantity());
	
	total_price=product.getPrice()*product.getQuantity()-product.getDiscount();
	cart.setTotal_cost(total_price);
	
	return cartRepository.save(cart);
	}
	@Override
	public List<Cart> getAllCarts() {
		return cartRepository.findAll();
	}
//	@Override
//	public List<Cart> getCartProductByCartId(int cartId) {
//		return cartRepository.findById(cartId)
//	}
	@Override
	public void deleteCartProductByCartId(int cartId) {
		Cart cart = getCartProductByCartId(cartId);
		cartRepository.deleteById(cart.getCartId());
	}
	@Override
	public Cart updateCartProductByCartId(int cartId,Cart cart) {
		Cart cart1 = getCartProductByCartId(cartId);
		cart1.setCartProductName(cart.getCartProductName());
		cart1.setQuantity(cart.getQuantity());
		cart1.setTotal_cost(cart.getTotal_cost());
		return cartRepository.save(cart1);
	}
	@Override
	public Cart getCartByCartProductName(String cartProductName) {
		
		Cart cart= cartRepository.findByCartProductName(cartProductName);
		if(cartProductName!=null) {
			return cart;
		}else {
			throw new ResourceNotFoundException("Cart","cartProductName",cartProductName);
		}
	}
	@Override
	public Cart getCartProductByCartId(int cartId) {
		return cartRepository.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart","cartServiceNo",cartId));
	}
	@Override
	public List<Cart> getCartProductByUserId(long userId) {
		
		System.out.println("in cart service userId");
		return cartRepository.findByUserUserId(userId);
	}
		

	
	
	
	

}
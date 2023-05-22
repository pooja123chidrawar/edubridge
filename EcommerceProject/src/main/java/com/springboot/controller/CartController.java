package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Cart;
import com.springboot.model.Product;
import com.springboot.service.CartService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	public CartController() {
		this.cartService=cartService;
	}
	
	@PostMapping("/{productId}/{userId}")
	public ResponseEntity<Cart> saveCartItem(@PathVariable("productId") int productId,@PathVariable("userId") int userId,@RequestBody Cart cart){
		System.out.println("inside cart controller");
		Cart cartProduct1 = cartService.saveCartProduct(productId,userId,cart);
		return new ResponseEntity<Cart>(cartProduct1,HttpStatus.CREATED);
	}
	@GetMapping("/get/{userId}")
	public List<Cart> getAllCartProducts(@PathVariable("userId")long userId){
		
		System.out.println("in cart controller userId");
		return cartService.getCartProductByUserId(userId);
	}
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartProductByCartId(@PathVariable int cartId){
		return new ResponseEntity<Cart>(cartService.getCartProductByCartId(cartId),HttpStatus.OK);
	}
	@DeleteMapping("/{cartId}")
	public ResponseEntity<String> deleteCartProductByCartId(@PathVariable int cartId){
		cartService.deleteCartProductByCartId(cartId);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	@PutMapping("/{cartId}")
	public ResponseEntity<Cart> updateCartProductByCartId(@PathVariable int cartId,@RequestBody Cart cart){
		return new ResponseEntity<Cart>(cartService.updateCartProductByCartId(cartId, cart),HttpStatus.OK);
	}
	
	 @GetMapping("/getProduct/{cartProductName}")
	  public ResponseEntity<Cart> getCartByCartProductName(@PathVariable("cartProductName") String cartProductName)
	  {
	  	return new ResponseEntity<Cart>(cartService.getCartByCartProductName(cartProductName),HttpStatus.OK);
	  }

}
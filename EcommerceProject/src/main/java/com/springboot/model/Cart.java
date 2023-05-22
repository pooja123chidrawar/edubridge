package com.springboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Cart")
public class Cart {
	@Id
	@SequenceGenerator(name="seq_cart",sequenceName="CartSequence",initialValue=10000,allocationSize=10)
    @GeneratedValue(generator="seq_cart")
	@Column(name="cartId")
	private int cartId;
	@Column(name="cartProductName")
	private String cartProductName;
	@Column(name="quantity")
	private int quantity;
	@Column(name="total_cost")
	private double total_cost;
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	private User user;
	

	@ManyToOne
	@JoinColumn(name="product_Id")
    private Product product;
	
	


	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartProductName=" + cartProductName + ", quantity=" + quantity
				+ ", total_cost=" + total_cost + ", user=" + user + ", product=" + product + "]";
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCartProductName() {
		return cartProductName;
	}

	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart(int cartId, String cartProductName, int quantity, double total_cost, User user, Product product) {
		super();
		this.cartId = cartId;
		this.cartProductName = cartProductName;
		this.quantity = quantity;
		this.total_cost = total_cost;
		this.user = user;
		this.product = product;
	}

	
    
	
	
	
}
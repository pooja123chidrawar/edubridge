package com.springboot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Payment")
public class Payment {
	@Id
	@SequenceGenerator(name="seq_payment",sequenceName="PaymentSequence",initialValue=200,allocationSize=100)
	@GeneratedValue(generator="seq_payment")
	
	private int paymentId;
	@Column(name="payment_type" )
	private String paymentType;
	
	@Column(name="amount")
	private double amount;
	
	@JsonFormat(pattern="yyyy/MM/dd")
	private Date paymentDate;
	
	
	@OneToOne
	@JoinColumn(name="cart_id")
	private Cart cartId;
	
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user_id;


	public Payment(int paymentId, String paymentType, double amount, Date paymentDate, Cart cartId, User user_id) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.cartId = cartId;
		this.user_id = user_id;
	}


	public Payment() {
		super();
	}


	public int getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}


	public String getPaymentType() {
		return paymentType;
	}


	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public Cart getCartId() {
		return cartId;
	}


	public void setCartId(Cart cartId) {
		this.cartId = cartId;
	}


	public User getUser_id() {
		return user_id;
	}


	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

}


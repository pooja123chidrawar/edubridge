package com.springboot.serviceImpl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Cart;
import com.springboot.model.Payment;
import com.springboot.model.User;
import com.springboot.repository.PaymentRepository;
import com.springboot.service.CartService;
import com.springboot.service.PaymentService;
import com.springboot.service.UserService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    UserService userService;
    
    @Autowired
    CartService cartService;

public PaymentServiceImpl() {
	this.paymentRepository=paymentRepository;
}
//	@Override
//	public Payment generatePayment(int cartId,long userId,,Payment payment) {
//		User user=userService.getUserById(userId);
//		Cart cart = cartService.getCartProductByCartId(cartId);
//		payment.setUser_id(user);
//		payment.setCartId(cart);
//		payment.setAmount(cart.getTotal_cost());
//		return paymentRepository.save(payment);
//	}
	@Override
	public List<Payment> getAllPayments() {
		
		return paymentRepository.findAll();
	}
	@Override
	public Payment getPaymentById(int paymentId) {
		
		return paymentRepository.findById(paymentId).orElseThrow(()->new ResourceNotFoundException("Payment","paymentId",paymentId));
	}
	@Override
	public void cancelPaymentById(int paymentId) {
		//Items item =getItemById(itemid);
//      Payment payment=getPaymentById(paymentId);
	   paymentRepository.deleteById(paymentId);
		
	}
	@Override
	public Payment updatePaymentById(int paymentId, Payment payment) {
	  Payment payment1 = getPaymentById(paymentId);
	  
	  payment1.setPaymentType(payment.getPaymentType());
	  payment1.setAmount( payment.getAmount());
	  payment1.setPaymentDate(payment.getPaymentDate());
	  
		return paymentRepository.save(payment1);
	}
	@Override
	public Payment generatePayment(int cartId, long userId, Payment payment) {
		User user=userService.getUserById(userId);
		Cart cart = cartService.getCartProductByCartId(cartId);
		payment.setUser_id(user);
		payment.setCartId(cart);
		payment.setAmount(cart.getTotal_cost());
		payment.setPaymentDate(new Date());
		return paymentRepository.save(payment);
	}
	

}

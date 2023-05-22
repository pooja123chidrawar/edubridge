package com.springboot.service;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.model.Payment;
@Repository
public interface PaymentService {
	public Payment generatePayment(int cartId,long userId,Payment payment);
	public List<Payment> getAllPayments();
    public Payment getPaymentById(int paymentId);
    public void cancelPaymentById(int paymentId);
    public Payment updatePaymentById(int paymentId,Payment payment);
}

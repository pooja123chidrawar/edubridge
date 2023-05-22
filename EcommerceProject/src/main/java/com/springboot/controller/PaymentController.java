package com.springboot.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Payment;
import com.springboot.service.PaymentService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	public PaymentController() {
		this.paymentService=paymentService;
	}
	@PostMapping("/{userId}/{cartId}")
	public ResponseEntity<Payment> generatePayment( @PathVariable int cartId,@PathVariable("userId")long userId,@RequestBody Payment payment)
	{
	return new ResponseEntity<Payment>(paymentService.generatePayment(cartId,userId,payment),HttpStatus.CREATED);
	}
	@GetMapping()
	public List<Payment> getAllPayments(){
		return paymentService.getAllPayments();
	}
	
	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable int paymentId){
		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId),HttpStatus.OK);
	}
	@DeleteMapping("/{paymentId}")
	public ResponseEntity<String> cancelPaymentById(@PathVariable int paymentId){
		paymentService.cancelPaymentById(paymentId);
		return new ResponseEntity<String>("Payment cancelled successfully",HttpStatus.OK);
	}
	@PutMapping("/{paymentId}")
	public ResponseEntity<Payment> updatePaymentById(@PathVariable int paymentId,@RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.updatePaymentById(paymentId, payment),HttpStatus.OK);
	}
}


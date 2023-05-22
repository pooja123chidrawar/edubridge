package com.springboot.controller;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

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

import com.springboot.model.Product;
import com.springboot.model.User;
import com.springboot.service.ProductService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@PostMapping("/api/add/product/{categoryId}")
	public ResponseEntity<Product> saveProduct(@Valid @PathVariable("categoryId")long categoryId, @RequestBody Product product){
		return new ResponseEntity<Product>(productService.saveProduct(categoryId,product),HttpStatus.CREATED);
		
	}
	@GetMapping("/api/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	@GetMapping("/api/product/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId")long productId){
		return new ResponseEntity<Product>(productService.getProductById(productId),HttpStatus.OK);
	}
	@DeleteMapping("/api/product/delete")
	public ResponseEntity<String> deleteProductById(@PathVariable("productId")long productId){
		productService.deleteProductById(productId);
		return new ResponseEntity<String>("product deleted succesfully",HttpStatus.OK);
	}
	@PutMapping("/api/product/update/{productId}")
	public ResponseEntity<Product> updateProductById(@Valid @RequestBody Product product,@PathVariable("productId")long productId){
		return new ResponseEntity<Product>(productService.updateProductById(product, productId),HttpStatus.OK);
	}
	@GetMapping("api/product/byName/{productName}")
	public ResponseEntity<Product> getUserByName(@PathVariable("productName") String productName){
		
		return new ResponseEntity<Product>(productService.findByProductName(productName),HttpStatus.OK);
		
	}
}

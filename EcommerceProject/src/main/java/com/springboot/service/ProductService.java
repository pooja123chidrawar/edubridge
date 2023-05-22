package com.springboot.service;

import java.util.List;

import com.springboot.model.Product;
import com.springboot.model.User;

public interface ProductService {
	public Product saveProduct(long catgeoryId,Product product);
	public List<Product> getAllProducts();
	public Product getProductById(long productId);
	public void deleteProductById(long productId);
	public Product updateProductById(Product product,long ProductId);
	public Product findByProductName(String productName);

}

package com.springboot.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.exception.ResourceNotFoundException;

import com.springboot.model.Category;
import com.springboot.model.Product;
import com.springboot.repository.ProductRepository;
import com.springboot.service.CategoryService;
import com.springboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryService categoryService;
	
	
	
	public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
		super();
		this.productRepository = productRepository;
		this.categoryService = categoryService;
	}
	
	@Override
	public Product saveProduct(long categoryId,Product product) {
		Category category=categoryService.getCategoryById(categoryId);
		product.setCategory(category);
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(long productId) {
		return productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product","Id",productId));
	}

	@Override
	public void deleteProductById(long productId) {
		productRepository.findById(productId).get();
		productRepository.deleteById(productId);
	}

	@Override
	public Product updateProductById(Product product, long productId) {
		Product exist=productRepository.findById(productId).get();
		exist.setProductName(product.getProductName());
		exist.setProductDescription(product.getProductDescription());
		exist.setPrice(product.getPrice());
		exist.setDiscount(product.getDiscount());
		exist.setQuantity(product.getQuantity());
		return productRepository.save(exist);
	}

	@Override
	public Product findByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}

}

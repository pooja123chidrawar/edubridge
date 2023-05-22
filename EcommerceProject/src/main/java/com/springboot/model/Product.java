package com.springboot.model;

import javax.persistence.CascadeType;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotEmpty;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="product_table")
public class Product {
	
	@Id
	@SequenceGenerator(name="seq_product",sequenceName="product_sequence",initialValue=100,allocationSize=100)
	@GeneratedValue(generator="seq_product")
	private long productId;
	@NotEmpty
	private String productName;
	private String productDescription;
	private double price;
	private double discount;
	private int quantity;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id", referencedColumnName="category_id")
	private Category category;
	

	public Product(Category category) {
		super();
		this.category = category;
	}
	public Product() {
		super();
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}

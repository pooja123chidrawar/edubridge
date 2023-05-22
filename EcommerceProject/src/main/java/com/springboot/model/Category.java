package com.springboot.model;

import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

@Entity
@Table(name="category_table")
public class Category {
	
	@Id
	@SequenceGenerator(name="seq_category",sequenceName="category_sequence",initialValue=1,allocationSize=100)
	@GeneratedValue(generator="seq_category")
	@Column(name="category_id")
	private long categoryId;
	@NotEmpty
	private String categoryName;
	private String categoryDescription;
	
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<Product> product=new ArrayList<Product>();
	
	public List<Product> getProduct() {
		return product;
	}
public Category(long categoryId, String categoryName, String categoryDescription, List<Product> product) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.product = product;
	}
	public Category() {
	super();
    }

	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	

}

package com.springboot.service;

import java.util.List;

import com.springboot.model.Category;

public interface CategoryService {
	public Category saveCategory(Category category);
	public List<Category> getAllCategories();
	public Category getCategoryById(long categoryId);
	public void deleteCategoryById(long categoryId);
	public Category updateCategoryById(Category category,long categoryId);
}


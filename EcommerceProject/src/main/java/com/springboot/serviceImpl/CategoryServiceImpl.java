package com.springboot.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.Category;
import com.springboot.repository.CategoryRepository;
import com.springboot.service.CategoryService;
import com.springboot.service.ProductService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(long categoryId) {
		return categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Id",categoryId));
	}

	@Override
	public void deleteCategoryById(long categoryId) {
		System.out.println("we are in dleete service");
		categoryRepository.findById(categoryId);
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public Category updateCategoryById(Category category,long categoryId) {
		System.out.println("we are in the categservice");
		Category exist=categoryRepository.findById(categoryId).get();
		exist.setCategoryName(category.getCategoryName());
		exist.setCategoryDescription(category.getCategoryDescription());
		return categoryRepository.save(exist);
	}

}

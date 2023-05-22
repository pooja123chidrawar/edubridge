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

import com.springboot.model.Category;
import com.springboot.service.CategoryService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	@PostMapping("api/add/category")
	public ResponseEntity<Category> saveCategory(@Valid @RequestBody Category category){
		return new ResponseEntity<Category>(categoryService.saveCategory(category),HttpStatus.CREATED);
	}
	@GetMapping("api/category")
	public List<Category> getAllCategories(){
		return categoryService.getAllCategories();
	}
	@GetMapping("api/category/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId")long categoryId){
		System.out.println("****"+categoryId);
		return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId),HttpStatus.OK);
	}
	@DeleteMapping("api/category/delete/{categoryId}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("categoryId")long categoryId){
		System.out.println("we are in the delete");
		categoryService.deleteCategoryById(categoryId);
		return new ResponseEntity<String>("category deleted succesfully",HttpStatus.OK);
	}
	@PutMapping("api/category/update/{categoryId}")
	public ResponseEntity<Category> updateCategoryById(@Valid @RequestBody Category category,@PathVariable("categoryId")long categoryId){
		System.out.println("a cat updatecontroller");
		return new ResponseEntity<Category>(categoryService.updateCategoryById(category, categoryId),HttpStatus.OK);
	}

}

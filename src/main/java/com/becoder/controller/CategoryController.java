package com.becoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.becoder.entity.Category;
import com.becoder.service.CategoryService;

@RestController
@RequestMapping(value = "/api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(value = "/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody Category category)
	{
		Boolean isSaved = this.categoryService.saveCategory(category);
		if(isSaved)
			return new ResponseEntity<>("Categroy Saved",HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Categroy not Saved",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@GetMapping(value = "/get-category")
	public ResponseEntity<?> getAllCategory()
	{
		List<Category> allCategories = this.categoryService.getAllCategory();
		
		if(CollectionUtils.isEmpty(allCategories))
			return ResponseEntity.noContent().build();
		else
			return new ResponseEntity<>(allCategories,HttpStatus.OK);
	}

}

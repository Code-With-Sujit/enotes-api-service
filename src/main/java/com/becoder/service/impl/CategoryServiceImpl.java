package com.becoder.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.becoder.entity.Category;
import com.becoder.repository.CategoryRepository;
import com.becoder.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public Boolean saveCategory(Category category) 
	{
		category.setIsDeleted(false);
		category.setCreatedAt(LocalDateTime.now());
		Category savedCategory = this.categoryRepository.save(category);
		if(!ObjectUtils.isEmpty(savedCategory))
		    return true;
		else 
			return false;
	}

	@Override
	public List<Category> getAllCategory() 
	{
		return this.categoryRepository.findAll();
	}

}

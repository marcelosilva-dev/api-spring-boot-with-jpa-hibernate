package com.pbidevs.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbidevs.course.entities.Category;
import com.pbidevs.course.entities.User;
import com.pbidevs.course.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> Category = repository.findById(id);
		
		return Category.get();
	}
	
	public Category insert(Category newCategory) {
		return repository.save(newCategory);
	}
}

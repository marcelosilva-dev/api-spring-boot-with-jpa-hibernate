package com.pbidevs.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pbidevs.course.entities.Category;
import com.pbidevs.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CategoryResourse {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category Category = service.findById(id);
		
		return ResponseEntity.ok().body(Category);
	}
	
	@PostMapping
	public ResponseEntity<Category> insert(@RequestBody Category category) {
		Category newCategory = service.insert(category);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCategory.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newCategory);
	}
}

package com.pbidevs.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.pbidevs.course.entities.Product;
import com.pbidevs.course.entities.User;
import com.pbidevs.course.repositories.ProductRepository;
import com.pbidevs.course.services.exceptions.DatabaseException;
import com.pbidevs.course.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> Product = repository.findById(id);
		
		return Product.get();
	}
	
	public Product insert(Product newProduct) {
		return repository.save(newProduct);
	}
	
	public void delete(Long idProduct) {
		try {
			repository.deleteById(idProduct);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(idProduct);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}

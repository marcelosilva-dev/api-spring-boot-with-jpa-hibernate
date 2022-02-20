package com.pbidevs.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.pbidevs.course.entities.User;
import com.pbidevs.course.repositories.UserRepository;
import com.pbidevs.course.services.exceptions.DatabaseException;
import com.pbidevs.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User findByEmail(String email) {
		User sample = new User();
		sample.setEmail(email); // set some data in sample
		boolean exists = repository.exists(Example.of(sample));
		
		Optional<User> user = repository.findOne(Example.of(sample));
		
		return user.orElseThrow(() -> new ResourceNotFoundException(email));
	}
	
	public User insert(User newUser) {
		return repository.save(newUser);
	}
	
	public void delete(Long idUser) {
		try {
			repository.deleteById(idUser);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(idUser);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(User updatedUser, Long id) {
		try { 
			@SuppressWarnings("deprecation")
			User entity = repository.getOne(id);
			updatedData(entity, updatedUser);
		
			return repository.save(entity);
		
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updatedData(User entity, User updatedUser) {
		entity.setName(updatedUser.getName());
		entity.setEmail(updatedUser.getEmail());
		entity.setPhone(updatedUser.getPhone());
	}
}

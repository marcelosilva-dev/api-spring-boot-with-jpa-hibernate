package com.pbidevs.course.resources;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pbidevs.course.entities.User;
import com.pbidevs.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResourse {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = service.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User newUser) throws UnsupportedEncodingException {
		// hash password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		
		User user = service.insert(newUser);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(uri).body(user);
	}

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@RequestBody User updatedUser, @PathVariable Long id) {
		User user = service.update(updatedUser, id);
		
		return ResponseEntity.ok().body(user);
	}
}

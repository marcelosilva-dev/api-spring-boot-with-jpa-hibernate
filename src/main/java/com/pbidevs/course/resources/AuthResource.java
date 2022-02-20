package com.pbidevs.course.resources;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pbidevs.course.entities.Payment;
import com.pbidevs.course.entities.User;
import com.pbidevs.course.services.PaymentService;
import com.pbidevs.course.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<Boolean> validatePassword(@RequestParam String login,
													@RequestParam String password) throws UnsupportedEncodingException {
		// hash password
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<User> optUser = Optional.ofNullable(service.findByEmail(login));
		
		if (optUser.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		
		boolean valid = false;
		
		User user = optUser.get();
		valid = encoder.matches(password, user.getPassword());
		
		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return ResponseEntity.status(status).body(valid);
	}
}

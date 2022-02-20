package com.pbidevs.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbidevs.course.entities.Payment;
import com.pbidevs.course.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PaymentResourse {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping
	public ResponseEntity<List<Payment>> findAll() {
		List<Payment> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Payment> findById(@PathVariable Long id) {
		Payment Payment = service.findById(id);
		
		return ResponseEntity.ok().body(Payment);
	}
}

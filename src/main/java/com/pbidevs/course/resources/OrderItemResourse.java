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

import com.pbidevs.course.entities.OrderItem;
import com.pbidevs.course.services.OrderItemService;

@RestController
@RequestMapping(value = "/order-item")
public class OrderItemResourse {
	
	@Autowired
	private OrderItemService service;
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> findAll() {
		List<OrderItem> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderItem> findById(@PathVariable Long id) {
		OrderItem OrderItem = service.findById(id);
		
		return ResponseEntity.ok().body(OrderItem);
	}
}

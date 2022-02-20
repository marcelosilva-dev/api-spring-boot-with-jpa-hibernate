package com.pbidevs.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbidevs.course.entities.OrderItem;
import com.pbidevs.course.repositories.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repository;
	
	public List<OrderItem> findAll() {
		return repository.findAll();
	}
	
	public OrderItem findById(Long id) {
		Optional<OrderItem> OrderItem = repository.findById(id);
		
		return OrderItem.get();
	}
}

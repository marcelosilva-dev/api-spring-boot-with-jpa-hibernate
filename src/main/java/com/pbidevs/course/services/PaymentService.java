package com.pbidevs.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbidevs.course.entities.Payment;
import com.pbidevs.course.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;
	
	public List<Payment> findAll() {
		return repository.findAll();
	}
	
	public Payment findById(Long id) {
		Optional<Payment> Payment = repository.findById(id);
		
		return Payment.get();
	}
}

package com.pbidevs.course.resources;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbidevs.course.resources.extra.Root;

@RestController
@RequestMapping(value = "/")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RootResourse {
	
	@GetMapping
	public ResponseEntity<Root> findAll() {
		Root root = new Root();
		root.setTitle("Bem vindos a api rest com spring-boot e jpa, no momento temos ativos os seguintes comandos: ");
		root.setGetUsers("GET: /users ou /users/{id}");
		root.setPostUsers("POST /users");
		root.setPutUsers("PUT: /users/{id}");
		root.setDeleteUsers("DELETE /users/{id}");
		root.setAddress("De uma olhada no repositório do projeto no github: https://github.com/marcelosilva-dev/api-spring-boot-with-jpa-hibernate");
		
		return ResponseEntity.ok().body(root);
	}
}

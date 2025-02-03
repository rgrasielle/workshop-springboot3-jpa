package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

// Implementa 2 operações básicas: buscar todos os usuários e buscar usuário por ID

@Service  // registra como componente do Spring
public class ProductService {
	
	@Autowired // injeção de dependência automática
	private ProductRepository repository; // dependência para ProductRepository
	
	// Método para retornar todos os usuários
	public List<Product> findAll() {
		return repository.findAll();  // repassa a chamada para repository.findAll()
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();  // retorna o objeto Product que estiver dentro do Optional 
	}
}

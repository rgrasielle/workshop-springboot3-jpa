package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

// Implementa 2 operações básicas: buscar todos os usuários e buscar usuário por ID

@Service  // registra como componente do Spring
public class OrderService {
	
	@Autowired // injeção de dependência automática
	private OrderRepository repository; // dependência para OrderRepository
	
	// Método para retornar todos os usuários
	public List<Order> findAll() {
		return repository.findAll();  // repassa a chamada para repository.findAll()
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();  // retorna o objeto Order que estiver dentro do Optional 
	}
}

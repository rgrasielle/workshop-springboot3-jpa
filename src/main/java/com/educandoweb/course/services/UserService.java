package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

// Implementa 2 operações básicas: buscar todos os usuários e buscar usuário por ID

@Service  // registra como componente do Spring
public class UserService {
	
	@Autowired // injeção de dependência automática
	private UserRepository repository; // dependência para UserRepository
	
	// Método para retornar todos os usuários
	public List<User> findAll() {
		return repository.findAll();  // repassa a chamada para repository.findAll()
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();  // retorna o objeto User que estiver dentro do Optional 
	}
}

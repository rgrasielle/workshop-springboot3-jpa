package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

// Implementa 2 operações básicas: buscar todos os usuários e buscar usuário por ID

@Service  // registra como componente do Spring
public class CategoryService {
	
	@Autowired // injeção de dependência automática
	private CategoryRepository repository; // dependência para CategoryRepository
	
	// Método para retornar todos os usuários
	public List<Category> findAll() {
		return repository.findAll();  // repassa a chamada para repository.findAll()
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();  // retorna o objeto Category que estiver dentro do Optional 
	}
}

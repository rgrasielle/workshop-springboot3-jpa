package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

// Implementa 2 operações básicas: buscar todos os usuários e buscar usuário por ID

@Service  // registra como componente do Spring
public class UserService {
	
	@Autowired // injeção de dependência automática
	private UserRepository repository; // dependência para UserRepository
	
	// Método para retornar todos os usuários
	public List<User> findAll() {
		return repository.findAll();  // repassa a chamada para repository.findAll()
	}
	
	// Método para retornar usuários por id
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));  
	} 
	
	// Método para salvar um usuário no banco de dados
	public User insert(User obj) {
		return repository.save(obj);  // retorna o obj salvo
	}
	
	// Método para deletar um usuário
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	// Método para atualizar um usuário
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	// Atualiza os dados do entity baseado nos dados que chegaram no obj
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
}

package com.Polsoftex.Users.service;

import com.Polsoftex.Users.model.User;
import com.Polsoftex.Users.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService{

	@Autowired
	private UsersRepository repository;
	
	@Override
	public List<User> findAll() {
		var users = (List<User>) repository.findAll();
		return users;
	}
	
	@Override
	public User save(User newUser) {
		return repository.save(newUser);
	}
	
	@Override
	public Optional<User> findById(Long userId){
		return repository.findById(userId);
	}


	@Override
	public Optional<User> findByUsername(String username){
		return repository.findByUsername(username);
	}
	
	@Override
	public void deleteById(Long userId){
		repository.deleteById(userId);
	}
	
	@Override
	public User update(Long updId, User updUser) {
		User myUser = repository.findById(updId).get();
		myUser.setUsername(updUser.getUsername());
		myUser.setAddress(updUser.getAddress());
		myUser.setPassword(updUser.getPassword());
		myUser.setElevation(updUser.getElevation());
		return repository.save(myUser);
	}
}

package com.Polsoftex.Users.service;

import com.Polsoftex.Users.model.User;
import com.Polsoftex.Users.repository.UsersRepository;

import java.util.List;

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
}

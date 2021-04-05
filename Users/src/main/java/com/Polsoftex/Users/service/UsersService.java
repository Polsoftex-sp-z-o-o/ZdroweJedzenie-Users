package com.Polsoftex.Users.service;

import com.Polsoftex.Users.model.Users;
import com.Polsoftex.Users.repository.UsersRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService{

	@Autowired
	private UsersRepository repository;
	
	@Override
	public List<Users> findAll() {
		var users = (List<Users>) repository.findAll();
		return users;
	}
}

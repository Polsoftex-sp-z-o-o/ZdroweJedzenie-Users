package com.Polsoftex.Users.service;

import com.Polsoftex.Users.model.User;

import java.util.List;
import java.util.Optional;

public interface IUsersService {
	
	List<User> findAll();
	
	User save(User newUser);
	
	Optional<User> findById(Long userId);

	Optional<User> findByUsername(String username);
	
	void deleteById(Long userId);
	
	User update(Long updId, User updUser);
}

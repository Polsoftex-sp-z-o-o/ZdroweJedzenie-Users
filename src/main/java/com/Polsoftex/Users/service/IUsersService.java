package com.Polsoftex.Users.service;

import com.Polsoftex.Users.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUsersService {
	
	List<User> findAll();
	
	User save(User newUser);
	
	Optional<User> findById(UUID userId);

	Optional<User> findByEmail(String email);
	
	void deleteById(UUID userId);
	
	User update(UUID updId, User updUser);
}

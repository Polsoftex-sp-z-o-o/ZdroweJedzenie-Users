package com.Polsoftex.Users.controller;

import com.Polsoftex.Users.model.User;
import com.Polsoftex.Users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersController {
	
	private final UsersRepository repository;
	
	@Autowired
	public UsersController(UsersRepository repository){
		this.repository = repository;
	}
	
	@GetMapping(value="/users/{userId}")
	@ResponseBody
	public ResponseEntity<User> findUser(@PathVariable Long userId){
		Optional<User> user= repository.findById(userId);
		return new ResponseEntity<>(user.get(), HttpStatus.OK);
	}
	
	@PostMapping(value="/users")
	@ResponseBody
	public ResponseEntity<String> createUser (@RequestBody User newUser){
		repository.save(newUser);
		return new ResponseEntity<>("Created user.", HttpStatus.CREATED);
	}

}

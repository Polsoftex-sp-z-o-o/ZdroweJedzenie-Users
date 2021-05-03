package com.Polsoftex.Users.controller;

import com.Polsoftex.Users.dto.CreateUser;
import com.Polsoftex.Users.model.User;
import com.Polsoftex.Users.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.UUID;

@RestController
public class UsersController {
	
	private final UsersService service;
	
	@Autowired
	public UsersController(UsersService service){
		this.service = service;
	}
	
	@GetMapping(value="/users/{userId}")
	@ResponseBody
	public ResponseEntity<Object> findUser(@PathVariable UUID userId){
		Optional<User> user= service.findById(userId);
		if(!user.isPresent()) {
			return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user.get(), HttpStatus.OK);
	}

	@GetMapping(value="/users/find/{email}")
	@ResponseBody
	public ResponseEntity<Object> findUser(@PathVariable String email){
		Optional<User> user= service.findByEmail(email);
		if(!user.isPresent()) {
			return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user.get(), HttpStatus.OK);
	}

	@PostMapping(value="/users", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> updateUser(@RequestBody CreateUser newUser){
		if(!newUser.validatePassword())
			return new ResponseEntity<>("Password does not match", HttpStatus.UNPROCESSABLE_ENTITY);
		service.save(newUser.buildEntity());
		return new ResponseEntity<>("Created user.", HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/users/{userId}")
	@ResponseBody
	public ResponseEntity<String> deleteUser(@PathVariable UUID userId){
		Optional<User> user= service.findById(userId);
		if(!user.isPresent()) {
			return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
		}
		service.deleteById(userId);
		return new ResponseEntity<>("Deleted.", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value="/users/{userId}")
	@ResponseBody
	public ResponseEntity<String> updateUser(@PathVariable UUID userId, @RequestBody CreateUser updUser){
		Optional<User> user= service.findById(userId);
		if(!user.isPresent()) {
			return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
		}
		if(!updUser.validatePassword())
			return new ResponseEntity<>("Password does not match", HttpStatus.UNPROCESSABLE_ENTITY);
		service.update(userId, updUser.buildEntity());
		return new ResponseEntity<>("Updated.", HttpStatus.OK);
	}
}

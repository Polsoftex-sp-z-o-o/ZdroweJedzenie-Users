package com.Polsoftex.Users.service;

import com.Polsoftex.Users.model.Role;
import com.Polsoftex.Users.model.User;
import com.Polsoftex.Users.repository.RolesRepository;
import com.Polsoftex.Users.repository.UsersRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements IUsersService{

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public List<User> findAll() {
		var users = (List<User>) usersRepository.findAll();
		return users;
	}
	
	@Override
	public User save(User newUser) {
		List<Role> defaultRoles = rolesRepository.findByDefaultRoleTrue();
		User addedUser = usersRepository.save(newUser);

		for(Role role: defaultRoles){
			role.getUsers().add(addedUser);
		}

		rolesRepository.saveAll(defaultRoles);

		return addedUser;
	}
	
	@Override
	public Optional<User> findById(UUID userId){
		return usersRepository.findById(userId);
	}

	@Override
	public Optional<User> findByEmail(String email){
		return usersRepository.findByEmail(email);
	}
	
	@Override
	public void deleteById(UUID userId){
		usersRepository.deleteById(userId);
	}
	
	@Override
	public User update(UUID updId, User updUser) {
		User myUser = usersRepository.findById(updId).get();
		myUser.setEmail(updUser.getEmail());
		myUser.setAddress(updUser.getAddress());
		myUser.setPassword(updUser.getPassword());
		myUser.setFirstName(updUser.getFirstName());
		myUser.setLastName(updUser.getLastName());
		return usersRepository.save(myUser);
	}
}

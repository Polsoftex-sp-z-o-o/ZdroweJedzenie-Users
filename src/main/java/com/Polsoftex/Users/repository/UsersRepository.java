package com.Polsoftex.Users.repository;

import com.Polsoftex.Users.model.User;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, UUID>{

}

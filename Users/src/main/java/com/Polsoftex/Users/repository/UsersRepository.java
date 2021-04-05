package com.Polsoftex.Users.repository;

import com.Polsoftex.Users.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>{

}

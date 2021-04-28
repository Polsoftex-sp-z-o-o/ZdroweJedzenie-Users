package com.Polsoftex.Users.repository;

import com.Polsoftex.Users.model.Role;
import com.Polsoftex.Users.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RolesRepository extends CrudRepository<Role, String> {
    List<Role> findByDefaultRoleTrue();
}

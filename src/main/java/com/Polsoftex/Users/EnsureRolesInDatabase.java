package com.Polsoftex.Users;

import com.Polsoftex.Users.model.Role;
import com.Polsoftex.Users.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class EnsureRolesInDatabase {
    @Autowired
    private RolesRepository rolesRepository;

    @PostConstruct
    public void init(){
        EnsureRoleExist("ROLE_ADMIN", false);
        EnsureRoleExist("ROLE_USER", true);
    }

    private void EnsureRoleExist(String roleName, boolean roleDefault){
        Optional<Role> adminRole = rolesRepository.findById(roleName);

        if(adminRole.isPresent())
            return;

        rolesRepository.save(new Role(roleName, roleDefault));
    }
}

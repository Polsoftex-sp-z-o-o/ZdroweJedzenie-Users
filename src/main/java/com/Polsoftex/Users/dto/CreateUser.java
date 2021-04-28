package com.Polsoftex.Users.dto;

import com.Polsoftex.Users.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {
    private String email;
    private String address;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;

    public boolean validatePassword(){
        if(confirmPassword == null)
            return false;

        return confirmPassword.equals(password);
    }

    public User buildEntity(){
        UUID entityId = UUID.randomUUID();
        return new User(entityId,email, firstName, lastName, address, password, new HashSet<com.Polsoftex.Users.model.Role>());
    }

}

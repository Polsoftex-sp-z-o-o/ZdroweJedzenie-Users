package com.Polsoftex.Users.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="roles")
@Entity
@NoArgsConstructor
public class Role {
    @Id
    @Getter
    private String name;

    @Getter(onMethod_ = @JsonIgnore)
    private boolean defaultRole;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "role_name"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @Getter(onMethod_ = @JsonIgnore)
    private Set<User> users;

    public Role(String name, boolean defaultRole){
        this.defaultRole = defaultRole;
        this.name = name;
        this.users = new HashSet<>();
    }




}

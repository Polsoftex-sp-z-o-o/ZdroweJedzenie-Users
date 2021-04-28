package com.Polsoftex.Users.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;


@Table(name="users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID id;
	
	@Column(name="email", unique=true, nullable = false)
	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String address;

	@Column(nullable = false)
	private String password;

	@ManyToMany(mappedBy = "users")
	private Set<Role> roles;

}

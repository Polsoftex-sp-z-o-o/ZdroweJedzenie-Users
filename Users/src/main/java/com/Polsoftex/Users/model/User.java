package com.Polsoftex.Users.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name="users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@JsonCreator
	public User(@JsonProperty("username") String username, @JsonProperty("address") String address, @JsonProperty("password") String password, @JsonProperty("elevation") Boolean elevation) {
		this.username = username;
		this.address = address;
		this.password = password;
		this.elevation = elevation;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String username;

	private String address;

	private String password;
	
	private Boolean elevation;

}

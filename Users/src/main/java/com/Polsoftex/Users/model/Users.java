package com.Polsoftex.Users.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Users {
	
	public Users(String username, String address, String password, Boolean elevation) {
		this.username = username;
		this.address = address;
		this.password = password;
		this.elevation = elevation;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private final String username;
	
	private String address;
	
	private String password;
	
	private Boolean elevation;

}

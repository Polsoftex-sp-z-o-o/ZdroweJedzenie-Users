package com.Polsoftex.Users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.Polsoftex.Users.controller.UsersController;
import com.Polsoftex.Users.model.User;
import com.Polsoftex.Users.service.UsersService;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;
import java.util.UUID;

@WebMvcTest(UsersController.class)
public class HttpRequestTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UsersService service;
	
	@Test
	public void returnUserSuccessByIdTest() throws Exception{
		User user = new User();
		user.setId(UUID.randomUUID());
		UUID uuid = user.getId();
		user.setUsername("JanKowalski2");
		user.setAddress("Radom ul. Mickiewicza 2/5");
		user.setPassword("abcd");
		user.setElevation(false);
		
		when(service.findById(any(UUID.class))).thenReturn(Optional.of(user));
		
		this.mockMvc.perform(get("/users/{uuid}", uuid.toString())
				.contentType(APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username").value("JanKowalski2"))
				.andExpect(jsonPath("$.address").value("Radom ul. Mickiewicza 2/5"))
				.andExpect(jsonPath("$.password").value("abcd"))
				.andExpect(jsonPath("$.elevation").value(false));
	}
}

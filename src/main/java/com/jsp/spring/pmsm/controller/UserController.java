package com.jsp.spring.pmsm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring.pmsm.model.User;
import com.jsp.spring.pmsm.service.UserService;
import com.jsp.spring.pmsm.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody @Valid User user) {
		return userService.saveUser(user);
	}
}

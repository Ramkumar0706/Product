package com.jsp.spring.pmsm.service;

import org.springframework.http.ResponseEntity;

import com.jsp.spring.pmsm.model.User;
import com.jsp.spring.pmsm.utility.ResponseStructure;

public interface UserService {

	public ResponseEntity<ResponseStructure<User>> saveUser(User user);

}

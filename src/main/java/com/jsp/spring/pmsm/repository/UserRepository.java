package com.jsp.spring.pmsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.spring.pmsm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}

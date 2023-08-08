package com.alpha.lms.service;

import java.util.List;

import com.alpha.lms.entity.User;

// UserDTO is used in real time projects
public interface UserService {

	List<User> findAll();
	
	User save(User user);
}

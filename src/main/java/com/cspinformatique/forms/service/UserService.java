package com.cspinformatique.forms.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cspinformatique.forms.model.User;

public interface UserService extends UserDetailsService {
	User findByUsername(String username);
	
	User findOne(int id);
	
	User save(User user);
}

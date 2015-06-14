package com.cspinformatique.forms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cspinformatique.forms.model.User;
import com.cspinformatique.forms.repository.UserRepository;
import com.cspinformatique.forms.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public User findOne(int id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public User save(User user) {
		user.setPassword(this.findOne(user.getId()).getPassword());

		return this.userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			return userRepository.findByUsername(username);
		} catch (EmptyResultDataAccessException emptyResultDataAccessEx) {
			throw new UsernameNotFoundException("Username " + username
					+ " could not be found.", emptyResultDataAccessEx);
		}
	}
}

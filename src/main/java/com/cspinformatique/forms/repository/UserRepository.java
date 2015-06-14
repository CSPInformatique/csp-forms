package com.cspinformatique.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cspinformatique.forms.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}

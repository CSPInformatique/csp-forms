package com.cspinformatique.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cspinformatique.forms.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
	
}

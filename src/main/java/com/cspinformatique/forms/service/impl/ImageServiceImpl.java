package com.cspinformatique.forms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cspinformatique.forms.model.Image;
import com.cspinformatique.forms.repository.ImageRepository;
import com.cspinformatique.forms.service.ImageService;

@Controller
public class ImageServiceImpl implements ImageService {
	@Autowired private ImageRepository imageRepository;
	
	@Override
	public Image findOne(int id) {
		return this.imageRepository.findOne(id);
	}

	@Override
	public Image save(Image image) {
		return this.imageRepository.save(image);
	}

}

package com.cspinformatique.forms.service;

import com.cspinformatique.forms.model.Image;

public interface ImageService {
	Image findOne(int id);

	Image save(Image image);
}

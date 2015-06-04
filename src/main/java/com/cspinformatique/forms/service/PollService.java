package com.cspinformatique.forms.service;

import java.util.List;

import com.cspinformatique.forms.model.Poll;

public interface PollService {
	List<Poll> findAll();
	
	Poll findOne(int id);
	
	Poll save(Poll poll);
}

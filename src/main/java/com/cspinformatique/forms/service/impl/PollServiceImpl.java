package com.cspinformatique.forms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cspinformatique.forms.model.Poll;
import com.cspinformatique.forms.repository.PollRepository;
import com.cspinformatique.forms.service.PollService;

@Service
public class PollServiceImpl implements PollService {
	@Autowired private PollRepository pollRepository;
	
	@Override
	public List<Poll> findAll() {
		return pollRepository.findAll();
	}
	
	@Override
	public Poll findOne(int id){
		return this.pollRepository.findOne(id);
	}

	@Override
	public Poll save(Poll poll) {
		return pollRepository.save(poll);
	}

}

package com.cspinformatique.forms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cspinformatique.forms.model.PollParticipantAnswers;
import com.cspinformatique.forms.repository.PollParticipantAnswersRepostiory;
import com.cspinformatique.forms.service.PollParticipantAnswersService;

@Service
public class PollParticipantAnswersServiceImpl implements
		PollParticipantAnswersService {
	@Autowired
	private PollParticipantAnswersRepostiory pollParticipantAnswersRepository;

	@Override
	public PollParticipantAnswers save(
			PollParticipantAnswers pollParticipantAnswers) {
		return this.pollParticipantAnswersRepository
				.save(pollParticipantAnswers);
	}

}

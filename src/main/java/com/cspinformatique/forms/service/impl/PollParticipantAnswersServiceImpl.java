package com.cspinformatique.forms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cspinformatique.forms.model.Poll;
import com.cspinformatique.forms.model.PollParticipantAnswers;
import com.cspinformatique.forms.repository.PollParticipantAnswersRepostiory;
import com.cspinformatique.forms.service.PollParticipantAnswersService;

@Service
public class PollParticipantAnswersServiceImpl implements
		PollParticipantAnswersService {
	@Autowired
	private PollParticipantAnswersRepostiory pollParticipantAnswersRepository;

	@Override
	public List<PollParticipantAnswers> findAll() {
		return this.pollParticipantAnswersRepository.findAll();
	}

	@Override
	public Page<PollParticipantAnswers> findByPoll(Poll poll, Pageable pageable) {
		return this.pollParticipantAnswersRepository.findByPoll(poll, pageable);
	}

	@Override
	public PollParticipantAnswers findOne(int id) {
		return this.pollParticipantAnswersRepository.findOne(id);
	}

	@Override
	public PollParticipantAnswers save(
			PollParticipantAnswers pollParticipantAnswers) {
		return this.pollParticipantAnswersRepository
				.save(pollParticipantAnswers);
	}

}

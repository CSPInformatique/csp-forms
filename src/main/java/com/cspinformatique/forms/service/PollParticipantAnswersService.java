package com.cspinformatique.forms.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cspinformatique.forms.model.Poll;
import com.cspinformatique.forms.model.PollParticipantAnswers;

public interface PollParticipantAnswersService {
	List<PollParticipantAnswers> findAll();
	
	Page<PollParticipantAnswers> findByPoll(Poll poll, Pageable pageable);
	
	PollParticipantAnswers findOne(int id);
	
	PollParticipantAnswers save(PollParticipantAnswers pollParticipantAnswers);
}

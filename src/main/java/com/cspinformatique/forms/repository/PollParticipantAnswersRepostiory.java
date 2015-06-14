package com.cspinformatique.forms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cspinformatique.forms.model.Poll;
import com.cspinformatique.forms.model.PollParticipantAnswers;

public interface PollParticipantAnswersRepostiory extends JpaRepository<PollParticipantAnswers, Integer> {
	Page<PollParticipantAnswers> findByPoll(Poll poll, Pageable pageable);
}

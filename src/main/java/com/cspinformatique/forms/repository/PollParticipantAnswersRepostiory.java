package com.cspinformatique.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cspinformatique.forms.model.PollParticipantAnswers;

public interface PollParticipantAnswersRepostiory extends JpaRepository<PollParticipantAnswers, Integer> {

}

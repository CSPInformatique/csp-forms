package com.cspinformatique.forms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cspinformatique.forms.model.Poll;

public interface PollRepository extends JpaRepository<Poll, Integer> {

}

package com.cspinformatique.forms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cspinformatique.forms.model.PollParticipantAnswers;
import com.cspinformatique.forms.service.PollParticipantAnswersService;

@Controller
@RequestMapping("/pollParticipantAnswers")
public class PollParticipantAnswersController {
	@Autowired
	private PollParticipantAnswersService pollParticipantAnswersService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<PollParticipantAnswers> findAll() {
		return this.pollParticipantAnswersService.findAll();
	}

	@RequestMapping(value = "/{id}", produces = MediaType.TEXT_HTML_VALUE)
	public String getPollParticipantAnswersPage() {
		return "poll-participant-answers";
	}

	@RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PollParticipantAnswers findOne(@PathVariable int id) {
		return pollParticipantAnswersService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PollParticipantAnswers save(
			@RequestBody PollParticipantAnswers pollParticipantAnswers) {
		return this.pollParticipantAnswersService.save(pollParticipantAnswers);
	}
}

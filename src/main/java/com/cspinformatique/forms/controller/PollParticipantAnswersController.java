package com.cspinformatique.forms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PollParticipantAnswers save(
			@RequestBody PollParticipantAnswers pollParticipantAnswers) {
		return this.pollParticipantAnswersService.save(pollParticipantAnswers);
	}
}

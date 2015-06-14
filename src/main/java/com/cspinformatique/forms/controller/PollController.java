package com.cspinformatique.forms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cspinformatique.forms.model.Poll;
import com.cspinformatique.forms.model.PollParticipantAnswers;
import com.cspinformatique.forms.service.PollParticipantAnswersService;
import com.cspinformatique.forms.service.PollService;

@Controller
@RequestMapping({ "/poll" })
public class PollController {
	@Autowired
	private PollService pollService;

	@Autowired
	private PollParticipantAnswersService pollParticipantAnswersService;

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Poll> findAll() {
		return this.pollService.findAll();
	}

	@RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Poll findOne(@PathVariable int id) {
		return this.pollService.findOne(id);
	}

	@RequestMapping(value = "/{id}/pollParticipantAnswers", produces = MediaType.TEXT_HTML_VALUE)
	public String getPollParticipantsAnswersPage() {
		return "poll-participants-answers";
	}

	@RequestMapping(value = "/{id}/pollParticipantAnswers", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Page<PollParticipantAnswers> findPollParticipantsAnswers(
			@PathVariable int id,
			@RequestParam(required = false) String status,
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "50") Integer resultPerPage,
			@RequestParam(defaultValue = "DESC") Direction direction,
			@RequestParam(defaultValue = "id") String sortBy) {
		return pollParticipantAnswersService.findByPoll(this.pollService
				.findOne(id), new PageRequest(page, resultPerPage, direction,
				sortBy));
	}
}

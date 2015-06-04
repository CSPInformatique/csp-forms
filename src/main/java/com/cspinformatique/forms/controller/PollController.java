package com.cspinformatique.forms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cspinformatique.forms.model.Poll;
import com.cspinformatique.forms.service.PollService;

@Controller
@RequestMapping({"/", "/poll"})
public class PollController {
	@Autowired
	private PollService pollService;

	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
	public String getPollsPage() {
		return "poll";
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Poll> findAll() {
		return this.pollService.findAll();
	}

	@RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Poll findOne(@PathVariable int id) {
		return this.pollService.findOne(id);
	}
}

package com.cspinformatique.forms.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class NavigationController {

	@RequestMapping(value="/admin", produces = MediaType.TEXT_HTML_VALUE)
	public String getAdminPage(){
		return "poll-participants-answers";
	}
	
	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
	public String getPollsPage() {
		return "poll";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginPage(){
		return "login";
	}
}

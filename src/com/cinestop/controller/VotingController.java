package com.cinestop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class VotingController {
	@RequestMapping(method = RequestMethod.POST, value = "/voting")
	@ResponseStatus(value = HttpStatus.OK)
	public void setVotes(@RequestParam String mediaName, @RequestParam String action) {
		
	}
}

package com.cinestop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView displayCinestopHomePage() {
		return new ModelAndView("home");
	}
}
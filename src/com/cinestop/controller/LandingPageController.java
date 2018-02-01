package com.cinestop.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LandingPageController {
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public void landingPageController(HttpServletResponse response) {
		try {
			response.sendRedirect("/home");
		} catch (IOException e) {
			//log.error("Exception in landing page controller", e);
		}
	}

}

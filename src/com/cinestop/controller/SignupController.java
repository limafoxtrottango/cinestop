package com.cinestop.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinestop.dao.DBQuery;
import com.cinestop.model.UserModel;

@Controller
public class SignupController {
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView showSignupPage() {
		ModelAndView mav = new ModelAndView("signup");
		mav.addObject("user", UserModel.builder().userName(null).password(null).build());
		return mav;
	}
	
	@RequestMapping(value = "/checkUsername", method = RequestMethod.POST)
	public ResponseEntity<?> checkUserNameAvailability(final String username) throws SQLException, ClassNotFoundException {
		DBQuery dbQuery = new DBQuery();
		ResultSet rs = dbQuery.checkUsernameAvailability(username);
		if (!rs.isBeforeFirst()) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
	public ModelAndView registetUser(@ModelAttribute("user") UserModel user) {
		return new ModelAndView("home");
	}
}

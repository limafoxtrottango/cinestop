package com.cinestop.controller;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinestop.dao.DBQuery;

@Controller
public class SearchResourceController {
	
	@Autowired
	DBQuery dbQuery;

	/**
	 * Controller to search a movie or series from the database. If not present,
	 * then call the OMDb api to fetch the data and persist it. Then, display it to
	 * the user
	 * 
	 * @param name
	 * @param type
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/searchResource")
	public void searchAndShowResource(@RequestParam String name, @RequestParam String type) {
		ResultSet rs;
		if("movie".equals(type)) {
			rs = dbQuery.getMovieInfo(name);
			if(rs==null) {
				//display some error occured while fetching data jsp
			} else {
				
			}
		} else if("series".equals(type)) {
			rs = dbQuery.getSeriesInfo(name);
			if(rs==null) {
				//display some error occured while fetching data jsp
			} else {
				
			}
		}
	}

}

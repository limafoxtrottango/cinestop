package com.cinestop.controller;

import java.sql.SQLException;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinestop.config.AdditionalConfig;
import com.cinestop.config.MovieInfoDaoImplConfig;
import com.cinestop.dao.MovieInfoDaoImpl;
import com.cinestop.model.MovieInfoModel;

@Controller
public class SearchResourceController {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MovieInfoDaoImplConfig.class);
	AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(AdditionalConfig.class);
	MovieInfoDaoImpl movieInfoDaoImpl = (MovieInfoDaoImpl) context.getBean("movieInfoDaoImpl");
	ObjectMapper objectMapper = (ObjectMapper) context2.getBean("objectMapper");

	/**
	 * Controller to search a movie or series from the database based on its cinestopId
	 * 
	 * @param name
	 * @param type
	 * @throws SQLException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/searchMovie")
	public ModelAndView searchAndDisplayResource(@RequestParam String cinestopId) throws SQLException {
		ModelAndView mav = new ModelAndView("mediainfo");
		MovieInfoModel movieInfoModel = movieInfoDaoImpl.getMovieInfo(cinestopId);
		mav.addObject("mediaInfo", movieInfoModel);
		return mav;
	}
}

package com.cinestop.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinestop.config.MovieInfoDaoImplConfig;
import com.cinestop.dao.MovieInfoDaoImpl;
import com.cinestop.model.MovieInfoModel;

@Controller
public class SearchResourceController {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MovieInfoDaoImplConfig.class);
	MovieInfoDaoImpl movieInfoDaoImpl = (MovieInfoDaoImpl) context.getBean("movieInfoDaoImpl");

	/**
	 * Controller to search a movie or series from the database based on its tmdb id
	 * 
	 * @param name
	 * @param type
	 * @throws SQLException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/searchMovie")
	public ModelAndView searchAndDisplayResource(@RequestParam String tmdbId) throws SQLException {
		ModelAndView mav = new ModelAndView("mediainfo");
		List<MovieInfoModel> movieInfoModelsList = movieInfoDaoImpl.getMovieInfo(tmdbId);
		mav.addObject("mediaInfo", movieInfoModelsList.get(0));
		return mav;
	}

}

package com.cinestop.controller;

import java.sql.SQLException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cinestop.config.AdditionalConfig;
import com.cinestop.config.MovieInfoDaoImplConfig;
import com.cinestop.dao.MovieInfoDaoImpl;
import com.cinestop.model.MovieInfoModel;
import com.cinestop.model.MovieInfoModelList;
import com.cinestop.model.MovieQueryModel;

@Controller
public class SearchResourceController {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MovieInfoDaoImplConfig.class);
	AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(AdditionalConfig.class);
	MovieInfoDaoImpl movieInfoDaoImpl = (MovieInfoDaoImpl) context.getBean("movieInfoDaoImpl");
	ObjectMapper objectMapper = (ObjectMapper) context2.getBean("objectMapper");

	/**
	 * Controller to search a movie or series from the database based on its
	 * cinestopId
	 * 
	 * @param name
	 * @param type
	 * @throws SQLException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/searchMoviea")
	public ModelAndView searchAndDisplayResource(@RequestParam String cinestopId) throws SQLException {
		ModelAndView mav = new ModelAndView("mediainfo");
		MovieInfoModel movieInfoModel = movieInfoDaoImpl.getMovieInfo(cinestopId);
		mav.addObject("mediaInfo", movieInfoModel);
		return mav;
	}

	/**
	 * Controller to search for the queried movie. Have to take care of spelling
	 * mistakes etc. In the end, display all the matching movies as a list
	 * 
	 * @param movieQuery
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/searchMovie")
	public List<MovieInfoModelList> displayMatchingMovies(@RequestBody final MovieQueryModel movieQuery) {
		return movieInfoDaoImpl.getMovieInfoForListing(movieQuery.getTitle(), movieQuery.getFromPage(),
				movieQuery.getToPage());
	}
}

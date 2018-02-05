package com.cinestop.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinestop.dao.DBQuery;
import com.cinestop.helper.MediaInfoHelper;
import com.cinestop.model.MediaInfoModel;

@Controller
public class SearchResourceController {


	/**
	 * Controller to search a movie or series from the database. If not present,
	 * then call the OMDb api to fetch the data and persist it. Then, display it to
	 * the user
	 * 
	 * @param name
	 * @param type
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/searchMedia")
	public ModelAndView searchAndDisplayResource(@RequestParam String name, @RequestParam String type)
			throws SQLException, MalformedURLException, IOException, ProtocolException, ClassNotFoundException {
		ResultSet rs;
		DBQuery dbQuery = new DBQuery();
		rs = dbQuery.getMediaInfo(name, type);
		if (!rs.isBeforeFirst()) {
		//	String mediaInfoJson = omdbApiHelper.getMediaDetail(name);
			//parse the json, create the mio and persist
			return null;
		} else {
			MediaInfoHelper mediaInfoHelper = new MediaInfoHelper();
			ArrayList<MediaInfoModel> mediaList = mediaInfoHelper.getQueriedMediaList(rs);
			System.out.println(mediaList.size());
			ModelAndView mav = new ModelAndView("mediainfo");
			mav.addObject("mediaList",mediaList);
			return mav;
		}

	}

}

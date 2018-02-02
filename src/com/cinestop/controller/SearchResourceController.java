package com.cinestop.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinestop.dao.DBQuery;
import com.cinestop.helper.MediaInfoHelper;
import com.cinestop.model.MediaInfoModel;

@Controller
public class SearchResourceController {

	@Autowired
	private DBQuery dbQuery;
	
	@Autowired
	private MediaInfoHelper mediaInfoHelper;

	/**
	 * Controller to search a movie or series from the database. If not present,
	 * then call the OMDb api to fetch the data and persist it. Then, display it to
	 * the user
	 * 
	 * @param name
	 * @param type
	 * @throws SQLException 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/searchResource")
	public void searchAndDisplayResource(@RequestParam String name, @RequestParam String type) throws SQLException {
		ResultSet rs;
		rs = dbQuery.getMediaInfo(name, type);
		if(!rs.isBeforeFirst()) {
			//no results found jsp
		} else if (null == rs) {
			
		} else {
			ArrayList<MediaInfoModel> mediaList = mediaInfoHelper.getQueriedMediaList(rs);
		}

	}
	
	@ExceptionHandler(SQLException.class)
	private void handleSQLException(SQLException e) {
		e.printStackTrace();
	}

}

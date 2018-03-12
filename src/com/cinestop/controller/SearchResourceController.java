package com.cinestop.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinestop.dao.DBQuery;
import com.cinestop.helper.MediaInfoHelper;
import com.cinestop.model.MediaInfoModel;
import com.cinestop.model.ReviewRogEbe;

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

			return null;
		} else {
			MediaInfoHelper mediaInfoHelper = new MediaInfoHelper();
			MediaInfoModel mediaInfoModel = mediaInfoHelper.getQueriedMediaInfoModel(rs);
			ResultSet rs2 = dbQuery.getRogerEbertReviews(mediaInfoModel.getTitle());
			rs2.next();
			String rogerReview = rs2.getString("review").toString();
			int parts = rogerReview.length()/2;
			String[] reviewParts = rogerReview.split("(?s)(?<=\\G.{"+parts+"})");
			System.out.println(reviewParts.length);
			ReviewRogEbe roger = ReviewRogEbe.builder()
					.reviewer(StringEscapeUtils.unescapeHtml(rs2.getString("reviewer")))
					.rating(StringEscapeUtils.unescapeHtml(rs2.getString("rating")))
					.review_col_1(reviewParts[0])
					.review_col_2(reviewParts[1])
					.build();
			ModelAndView mav = new ModelAndView("mediainfo");
			mav.addObject("mediaInfo", mediaInfoModel);
			mav.addObject("roger", roger);
			return mav;
		}

	}

}

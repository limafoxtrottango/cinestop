package com.cinestop.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cinestop.dao.DBQuery;
import com.cinestop.helper.MediaInfoHelper;
import com.cinestop.model.MediaInfoModel;
import com.cinestop.model.PrefetchMediaModel;

@Controller
public class HomePageController {

	@RequestMapping("/home")
	public ModelAndView helloWorld() {
		return new ModelAndView("home");
	}

//	@RequestMapping(method = RequestMethod.POST, value = "/getMatchingList")
//	public @ResponseBody List<String> getSearchListAutocomplete(
//			@RequestBody List<PrefetchMediaModel> prefetchMediaModel) throws SQLException, ClassNotFoundException {
//		DBQuery dbQuery = new DBQuery();
//		ResultSet rs = dbQuery.getMediaListStartingWithPatternAndOfType(
//				prefetchMediaModel.get(0).getSearchedMediaName(), prefetchMediaModel.get(0).getType());
//		MediaInfoHelper mediaInfoHelper = new MediaInfoHelper();
//		ArrayList<MediaInfoModel> mediaList = mediaInfoHelper.getQueriedMediaList(rs);
//		ArrayList<String> mediaNameList = new ArrayList<>();
//		for (MediaInfoModel mio : mediaList) {
//			mediaNameList.add(mio.getName());
//		}
//		return mediaNameList;
//	}
}
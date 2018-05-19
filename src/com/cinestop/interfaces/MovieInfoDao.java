package com.cinestop.interfaces;

import java.util.List;

import com.cinestop.model.MovieInfoModel;
import com.cinestop.model.MovieInfoModelList;

/**
 * Interface for getting movie details from the db
 * @author limafoxtrottango
 *
 */
public interface MovieInfoDao {
	public MovieInfoModel getMovieInfo(final String cinestopId);
	public List<MovieInfoModelList> getMovieInfoForListing(final String queriedMovie);
}

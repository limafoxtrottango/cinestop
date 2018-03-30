package com.cinestop.interfaces;

import com.cinestop.model.MovieInfoModel;

/**
 * Interface for getting movie details from the db
 * @author limafoxtrottango
 *
 */
public interface MovieInfoDao {
	public MovieInfoModel getMovieInfo(final String imdbId);
}

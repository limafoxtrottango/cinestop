package com.cinestop.interfaces;

import java.util.List;

import com.cinestop.model.MovieInfoModel;

/**
 * Interface for getting movie details from the db
 * @author limafoxtrottango
 *
 */
public interface MovieInfoDao {
	public List<MovieInfoModel> getMovieInfo(final String imdbId);
}

package com.cinestop.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinestop.constants.DatabaseConstants;
import com.cinestop.model.MediaInfoModel;

/**
 * Helper class to create a list of media objects from result set
 *
 */
public class MediaInfoHelper {

	public ArrayList<MediaInfoModel> getQueriedMediaList(final ResultSet rs) throws SQLException {
		ArrayList<MediaInfoModel> mediaList = new ArrayList<>();
		while (rs.next()) {
			String name = rs.getString(DatabaseConstants.NAME);
			String type = rs.getString(DatabaseConstants.TYPE);
			String poster = rs.getString(DatabaseConstants.POSTER);
			Float imdb_rating = rs.getFloat(DatabaseConstants.IMDB_RATING);
			String imdb_votes = rs.getString(DatabaseConstants.IMDB_VOTES);
			Integer tomatometer = rs.getInt(DatabaseConstants.TOMATOMETER);
			Integer metacritic = rs.getInt(DatabaseConstants.METACRITIC);
			Float roger = rs.getFloat(DatabaseConstants.ROGER);
			String prime = rs.getString(DatabaseConstants.PRIME);
			String netflix = rs.getString(DatabaseConstants.NETFLIX);
			String imdbId = rs.getString(DatabaseConstants.IMDB_ID);
			String released = rs.getString(DatabaseConstants.RELEASED);
			Integer runtime = rs.getInt(DatabaseConstants.RUNTIME);
			String genre = rs.getString(DatabaseConstants.GENRE);
			String director = rs.getString(DatabaseConstants.DIRECTOR);
			String language = rs.getString(DatabaseConstants.LANGUAGE);
			String actors = rs.getString(DatabaseConstants.ACTORS);
			String country = rs.getString(DatabaseConstants.COUNTRY);
			String awards = rs.getString(DatabaseConstants.AWARDS);
			String story = rs.getString(DatabaseConstants.STORY);

			MediaInfoModel mediaInfoModel = MediaInfoModel.builder().name(name).type(type).poster(poster)
					.imdb_rating(imdb_rating).imdb_votes(imdb_votes).tomatometer(tomatometer).metacritic(metacritic)
					.roger(roger).prime(prime).netflix(netflix).imdbId(imdbId).released(released).runtime(runtime)
					.genre(genre).director(director).language(language).actors(actors).country(country).awards(awards)
					.story(story).build();
			mediaList.add(mediaInfoModel);
		}
		return mediaList;
	}
}

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
			boolean prime = rs.getBoolean(DatabaseConstants.PRIME);
			boolean netflix = rs.getBoolean(DatabaseConstants.NETFLIX);

			MediaInfoModel mediaInfoModel = MediaInfoModel.builder().name(name).type(type).poster(poster)
					.imdb_rating(imdb_rating).imdb_votes(imdb_votes).tomatometer(tomatometer).metacritic(metacritic)
					.roger(roger).prime(prime).netflix(netflix).build();
			mediaList.add(mediaInfoModel);
		}
		return mediaList;
	}
}

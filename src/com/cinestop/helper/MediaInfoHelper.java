package com.cinestop.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.jar.Attributes.Name;

import org.apache.commons.lang.StringEscapeUtils;

import com.cinestop.constants.DatabaseConstants;
import com.cinestop.model.MediaInfoModel;
import com.cinestop.model.ReviewRogEbe;

/**
 * Helper class to create a list of media objects from result set
 *
 */
public class MediaInfoHelper {

	public MediaInfoModel getQueriedMediaInfoModel(final ResultSet rs) throws SQLException {
		rs.next();
		String title = getEscapedString(DatabaseConstants.TITLE, rs);
		String imdbId = getEscapedString(DatabaseConstants.IMDB_ID, rs);
		String tmdbId = getEscapedString(DatabaseConstants.TMDB_ID, rs);
		String poster = "https://image.tmdb.org/t/p/w342" + getEscapedString(DatabaseConstants.POSTER, rs);
		String backdrop = "https://image.tmdb.org/t/p/w1280" + getEscapedString(DatabaseConstants.BACKDROP, rs);
		String budget = getEscapedString(DatabaseConstants.BUDGET, rs);
		String genre = getGenres(getEscapedString(DatabaseConstants.GENRE, rs));
		String homepage = getEscapedString(DatabaseConstants.HOMEPAGE, rs);
		String language = getEscapedString(DatabaseConstants.LANGUAGE, rs);
		String plot = getEscapedString(DatabaseConstants.PLOT, rs);
		String release = getEscapedString(DatabaseConstants.RELEASE, rs);
		String revenue = getEscapedString(DatabaseConstants.REVENUE, rs);
		String runtime = getEscapedString(DatabaseConstants.RUNTIME, rs);
		// String spoken_languages =
		// getEscapedString(DatabaseConstants.SPOKEN_LANGUAGES, rs);
		// String tagline = getEscapedString(DatabaseConstants.TAGLINE, rs);

		MediaInfoModel mediaInfoModel = MediaInfoModel.builder().title(title).imdbId(imdbId).tmdbId(tmdbId)
				.poster(poster).backdrop(backdrop).budget(budget).genre(genre).homepage(homepage).language(language)
				.plot(plot).release(release).revenue(revenue).runtime(runtime).build();

		return mediaInfoModel;
	}

	private String getEscapedString(final String attribute, final ResultSet rs) throws SQLException {
		return StringEscapeUtils.unescapeHtml(rs.getString(attribute));
	}
	
	private String getGenres(final String genreJson) {
		System.out.println(genreJson);
		String genreString = "";
		String[] parsedGenreList = genreJson.split(",");
		for(int i=0; i<parsedGenreList.length; i+=2) {
			String[] name = parsedGenreList[i].split(":");
			genreString += name[1].substring(1, name[1].length()-1) + ",";
		}
		return genreString.substring(0,genreString.length()-1);
	}

}

package com.cinestop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cinestop.constants.DatabaseConstants;
import com.cinestop.model.MediaInfoModel;
import com.cinestop.model.UserModel;

/**
 * Class that interacts with the database and performs queries
 *
 */
public class DBQuery {

	private Connection conn;
	private Statement stmt;

	public DBQuery() throws ClassNotFoundException, SQLException {
		Class.forName(DatabaseConstants.JDBC_DRIVER);
		conn = DriverManager.getConnection(DatabaseConstants.DB_URL, DatabaseConstants.DATABASE_USERNAME,
				DatabaseConstants.DATABASE_PASSWORD);
		stmt = conn.createStatement();
	}

	public ResultSet checkUsernameAvailability(final String username) throws SQLException {
		String searchQuery = "SELECT * from " + DatabaseConstants.USERNAMES_TABLE + " where username=" + "\"" + username
				+ "\"";
		ResultSet rs = stmt.executeQuery(searchQuery);
		return rs;
	}

	public void persistSignUpInfo(final UserModel userModel) throws SQLException {
		String persistQuery = "INSERT into userinfo(username, email, password) VALUES" + "(" + "\""
				+ userModel.getUserName() + "\"" + "," + "\"" + userModel.getEmail() + "\"" + "," + "\""
				+ userModel.getPassword() + "\"" + ")";
		stmt.executeUpdate(persistQuery);
		persistQuery = "INSERT into usernames(username) VALUES" + "(" + "\"" + userModel.getUserName() + "\"" + ")";
		stmt.executeUpdate(persistQuery);
	}

	public ResultSet getMediaInfo(final String name, final String type) throws SQLException {

		String query = "SELECT i.imdb_id,  i.tmdb_id, i.title, a.adult, b.backdrop,  bu.budget, g.genre, h.homepage, l.language, p.plot, po.poster_url, r.release_date, rev.revenue, run.runtime FROM (SELECT * from media_id where title="
				+ "\"" + name + "\""
				+ ") i INNER JOIN media_adult a ON i.imdb_id = a.imdb_id  INNER JOIN media_backdrop b ON b.imdb_id = a.imdb_id INNER JOIN media_budget bu ON bu.imdb_id = b.imdb_id INNER JOIN media_genre g ON g.imdb_id = bu.imdb_id INNER JOIN media_homepage h ON h.imdb_id = g.imdb_id INNER JOIN media_language l ON l.imdb_id = h.imdb_id INNER JOIN media_plot p ON p.imdb_id = l.imdb_id INNER JOIN media_poster po ON po.imdb_id = p.imdb_id INNER JOIN media_release r ON r.imdb_id = po.imdb_id INNER JOIN media_revenue rev ON rev.imdb_id = r.imdb_id INNER JOIN media_runtime run ON run.imdb_id = r.imdb_id";

		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	public ResultSet getRogerEbertReviews(final String title) throws SQLException {
		String query = "SELECT * from media_reviews_re where title=" + "\"" + title + "\"";
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	public void persistMediaInfo(final MediaInfoModel mediaInfoObject) throws SQLException {

		String query_prt1 = "INSERT INTO movies_details(title, imdbid, release_date, runtime_minutes, genre, director, writer, actors, language, country, "
				+ "awards, poster_url, imdb_rating, imdb_votes, tomatometer, metacritic, roger, movie_website, type) VALUES";
		// String query_prt2 = "(" + "\"" + mediaInfoObject.getName() + "\"" + "," +
		// "\"" + mediaInfoObject.getImdbId()
		// + "\"" + "," + "\"" + mediaInfoObject.getReleased() + "\"" + "," +
		// mediaInfoObject.getRuntime() + ","
		// + "\"" + mediaInfoObject.getGenre() + "\"" + "," + "\"" +
		// mediaInfoObject.getDirector() + "\"" + ","
		// + "\"" + mediaInfoObject.getActors() + "\"" + "," + "\"" +
		// mediaInfoObject.getLanguage() + "\"" + ","
		// + "\"" + mediaInfoObject.getCountry() + "\"" + "," + "\"" +
		// mediaInfoObject.getAwards() + "\"" + ","
		// + "\"" + mediaInfoObject.getPoster() + "\"" + "," +
		// mediaInfoObject.getImdb_rating() + "," + "\""
		// + mediaInfoObject.getImdb_votes() + "\"" + "," +
		// mediaInfoObject.getTomatometer() + ","
		// + mediaInfoObject.getMetacritic() + "," + mediaInfoObject.getRoger() + "," +
		// "\"" + "," + "\""
		// + mediaInfoObject.getType() + "\"" + ")";
		String final_query = query_prt1 + "";
		stmt.executeUpdate(final_query);
	}

	public ResultSet getMediaListStartingWithPatternAndOfType(final String startWord, final String type)
			throws SQLException {
		String query = "";
		if (!"All".equals(type)) {
			query = "SELECT * from mediainfo where name like " + "\"" + startWord + "%" + "\"" + " and type=" + "\""
					+ type + "\"";
		} else {
			query = "SELECT * from mediainfo where name like " + "\"" + startWord + "\"";
		}
		System.out.println(query);
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}
}

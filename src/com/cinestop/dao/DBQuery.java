package com.cinestop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cinestop.constants.DatabaseConstants;
import com.cinestop.model.MediaInfoModel;

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

	public ResultSet getMediaInfo(final String name, final String type) throws SQLException {
		String searchQuery = "SELECT * FROM " + DatabaseConstants.TABLE + " where name =" + name + "and type="
				+ type;
		if ("All".equals(type)) {
			searchQuery = "SELECT * FROM " + DatabaseConstants.TABLE + " where name=" + name;
		}
		System.out.println(searchQuery);
		ResultSet rs = stmt.executeQuery(searchQuery);
		return rs;
	}

	public void persistMediaInfo(final MediaInfoModel mediaInfoObject) throws SQLException {

		String query_prt1 = "INSERT INTO movies_details(title, imdbid, release_date, runtime_minutes, genre, director, writer, actors, language, country, "
				+ "awards, poster_url, imdb_rating, imdb_votes, tomatometer, metacritic, roger, movie_website, type) VALUES";
		String query_prt2 = "(" + "\"" + mediaInfoObject.getName() + "\"" + "," + "\"" + mediaInfoObject.getImdbId()
				+ "\"" + "," + "\"" + mediaInfoObject.getReleased() + "\"" + "," + mediaInfoObject.getRuntime() + ","
				+ "\"" + mediaInfoObject.getGenre() + "\"" + "," + "\"" + mediaInfoObject.getDirector() + "\"" + ","
				+ "\"" + mediaInfoObject.getActors() + "\"" + "," + "\"" + mediaInfoObject.getLanguage() + "\"" + ","
				+ "\"" + mediaInfoObject.getCountry() + "\"" + "," + "\"" + mediaInfoObject.getAwards() + "\"" + ","
				+ "\"" + mediaInfoObject.getPoster() + "\"" + "," + mediaInfoObject.getImdb_rating() + "," + "\""
				+ mediaInfoObject.getImdb_votes() + "\"" + "," + mediaInfoObject.getTomatometer() + ","
				+ mediaInfoObject.getMetacritic() + "," + mediaInfoObject.getRoger() + "," + "\"" + "," + "\""
				+ mediaInfoObject.getType() + "\"" + ")";
		String final_query = query_prt1 + query_prt2;
		stmt.executeUpdate(final_query);
	}
}

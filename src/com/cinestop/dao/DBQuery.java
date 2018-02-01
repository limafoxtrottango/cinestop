package com.cinestop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cinestop.constants.DatabaseConstants;

/**
 * Class that interacts with the database and performs queries
 *
 */
public class DBQuery {

	private Connection conn;
	private Statement stmt;

	public DBQuery() {
		try {
			Class.forName(DatabaseConstants.JDBC_DRIVER);
			conn = DriverManager.getConnection(DatabaseConstants.DB_URL, DatabaseConstants.DATABASE_USERNAME,
					DatabaseConstants.DATABASE_PASSWORD);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet getMovieInfo(final String movieName) {
		String searchQuery = "SELECT * FROM" + DatabaseConstants.MOVIE_TABLE_NAME + "where title =" + "\"" + movieName
				+ "\"";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(searchQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getSeriesInfo(final String seriesName) {
		String searchQuery = "SELECT * FROM" + DatabaseConstants.SERIES_TABLE_NAME + "where title =" + "\"" + seriesName
				+ "\"";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(searchQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

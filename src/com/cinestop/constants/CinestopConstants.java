package com.cinestop.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CinestopConstants {

	public static final String DATABASE_USERNAME = "root";
	public static final String DATABASE_PASSWORD = "abc";
	public static final String COMMON_TABLE_NAME = "cinestop_common";
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/cinephile?useUnicode=yes&characterEncoding=UTF-8";
	public static final String DATABASE = "cinestop";
	public static final String TABLE = "mediainfo";
	public static final String USERNAMES_TABLE = "usernames";

	public static final String TITLE = "title";
	public static final String IMDB_ID = "imdb_id";
	public static final String TMDB_ID = "tmdb_id";
	public static final String POSTER = "poster_url";
	public static final String BACKDROP = "backdrop";
	public static final String BUDGET = "budget";
	public static final String GENRE = "genre";
	public static final String HOMEPAGE = "homepage";
	public static final String LANGUAGE = "language";
	public static final String PLOT = "plot";
	public static final String RELEASE = "release_date";
	public static final String REVENUE = "revenue";
	public static final String RUNTIME = "runtime";
	public static final String SPOKEN_LANGUAGES = "languages";
	public static final String TAGLINE = "tagline";

	public static final Map<String, String> GENRE_MAP;
	public static final Map<String, String> MONTH_MAP;
	public static final Map<String, String> METERCLASS_MAP;

	static {
		Map<String, String> month_map = new HashMap<String, String>();
		month_map.put("01", "January");
		month_map.put("02", "Febuary");
		month_map.put("03", "March");
		month_map.put("04", "April");
		month_map.put("05", "May");
		month_map.put("06", "June");
		month_map.put("07", "July");
		month_map.put("08", "August");
		month_map.put("09", "September");
		month_map.put("10", "October");
		month_map.put("11", "November");
		month_map.put("12", "December");
		MONTH_MAP = Collections.unmodifiableMap(month_map);

		Map<String, String> genre_map = new HashMap<String, String>();
		genre_map.put("28", "Action");
		genre_map.put("12", "Adventure");
		genre_map.put("16", "Animation");
		genre_map.put("35", "Comedy");
		genre_map.put("80", "Crime");
		genre_map.put("99", "Documentary");
		genre_map.put("18", "Drama");
		genre_map.put("10751", "Family");
		genre_map.put("14", "Fantasy");
		genre_map.put("36", "History");
		genre_map.put("27", "Horror");
		genre_map.put("10402", "Music");
		genre_map.put("9648", "Mystery");
		genre_map.put("10749", "Romance");
		genre_map.put("878", "Science Fiction");
		genre_map.put("10770", "TV Movie");
		genre_map.put("53", "Thriller");
		genre_map.put("10752", "War");
		genre_map.put("37", "Western");
		GENRE_MAP = Collections.unmodifiableMap(genre_map);

		Map<String, String> meterclass_map = new HashMap<String, String>();
		meterclass_map.put("fresh", "Fresh");
		meterclass_map.put("rotten", "Rotten");
		meterclass_map.put("certified_fresh", "Certified Fresh");
		METERCLASS_MAP = Collections.unmodifiableMap(meterclass_map);
	}
}

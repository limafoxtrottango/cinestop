package com.cinestop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cinestop.constants.DatabaseConstants;
import com.cinestop.interfaces.MovieInfoDao;
import com.cinestop.model.MovieInfoModel;

import lombok.AllArgsConstructor;

/**
 * Class that interacts with the database and performs queries
 *
 */
@AllArgsConstructor
public class MovieInfoDaoImpl implements MovieInfoDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MovieInfoModel> getMovieInfo(final String tmdbId) {

		String query = "SELECT i.imdb_id,  i.tmdb_id, i.title, a.adult, b.backdrop,  bu.budget, g.genre, h.homepage, l.language, p.plot, po.poster_url, r.release_date, rev.revenue, run.runtime, re.reviewer, re.rating, re.review FROM (SELECT * from media_id where imdb_id="
				+ "\"" + tmdbId + "\""
				+ ") i INNER JOIN media_adult a ON i.imdb_id = a.imdb_id  INNER JOIN media_backdrop b ON b.imdb_id = a.imdb_id INNER JOIN media_budget bu ON bu.imdb_id = b.imdb_id INNER JOIN media_genre g ON g.imdb_id = bu.imdb_id INNER JOIN media_homepage h ON h.imdb_id = g.imdb_id INNER JOIN media_language l ON l.imdb_id = h.imdb_id INNER JOIN media_plot p ON p.imdb_id = l.imdb_id INNER JOIN media_poster po ON po.imdb_id = p.imdb_id INNER JOIN media_release r ON r.imdb_id = po.imdb_id INNER JOIN media_revenue rev ON rev.imdb_id = r.imdb_id INNER JOIN media_runtime run ON run.imdb_id = r.imdb_id INNER JOIN media_reviews_re re ON re.imdb_id = run.imdb_id ";
		final List<MovieInfoModel> movieInfoObjectsList = new ArrayList<>();
		final List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

		for (Map<String, Object> row : rows) {
			movieInfoObjectsList.add(MovieInfoModel.builder().title(row.get("title").toString())
					.poster("https://image.tmdb.org/t/p/w342" + row.get("poster_url").toString())
					.backdrop("https://image.tmdb.org/t/p/w1280" + row.get("backdrop").toString()).build());
		}
		return movieInfoObjectsList;
	}
}

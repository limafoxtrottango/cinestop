package com.cinestop.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cinestop.constants.CinestopConstants;
import com.cinestop.interfaces.MovieInfoDao;
import com.cinestop.model.MovieCastModel;
import com.cinestop.model.MovieCrewModel;
import com.cinestop.model.MovieInfoModel;
import com.cinestop.model.MovieInfoModel.MovieInfoModelBuilder;

import lombok.AllArgsConstructor;

/**
 * Class that interacts with the database and performs queries
 *
 */
@AllArgsConstructor
public class MovieInfoDaoImpl implements MovieInfoDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public MovieInfoModel getMovieInfo(final String cinestopId) {

		String query = "SELECT pd.title, pd.adult, pd.backdrop,pd.budget, pd.homepage, pd.plot, pd.poster, pd.release_date, pd.revenue, pd.runtime, pd.language, pd.tagline, pd.status, mg.genre_id, cst.cast_id, cst.character_name, cst.name, cst.profile_path, crw.job, crw.name as crew_name, crw.profile_path as crew_profile_path, crw.id as crew_id FROM (SELECT * from movie_data_primary  WHERE cinestopId="
				+ "\"" + cinestopId + "\"" + ")"
				+ " pd INNER JOIN movie_genre mg ON pd.cinestopId = mg.cinestopId INNER JOIN movie_cast cst ON cst.cinestopId  = pd.cinestopId INNER JOIN movie_crew crw ON crw.cinestopId = cst.cinestopId";
		System.out.println(query);
		final List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

		HashSet<String> addedCast = new HashSet<>();
		HashSet<String> addedGenreIds = new HashSet<>();
		HashSet<String> addedCrew = new HashSet<>();

		List<MovieCastModel> cast = new ArrayList<>();
		List<MovieCrewModel> crew = new ArrayList<>();
		List<String> genres = new ArrayList<>();
		MovieInfoModelBuilder movieInfoBuilder = MovieInfoModel.builder();
		int rowNo = 0;
		for (Map<String, Object> row : rows) {
			if (!addedCast.contains(String.valueOf(row.get("cast_id")))) {
				cast.add(MovieCastModel.builder().name(String.valueOf(row.get("name")))
						.character_name(String.valueOf(row.get("character_name")))
						.profile_path("https://image.tmdb.org/t/p/w138_and_h175_face"
								+ String.valueOf(row.get("profile_path")))
						.build());
				addedCast.add(String.valueOf(row.get("cast_id")));
			}
			if (!addedGenreIds.contains(String.valueOf(row.get("genre_id")))) {
				genres.add(CinestopConstants.GENRE_MAP.get(String.valueOf(row.get("genre_id"))));
				addedGenreIds.add(String.valueOf(row.get("genre_id")));
			}
			if (!addedCrew.contains(String.valueOf(row.get("crew_profile_path")))) {
				crew.add(MovieCrewModel.builder().name(String.valueOf(row.get("crew_name")))
						.job(String.valueOf(row.get("job"))).profile_path(String.valueOf(row.get("crew_profile_path")))
						.build());
				addedCrew.add(String.valueOf(row.get("crew_id")));
			}
			if (rowNo == 0) {
				movieInfoBuilder.title(row.get("title").toString())
						.budget(String.format("%.2f",
								((Double) (Double.parseDouble(row.get("budget").toString()) / 1000000))))
						.adult(row.get("adult").toString()).plot(row.get("plot").toString())
						.release(row.get("release_date").toString())
						.revenue(String.format("%.2f",
								((Double) (Double.parseDouble(row.get("revenue").toString()) / 1000000))))
						.runtime(row.get("runtime").toString()).tagline(row.get("tagline").toString())
						.language(row.get("language").toString())
						.poster("https://image.tmdb.org/t/p/w342" + row.get("poster").toString())
						.backdrop("https://image.tmdb.org/t/p/w1280" + row.get("backdrop").toString());
			}
			++rowNo;
		}

		movieInfoBuilder.genres(genres);
		movieInfoBuilder.cast(cast);
		movieInfoBuilder.crew(crew);
		
		return movieInfoBuilder.build();
	}
}

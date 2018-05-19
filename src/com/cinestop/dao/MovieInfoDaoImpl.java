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
import com.cinestop.model.MovieInfoModelList;
import com.cinestop.model.MovieInfoModelList.MovieInfoModelListBuilder;

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

		String query = "SELECT pd.meterclass, pd.meterscore, pd.rt_url, pd.imdbId, pd.title, pd.adult, pd.backdrop,pd.budget, pd.homepage, pd.plot, pd.poster, pd.release_date, pd.revenue, pd.runtime, pd.language, pd.tagline, pd.status, pd.imdbRatings, pd.imdbVotes, mg.genre_id, cst.cast_id, cst.character_name, cst.name, cst.profile_path, crw.job, crw.name as crew_name, crw.profile_path as crew_profile_path, crw.id as crew_id, crw.credit_id as crew_credit_id FROM (SELECT * from movie_data_primary  WHERE cinestopId="
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
			if (!addedCrew.contains(String.valueOf(row.get("crew_credit_id")))) {
				crew.add(MovieCrewModel.builder().name(String.valueOf(row.get("crew_name")))
						.job(String.valueOf(row.get("job")))
						.profile_path("https://image.tmdb.org/t/p/w138_and_h175_face"
								+ String.valueOf(row.get("crew_profile_path")))
						.build());
				addedCrew.add(String.valueOf(row.get("crew_credit_id")));
			}
			if (rowNo == 0) {
				movieInfoBuilder.title(row.get("title").toString()).adult(row.get("adult").toString())
						.plot(row.get("plot").toString()).release(getProcessedDate(row.get("release_date").toString()))
						.revenue(String.format("%.2f",
								((Double) (Double.parseDouble(row.get("revenue").toString()) / 1000000))))
						.runtime(row.get("runtime").toString()).tagline(row.get("tagline").toString())
						.language(row.get("language").toString())
						.poster("https://image.tmdb.org/t/p/w342" + row.get("poster").toString())
						.backdrop("https://image.tmdb.org/t/p/w1280" + row.get("backdrop").toString())
						.imdbRating(row.get("imdbRatings").toString()).imdbVotes(row.get("imdbVotes").toString())
						.imdbId(row.get("imdbId").toString()).meterclass(row.get("meterclass").toString())
						.meterscore(row.get("meterscore").toString());
			}

			movieInfoBuilder.budget(getAdjustedAmount(row.get("budget").toString()));
			movieInfoBuilder.revenue(getAdjustedAmount(row.get("revenue").toString()));

			++rowNo;
		}

		movieInfoBuilder.genres(genres);
		movieInfoBuilder.cast(cast);
		movieInfoBuilder.crew(crew);

		return movieInfoBuilder.build();
	}

	private String getAdjustedAmount(final String currAmt) {
		int currAmt_ = Integer.parseInt(currAmt);
		if (currAmt_ < 1000000) {
			return currAmt + "USD";
		} else {
			return (String.format("%.2f", ((Double) (Double.parseDouble(currAmt) / 1000000))) + "M USD");
		}
	}

	private String getProcessedDate(final String currDate) {
		String year = currDate.substring(0, currDate.indexOf('-'));
		String month = currDate.substring(currDate.indexOf('-') + 1, currDate.lastIndexOf('-'));
		String date = currDate.substring(currDate.lastIndexOf('-') + 1, currDate.length());
		return date + " " + CinestopConstants.MONTH_MAP.get(month) + " " + year;
	}

	@Override
	public List<MovieInfoModelList> getMovieInfoForListing(String queriedMovie) {
		String query = "SELECT title,cinestopId,poster,release_date FROM movie_data_primary where title like \"%" + queriedMovie
				+ "%\"";
		final List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		MovieInfoModelListBuilder movieInfoModelListBuilder = MovieInfoModelList.builder();
		List<MovieInfoModelList> movieInfoList = new ArrayList<>();
		for (Map<String, Object> row : rows) {
			movieInfoModelListBuilder.title(row.get("title").toString())
					.poster("https://image.tmdb.org/t/p/w342" + row.get("poster").toString())
					.release(row.get("release_date").toString());
			movieInfoList.add(movieInfoModelListBuilder.build());
		}
		return movieInfoList;
	}
}

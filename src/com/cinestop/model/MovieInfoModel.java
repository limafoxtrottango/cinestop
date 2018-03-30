package com.cinestop.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

/**
 * A POJO class that models the detail page for a movie
 * @author limafoxtrottango
 *
 */

@Builder
@Getter
public class MovieInfoModel {
	private String title;
	private String imdbId;
	private String tmdbId;
	private String adult;
	private String poster;
	private String backdrop;
	private String budget;
	private List<String> genres;
	private String homepage;
	private String language;
	private String plot;
	private String release;
	private String revenue;
	private RogerEbertModel rogerEbert;
	private String runtime;
	private String spoken_languages;
	private String tagline;
	private List<MovieCastModel> cast;
	private List<MovieCrewModel> crew;
}

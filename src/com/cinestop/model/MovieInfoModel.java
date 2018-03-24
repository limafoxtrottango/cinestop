package com.cinestop.model;

import java.util.ArrayList;

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
	private String poster;
	private String backdrop;
	private String budget;
	private ArrayList<String> genre;
	private String homepage;
	private String language;
	private String plot;
	private ArrayList<MovieCastModel> cast;
	private ArrayList<MovieCrewModel> crew;
	private String release;
	private String revenue;
	private RogerEbertModel rogerEbert;
	private String runtime;
	private String spoken_languages;
	private String tagline;
}

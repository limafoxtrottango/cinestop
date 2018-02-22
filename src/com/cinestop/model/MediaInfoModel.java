package com.cinestop.model;

import java.util.ArrayList;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MediaInfoModel {
	private String title;
	private String imdbId;
	private String tmdbId;
	private String poster;
	private String backdrop;
	private String budget;
	private String genre;
	private String homepage;
	private String language;
	private String plot;
	private String release;
	private String revenue;
	private ReviewRogEbe rogerEbert;
	private ArrayList<ReviewRotTom> rottenTomatoes;
	private String runtime;
	private String spoken_languages;
	private String tagline;
}

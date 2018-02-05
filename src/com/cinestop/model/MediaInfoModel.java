package com.cinestop.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MediaInfoModel {
	private String name;
	private String type;
	private String poster;
	private Float imdb_rating;
	private String imdb_votes;
	private Integer tomatometer;
	private Integer metacritic;
	private Float roger;
	private String prime;
	private String netflix;
	private String imdbId;
	private String released;
	private Integer runtime;
	private String genre;
	private String director;
	private String language;
	private String actors;
	private String country;
	private String awards;
	private String story;
}

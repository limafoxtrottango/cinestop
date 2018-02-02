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
	private boolean prime;
	private boolean netflix;
}

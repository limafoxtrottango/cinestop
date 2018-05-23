package com.cinestop.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MovieInfoModelList {
	private String title;
	private String cinestopId;
	private String director;
	private String poster;
	private String plot;
	private String runtime;
	private List<String> genres;
	private String release;
}

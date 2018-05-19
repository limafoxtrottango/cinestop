package com.cinestop.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MovieInfoModelList {
	private String title;
	private String cinestopId;
	private String poster;
	private String release;
}

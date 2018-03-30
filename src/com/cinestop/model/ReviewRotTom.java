package com.cinestop.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewRotTom {
	private String imdbId;
	private String critic_name;
	private String critic_associations;
	private String title;
	private String review;
	private String final_score;
}

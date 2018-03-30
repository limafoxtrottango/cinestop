package com.cinestop.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewRogEbe {
	private String imdbId;
	private String title;
	private String reviewer;
	private String rating;
	private String review_col_1;
	private String review_col_2;
}

package com.cinestop.model;

import lombok.Getter;

@Getter
public class MovieQueryModel {
	private String type;
	private String title;
	private String year;
	private int fromPage;
	private int toPage;
}

package com.cinestop.model;

import lombok.Getter;

import lombok.Builder;

@Builder
@Getter
public class PrefetchMediaModel {
	private String searchedMediaName;
	private String type;
}

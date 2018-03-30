package com.cinestop.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieCrewModel {
	private String department;
	private String gender;
	private String job;
	private String name;
	private String profile_path;
}

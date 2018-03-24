package com.cinestop.model;

import lombok.Builder;
import lombok.Getter;

/**
 * POJO class that models a movie actor
 * @author limafoxtrottango
 *
 */

@Getter
@Builder
public class MovieCastModel {
	private String character_name;
	private String gender;
	private String name;
	private String profile_path;
}

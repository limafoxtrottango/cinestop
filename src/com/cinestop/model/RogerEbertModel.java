package com.cinestop.model;

import lombok.Builder;
import lombok.Getter;

/**
 * A POJO class that models Roger Ebert's review for a movie
 * @author limafoxtrottango
 *
 */

@Builder
@Getter
public class RogerEbertModel {
	private String reviewer;
	private String rating;
	private String review_col_1;
	private String review_col_2;
}

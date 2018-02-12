package com.cinestop.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserModel {
	private String userName;
	private String password;
	private String email;
}

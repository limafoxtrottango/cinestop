package com.cinestop.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FTPModel {
	private String sourceServerName;
	private String sourceFolderName;
	private String sourceUserId;
	private String sourcePassword;
	private String SANLocation;
	private String clientServerName;
	private String clientFolderName;
	private String clientUserId;
	private String clientPassword;
	private String wildcards;
}

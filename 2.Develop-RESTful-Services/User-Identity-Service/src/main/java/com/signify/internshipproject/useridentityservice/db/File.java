package com.signify.internshipproject.useridentityservice.db;

public enum File {
	ConfigFile("config.properties");
	private final String value;
	File(String value){
		this.value=value;
	}
	public String getValue() {
		return this.value;
		
	}
	

}

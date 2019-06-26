package com.signify.internshipproject.webappservice.db;
public enum Files {
	ConfigFile(".properties");
	private final String value;
	Files(String value){
		this.value=value;
	}
	public String getValue() {
		return this.value;
		
	}
	

}


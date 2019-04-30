package com.signify.internship.project.db;

public enum Values {
	USERNAME("username"),PASSWORD("password"),CONNURL("connURL"),DNAME("dname");
	private final String value;
	Values(String value){
		this.value=value;
	}
	public String getValue() {
		return this.value;
		
	}
	

}

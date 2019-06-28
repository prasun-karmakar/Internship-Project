package com.signify.internshipproject.webappservice.rest.client;

public class UserRegisterInfo {
	
	public String username;
	public String password;
	public String email;
	public String mobileno;
	public String timezone_id;
	public String language_id;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getTimezone_id() {
		return timezone_id;
	}
	public void setTimezone_id(String timezone_id) {
		this.timezone_id = timezone_id;
	}
	public String getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(String language_id) {
		this.language_id = language_id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String objStr="username" + getUsername()+" "+"password: "+getPassword();
		return objStr;
	}

}

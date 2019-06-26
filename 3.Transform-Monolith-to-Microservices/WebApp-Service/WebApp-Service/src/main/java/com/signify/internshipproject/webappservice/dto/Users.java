package com.signify.internshipproject.webappservice.dto;

import java.util.ArrayList;

public class Users {
	public String username;
	public String email;
	ArrayList<Users> result;
	ArrayList<Users> userRec;
	
	public ArrayList<Users> getUserRec() {
		return userRec;
	}
	public void setUserRec(ArrayList<Users> userRec) {
		this.userRec = userRec;
	}
	public ArrayList<Users> getResult() {
		return result;
	}
	public void setResult(ArrayList<Users> result) {
		this.result = result;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String mobileno;
	public String timezone_id;

	

}

package com.signify.internship.project.dto;

import java.util.ArrayList;
import java.util.Map;
public class UserDTO 
{
	public String username;
	public String password;
	public String email;
	public String mobileno;
	public String lastlogin;
	public String timezone_id;
	public String language_id;
	public Integer language_id1;
	public String language_name;
	public String newpassword;
	public String confirmpassword;
	public String getLanguage_name() {
		return language_name;
	}
	public void setLanguage_name(String language_name) {
		this.language_name = language_name;
	}
	public String getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(String language_id) {
		this.language_id = language_id;
	}
	public String name;
	
	public Map<Integer, String> results;
	public String time_id;
	public String ZonedDateTime;
	public Map<String,String> resultauth;
	public String password2;
	public String password1;
	ArrayList<UserDTO> userRec;
	public String user_id;
	public ArrayList<UserDTO> result;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public ArrayList<UserDTO> getUserslist() {
		return userslist;
	}
	public void setUserslist(ArrayList<UserDTO> userslist) {
		this.userslist = userslist;
	}
	public UserDTO res;
	public ArrayList<UserDTO> info;
	public ArrayList<UserDTO> userslist;
	

	public ArrayList<UserDTO> getInfo() {
		return info;
	}
	public void setInfo(ArrayList<UserDTO> info) {
		this.info = info;
	}
	public ArrayList<UserDTO> getResult() {
		return result;
	}
	public void setResult(ArrayList<UserDTO> result) {
		this.result = result;
	}
	public ArrayList<UserDTO> getUserRec() {
		return userRec;
	}
	public void setUserRec(ArrayList<UserDTO> userRec) {
		this.userRec = userRec;
	}
	
	public Map<String, String> getResultauth() {
		return resultauth;
	}
	public void setResultauth(Map<String, String> resultauth) {
		this.resultauth = resultauth;
	}
	
	public String getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	
	public String getZonedDateTime() {
		return ZonedDateTime;
	}
	public void setZonedDateTime(String zonedDateTime) {
		ZonedDateTime = zonedDateTime;
	}
	public String getTime_id() {
		return time_id;
	}
	public void setTime_id(String time_id) {
		this.time_id = time_id;
	}
	public Map<Integer, String> getResults() {
		return results;
	}
	public void setResults(Map<Integer, String> results) {
		this.results = results;
	}

	public String getName() { 
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTimezone_id() {
		return timezone_id;
	}
	public void setTimezone_id(String timezone_id) {
		this.timezone_id = timezone_id;
	}
	
	
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
	
	
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public void setPassword1(String password1) {
		this.password1=password1;
		
	}
	public String getPassword1() {
		return password1;
	}
	public UserDTO getRes() {
		return res;
	}
	public void setRes(UserDTO res) {
		this.res = res;
	}
	public Integer getLanguage_id1() {
		return language_id1;
	}
	public void setLanguage_id1(Integer language_id1) {
		this.language_id1 = language_id1;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	
}
	
	


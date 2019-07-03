package com.signify.internshipproject.useridentityservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserInfo {

	private String userName;
	private String password;
	private String emailId;
	private String mobileNo;
	private int languageId;
	private String language;
	private int timezoneId;
	private String lastLogintime;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public int getTimezoneId() {
		return timezoneId;
	}
	public void setTimezoneId(int timezoneId) {
		this.timezoneId = timezoneId;
	}
	public String getLastLogintime() {
		return lastLogintime;
	}
	public void setLastLogintime(String lastLogintime) {
		this.lastLogintime = lastLogintime;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}

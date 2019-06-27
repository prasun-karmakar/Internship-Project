package com.signify.internshipproject.webappservice.rest.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.signify.internshipproject.webappservice.dto.UserDTO;

public class RestClient {

	public boolean authenticateUser(UserDTO userDTO) {  //Rest client authenticate
		boolean status=false;
		//Invoke REST API
		return status;
	}


	public boolean getLastlogintime(UserDTO userDTO) { //rest client lastlogin
		// TODO Auto-generated method stub
		boolean status=false;
		//Invoke REST API
		return status;
	}
	
	public Map<Integer, String> getTimezonesFromUserIdentity(UserDTO userDTO){ //rest client gettimezones
		//Invoke REST API here
		///
		Map<Integer, String> timezoneMap=new HashMap<Integer, String>(20);
		timezoneMap.put(1,"Asia/Amman");
		timezoneMap.put(2,"Asia/Dacca");
		timezoneMap.put(3,"Asia/Beirut");
		timezoneMap.put(4,"Asia/Damascus");
		timezoneMap.put(5,"Pacific/Tahiti");
		return timezoneMap;
		
	}


	public Map<Integer, String> getLanguageDropdownFromUserIdentity(UserDTO userDTO) { //rest client getlanguagename
		// TODO Auto-generated method stub
		Map<Integer, String> languageMap=new HashMap<Integer, String>(20);
		languageMap.put(1,"English");
		languageMap.put(1,"French");
		return languageMap;
		
	}


	public boolean registerconfirmdetails(UserDTO userDTO) {
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public boolean updatePassword(UserDTO userDTO) {
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public boolean updateUserProfileDetail(UserDTO userDTO) {
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public boolean getForgotPassword(UserDTO userDTO) {
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public UserDTO fetchUserProfileDetail(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return userDTO;
	}


	


	public String getTimezoneName(UserDTO userDTO) {
		// TODO Auto-generated method stub
		//Invoke REST AP
		return null;
	}


	public boolean updateLastLoginTime(UserDTO userDTO) {
		
		// TODO Auto-generated method stub
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public ArrayList<UserDTO> getAllUserList(UserDTO userDTO) {
		// TODO Auto-generated method stub
		ArrayList<UserDTO> userRecords=new ArrayList<>();
		//UserRecords.add("sindhu","")
		return userRecords;
	}


	public boolean insertRegistrationDetails(UserDTO userDTO) {
		boolean status=false;
		return status;
		// TODO Auto-generated method stub
		
	}


	public ArrayList<UserDTO> fetchUserList(UserDTO userDTO) {
		// TODO Auto-generated method stub
		ArrayList<UserDTO> userList=new ArrayList<>();
		return userList;
	}


	public UserDTO fetchUserUpdateProfileDetail(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		return null;
	}


	public boolean storeUserProfileDetail(UserDTO userDTO) {
		// TODO Auto-generated method stub
		boolean status=false;
		return status;
		
	}


	public int getDatabaseLanguageId(UserDTO userDTO) {
		// TODO Auto-generated method stub
		int status=0;
		//Invoke REST API
		return status;
	}


	public boolean deleteUsersProfileDetail(UserDTO userDTO) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				boolean status=false;
				//Invoke REST AP
				return status;

	}


	public boolean updateUserPasswordRequest(UserDTO userDTO) {
		// TODO Auto-generated method stub
		boolean status=false;
		//Invoke REST AP
		return status;
		
	}
	
	
	
}

package com.signify.internship.project.dao;

import java.util.ArrayList;
import java.util.Map;

import com.signify.internship.project.dto.UserDTO;

public interface UserDAO 
{


	public UserDTO getUserDetails(UserDTO userDTO);
	public String getUsersLastLoginTime(UserDTO userDTO);
	public String getTimezoneName(UserDTO userDTO);
	public int updateLastLoginTime(UserDTO userDTO);
	public Map<Integer, String> getTimezoneid_name(UserDTO userDTO);
	public UserDTO validateUserDetails(UserDTO userDTO);
	public int insertUserRegistrationDetails(UserDTO userDTO);
	public UserDTO validatePasswordRequest(UserDTO userDTO);
	public int updatePassword(UserDTO userDTO);
	public int updateUserProfile(UserDTO userDTO);
	public ArrayList<UserDTO> userDetails(UserDTO userDTO);
	public UserDTO fetchUserProfileDetail(UserDTO userDTO);
	public ArrayList<UserDTO> fetchUserList(UserDTO userDTO);
	public UserDTO fetchUserUpdateProfileDetail(UserDTO userDTO);
	public Map<Integer,String> getLanguageid_name(UserDTO userDTO);
	public int storeUserProfileDetail(UserDTO userDTO);
	public int getDatabaseLanguageId(UserDTO userDTO);
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



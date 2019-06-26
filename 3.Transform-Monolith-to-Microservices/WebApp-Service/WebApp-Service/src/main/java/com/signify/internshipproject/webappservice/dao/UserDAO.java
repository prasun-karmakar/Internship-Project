package com.signify.internshipproject.webappservice.dao;

import java.util.ArrayList;
import java.util.Map;

import com.signify.internshipproject.webappservice.dto.UserDTO;

public interface UserDAO 
{


	public UserDTO getLoginUserDetails(UserDTO userDTO);
	public String getUsersLastLoginTime(UserDTO userDTO);
	public String getTimezoneName(UserDTO userDTO);
	public int updateLastLoginTime(UserDTO userDTO);
	public Map<Integer, String> getTimezoneid_name(UserDTO userDTO);
	public UserDTO validateUserDetails(UserDTO userDTO);
	public int insertUserRegistrationDetails(UserDTO userDTO);
	public UserDTO validatePasswordRequest(UserDTO userDTO);
	public int updatePassword(UserDTO userDTO);
	public int updateUserProfile(UserDTO userDTO);
	public UserDTO fetchUserProfileDetail(UserDTO userDTO);
	public ArrayList<UserDTO> fetchUserList(UserDTO userDTO);
	public UserDTO fetchUserUpdateProfileDetail(UserDTO userDTO);
	public Map<Integer,String> getLanguageid_name(UserDTO userDTO);
	public int storeUserProfileDetail(UserDTO userDTO);
	public int getDatabaseLanguageId(UserDTO userDTO);
	public int deleteUsersProfileDetail(UserDTO userDTO);
	public int updateUserPasswordRequest(UserDTO userDTO);
	public ArrayList<UserDTO> getUserRegisteredDetails(UserDTO userDTO);
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



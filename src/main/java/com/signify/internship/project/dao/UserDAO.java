package com.signify.internship.project.dao;

import java.util.ArrayList;
import java.util.Map;

import com.signify.internship.project.dto.UserDTO;

public interface UserDAO 
{


	public UserDTO getUserDetails(UserDTO c);
	public String getUsersLastLoginTime(UserDTO c);
	public String getTimezoneName(UserDTO c);
	public int updateLastLoginTime(UserDTO c);
	public Map<Integer, String> getTimezoneid_name(UserDTO c);
	public UserDTO validateUserDetails(UserDTO c);
	public int insertUserRegistrationDetails(UserDTO c);
	public UserDTO validatePasswordRequest(UserDTO c);
	public int updatePassword(UserDTO c);
	public int updateUserProfile(UserDTO c);
	public ArrayList<UserDTO> userDetails(UserDTO userDTO);
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



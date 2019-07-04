package com.signify.internshipproject.useridentityservice.service;
import java.util.ArrayList;

import com.signify.internshipproject.useridentityservice.dao.UserDAO;
import com.signify.internshipproject.useridentityservice.dto.UserDTO;
import com.signify.internshipproject.useridentityservice.model.UserInfo;
import com.signify.internshipproject.useridentityservice.model.UserServiceModel;

public class RestHandler {
	
	public  UserInfo getProfileDetail(UserDTO userDTO) {
		
	try {
		UserServiceModel userservice=new UserServiceModel();
		UserDTO profiledetails=userservice.getUserProfileDetail(userDTO);
		UserInfo userInfo=new UserInfo();
		userInfo.setUserName(profiledetails.getUsername());
		userInfo.setEmailId(profiledetails.getEmail());
		userInfo.setMobileNo(profiledetails.getMobileno());
		userInfo.setLanguage(profiledetails.getLanguage_name());
		userInfo.setTimezoneId(Integer.valueOf(profiledetails.getName()));
		
	    return userInfo;	
		
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return null;
	
}

	public ArrayList<UserDTO> getRegisteredUsers(UserDTO userDTO) {
		// TODO Auto-generated method stub
		try {
			UserServiceModel userservice=new UserServiceModel();
			ArrayList<UserDTO> allRegisteredUsers = userservice.getUserDetails(userDTO);
			userDTO.setResult(allRegisteredUsers);
			System.out.println(allRegisteredUsers);
		    return allRegisteredUsers;
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public boolean registerUserDetails(UserDTO userDTO) {
		try {
			UserServiceModel userservice=new UserServiceModel();
			 userservice.insertUserDetails(userDTO);
			    return true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
		// TODO Auto-generated method stub
		
	}

	public boolean deleteUserDetail(UserDTO userDTO) {
		try {
			UserServiceModel userservice=new UserServiceModel();
			 userservice.deleteUsers(userDTO);
			    return true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
		// TODO Auto-generated method stub
		
	}

	public boolean editUserDetails(UserDTO userDTO) {
		try {
			UserServiceModel userservice=new UserServiceModel();
			 userservice.updateUserInfo(userDTO);
			    return true;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
		
		
		
	}
	
	public boolean authenticateuserlogin(UserInfo userInfo) {
		
		UserDTO userDTO=new UserDTO();
		userDTO.setUsername(userInfo.getUserName());
		userDTO.setPassword(userInfo.getPassword());

		UserServiceModel userservice=new UserServiceModel();
		boolean result=userservice.authenticateUser(userDTO);
		if(result) {
			return true;
		}
		else {
			return false;
		}

	
	}

	public UserDTO getLastlogintime(UserDTO userDTO) {
		// TODO Auto-generated method stub
		try {
			UserServiceModel userservice=new UserServiceModel();
			userservice.getLastLoginTime(userDTO);
			return userDTO;	
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	public String getTimezoneName(UserDTO userDTO) {
		UserServiceModel userservice=new UserServiceModel();
		userservice.getTimezoneData(userDTO);
		return userDTO.getLanguage_name();
	}
	
	public UserInfo getLanguageId(UserDTO userDTO) {
		UserServiceModel userservice=new UserServiceModel();
		
		UserInfo userInfo=new UserInfo();
		int languageId=userservice.getLanguageId(userDTO);
		userInfo.setLanguageId(languageId);
		return userInfo;
	}
}


/*try {
	UserDAO userDAO = new UserDAOImpl();
    userDAO.insertUserRegistrationDetails(userDTO);
    return "valid";
 
}
	catch(Exception e) {
		System.out.println(e);
	}
	return "invalid";
}*/


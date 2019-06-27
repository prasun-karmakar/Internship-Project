package com.signify.internshipproject.webappservice.service;
import java.util.ArrayList;

import com.signify.internshipproject.webappservice.dto.UserDTO;
import com.signify.internshipproject.webappservice.model.UserServiceModel;

public class RestHandler {
	
	public  UserDTO getProfileDetail(UserDTO userDTO) {
		
	try {
		UserServiceModel userservice=new UserServiceModel();
		UserDTO profiledetails=userservice.getUserProfileDetail(userDTO);
		userDTO.setRes(profiledetails);
	    return profiledetails;	
		
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
	
	public boolean authenticateuserlogin(UserDTO userDTO) {
		
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


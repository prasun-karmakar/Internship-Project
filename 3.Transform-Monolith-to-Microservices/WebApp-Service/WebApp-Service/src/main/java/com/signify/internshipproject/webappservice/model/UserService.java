package com.signify.internshipproject.webappservice.model;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.signify.internshipproject.webappservice.dao.UserDAO;
import com.signify.internshipproject.webappservice.daoimpl.UserDAOImpl;
import com.signify.internshipproject.webappservice.dto.UserDTO;
import com.signify.internshipproject.webappservice.rest.client.Email;
import com.signify.internshipproject.webappservice.rest.client.RestClient;

public class UserService {
	
	public boolean authenticateUser(UserDTO userDTO) {
		boolean status=false;
		try {
		RestClient restClient=new RestClient();
		status=restClient.authenticateUser(userDTO);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	
}
	/*
boolean status=false;
try {
	RestClient restClient=new RestClient();
    restClient.registerconfirmdetails(userDTO) ;
	status=true;
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return status;

	
	
	
	
	
	
	
	
	*/
public boolean getLastLoginTime(UserDTO userDTO) {
	
			boolean result=false;
			RestClient restClient=new RestClient();
			result=restClient.getLastlogintime(userDTO);
			return result;
		 
		}

public String getTimezoneData(UserDTO userDTO) {
	
	RestClient restClient=new RestClient();
	restClient.updateLastlogin(userDTO);
	return "status";
	
}

public Map<Integer, String> getLanguageDropdownValues(UserDTO userDTO) {
	
    RestClient restClient=new RestClient();
	
	return restClient.getLanguageDropdownFromUserIdentity(userDTO);
}



public Map<Integer, String> getTimezoneDropdownValues(UserDTO userDTO) {
	RestClient restClient=new RestClient();
	return restClient.getTimezonesFromUserIdentity(userDTO);
}


public boolean registerUserDetails(UserDTO userDTO) {
	boolean status=false;
try {
	RestClient restClient=new RestClient();
    status=restClient.registerconfirmdetails(userDTO) ;
    if(status) {
    	Email email =new Email();
    	email.setEmailid(userDTO.getEmail());
    	email.setMsg("Welcome! The registration process was successful. Please login with your credentials.");
    	restClient.notifyUser(email);
    }
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return status;
	
}

public boolean updatePasswordRequest(UserDTO userDTO) {
	boolean result=false;
	RestClient restClient=new RestClient();
	result=restClient.updatePassword(userDTO);
	return result;
	
}

public boolean updateUserProfileRequest(UserDTO userDTO) {
	boolean result=false;
	RestClient restClient=new RestClient();
	result=restClient.updateUserProfileDetail(userDTO);
	return result;
	
}

public boolean getForgotPasswordRequest(UserDTO userDTO) {
	boolean result=false;
	RestClient restClient=new RestClient();
	result=restClient.getForgotPassword(userDTO);
	return result;
	
}

public UserDTO getUserProfileDetail(UserDTO userDTO){
	RestClient restClient=new RestClient();
		UserDTO profiledetailofuser=restClient.fetchUserProfileDetail(userDTO);
	    return profiledetailofuser;	
		
	
}

public ArrayList<UserDTO> getUserDetails(UserDTO userDTO) {
	RestClient restClient=new RestClient();
	return restClient.getAllUserList(userDTO);
}

public String insertUserDetails(UserDTO userDTO) {
	/*try {
		UserDAO userDAO = new UserDAOImpl();
	    userDAO.insertUserRegistrationDetails(userDTO);
	    return "valid";
	 
	}
		catch(Exception e) {
			System.out.println(e);
		}*/
	RestClient restClient=new RestClient();
	restClient.insertRegistrationDetails(userDTO);
		return "valid";
	}


public ArrayList<UserDTO> getUserList(UserDTO userDTO) {
	// TODO Auto-generated method stub

	RestClient restClient=new RestClient();
		ArrayList<UserDTO> info=restClient.fetchUserList(userDTO);
		
		return info;
	
}


public UserDTO getUpdateUsers(UserDTO userDTO) {
	// TODO Auto-generated method stub
	    RestClient restClient=new RestClient();

		UserDTO res=restClient.fetchUserUpdateProfileDetail(userDTO);
		userDTO.setRes(res);
	    return res;
	}
	

public boolean updateUserInfo(UserDTO userDTO) {
	// TODO Auto-generated method stub
	boolean result=false;
	 RestClient restClient=new RestClient();
	result=restClient.storeUserProfileDetail(userDTO);
	return result;
	
	}
	


public int getLanguageId(UserDTO userDTO) {
	// TODO Auto-generated method stub
	 RestClient restClient=new RestClient();

	 int result=restClient.getDatabaseLanguageId(userDTO);
	 
	 return result;

	}


public boolean deleteUsers(UserDTO userDTO) {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub
		boolean result=false;
		 RestClient restClient=new RestClient();
		result=restClient.deleteUsersProfileDetail(userDTO);
		return result;
	
	
}


public boolean updateUserPassword(UserDTO userDTO) {
	// TODO Auto-generated method stub
	

	boolean result=false;
	RestClient restClient=new RestClient();
		result=restClient.updateUserPasswordRequest(userDTO);
		return result;
	
	
}
}








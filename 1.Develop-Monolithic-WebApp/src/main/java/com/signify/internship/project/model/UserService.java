package com.signify.internship.project.model;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Map;
import com.signify.internship.project.dao.UserDAO;
import com.signify.internship.project.daoimpl.UserDAOImpl;
import com.signify.internship.project.dto.UserDTO;

public class UserService {
	
	public boolean authenticateUser(UserDTO userDTO) {
		
		
			UserDAO userDAO=new UserDAOImpl();
			UserDTO result=userDAO.getUserDetails(userDTO);
			if(null!=result) {
				return true;
			}
			else {
				return false;
			}
			
		}

	
public String getLastLoginTime(UserDTO userDTO) {
	
		 try {
			 UserDAO userDAO=new UserDAOImpl();
			 userDAO.getUsersLastLoginTime(userDTO);
			 userDTO.getZonedDateTime();
		     return "timestamp" ;
}
		catch(Exception e) {
				System.out.println(e);
			  }
		return "invalid";
		}

public String getTimezoneData(UserDTO userDTO) {

	try {
	
	UserDAO userDAO=new UserDAOImpl();
	userDAO.getTimezoneName(userDTO);
	ZoneId la = ZoneId.of(userDTO.getName());
	ZonedDateTime time = ZonedDateTime.now(la);
	System.out.println(time);
	DateTimeFormatter aFormatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd-HH.mm").parseLenient().appendOffset("+HH:MM", "Z").toFormatter();
	String lastlogin = time.format(aFormatter);
	userDTO.setLastlogin(lastlogin);
	userDAO.updateLastLoginTime(userDTO);
	return "status";
	
}
	catch(Exception e) {
		System.out.println(e);
	  }
return "invalid";
}

public Map<Integer, String> getLanguageDropdownValues(UserDTO userDTO) {
	try {
		UserDAO userDAO =new UserDAOImpl();
		Map<Integer,String> res1=userDAO.getLanguageid_name(userDTO);
		userDTO.setResults(res1);
		return res1;
	}
catch(Exception e) {
	System.out.println(e); 
}
	return null;
}



public Map<Integer, String> getTimezoneDropdownValues(UserDTO userDTO) {
	try {
		UserDAO userDAO =new UserDAOImpl();
		Map<Integer,String> results=userDAO.getTimezoneid_name(userDTO);
		userDTO.setResults(results);
		return results;
	}
catch(Exception e) {
	System.out.println(e); 
}
	return null;
}


public boolean registerUserDetails(UserDTO userDTO) {

	try {
	UserDAO userDAO = new UserDAOImpl();
    UserDTO status=userDAO.validateUserDetails(userDTO);
    if (null!=status) {
		  	return true;
    }
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return false;
	
}

public String updatePasswordRequest(UserDTO userDTO) {
	try 
	{
		UserDAO userDAO=new UserDAOImpl();
		userDAO.updatePassword(userDTO);
		return "status";
	}
	catch(Exception e) 
	{
		System.out.println(e);
	}
	return null;
	
}

public String updateUserProfileRequest(UserDTO userDTO) {
	try {
		UserDAO userDAO = new UserDAOImpl();
		userDAO.updateUserProfile(userDTO);
		return "valid";
	}
	catch(Exception e) {
		System.out.println(e);
		
	}
	return "invalid";
	
}

/**
 * @param c
 * @return
 */
public boolean getForgotPasswordRequest(UserDTO userDTO) {
	try {
		UserDAO userDAO=new UserDAOImpl();
		UserDTO result=userDAO.validatePasswordRequest(userDTO);
		if(null!=result) {
		return true;
		
	}
		else
		{
			return false;
		}
		}
	catch(Exception e)
	{
		System.out.println(e);
		
	}
	return false;
	
}

public UserDTO getUserProfileDetail(UserDTO userDTO){
	try {
		UserDAO userDAO=new UserDAOImpl();
		
		UserDTO res=userDAO.fetchUserProfileDetail(userDTO);
		userDTO.setRes(res);
	    return res;	
		
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return null;
	
}

public ArrayList<UserDTO> getUserDetails(UserDTO userDTO) {
	try {
		UserDAO userDAO =new UserDAOImpl();
		ArrayList<UserDTO> result=userDAO.userDetails(userDTO);
		userDTO.setResult(result);
		return result;
		}
	catch(Exception e) {
		System.out.println(e);
	}
	return null;
}

public String insertUserDetails(UserDTO userDTO) {
	try {
		UserDAO userDAO = new UserDAOImpl();
	    userDAO.insertUserRegistrationDetails(userDTO);
	    return "valid";
	 
	}
		catch(Exception e) {
			System.out.println(e);
		}
		return "invalid";
	}


public ArrayList<UserDTO> getUserList(UserDTO userDTO) {
	// TODO Auto-generated method stub
	try {
		UserDAO userDAO=new UserDAOImpl();
		ArrayList<UserDTO> info=userDAO.fetchUserList(userDTO);
		userDTO.setInfo(info);
		return info;
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return null;
}


public UserDTO getUpdateUsers(UserDTO userDTO) {
	// TODO Auto-generated method stub
	try {
		UserDAO userDAO=new UserDAOImpl();
		UserDTO res=userDAO.fetchUserUpdateProfileDetail(userDTO);
		userDTO.setRes(res);
	    return res;
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return null;
	
}
}







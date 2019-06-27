package com.signify.internshipproject.webappservice.model;
	import java.time.ZoneId;
	import java.time.ZonedDateTime;
	import java.time.format.DateTimeFormatter;
	import java.time.format.DateTimeFormatterBuilder;
	import java.util.ArrayList;
	import java.util.Map;

import com.signify.internshipproject.useridentityservice.dao.UserDAO;
import com.signify.internshipproject.useridentityservice.daoimpl.userDAOImpl;
import com.signify.internshipproject.webappservice.dto.UserDTO;

	public class UserServiceModel {
		
		public boolean authenticateUser(UserDTO userDTO) {
			
			
				UserDAO userDAO=new userDAOImpl();
				System.out.println(userDTO.getUsername());
				System.out.println(userDTO.getPassword());
				UserDTO result=userDAO.getLoginUserDetails(userDTO);
				if(null!=result) {
					return true;
				}
				else {
					return false;
				}
				
			}

		
	public String getLastLoginTime(UserDTO userDTO) {
		
			 try {
				 UserDAO userDAO=new userDAOImpl();
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
		
		UserDAO userDAO=new userDAOImpl();
		userDAO.getTimezoneName(userDTO);
		ZoneId la = ZoneId.of(userDTO.getName());
		ZonedDateTime time = ZonedDateTime.now(la);
		System.out.println(time);
		DateTimeFormatter aFormatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd-HH.mm.ss").parseLenient().appendOffset("+HH:MM", "Z").toFormatter();
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
			UserDAO userDAO =new userDAOImpl();
			Map<Integer,String> languagedropdownvalues=userDAO.getLanguageid_name(userDTO);
			userDTO.setResults(languagedropdownvalues);
			return languagedropdownvalues;
		}
	catch(Exception e) {
		System.out.println(e); 
	}
		return null;
	}



	public Map<Integer, String> getTimezoneDropdownValues(UserDTO userDTO) {
		try {
			UserDAO userDAO =new userDAOImpl();
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
		UserDAO userDAO = new userDAOImpl();
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
			UserDAO userDAO=new userDAOImpl();
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
			UserDAO userDAO = new userDAOImpl();
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
			UserDAO userDAO=new userDAOImpl();
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
			UserDAO userDAO=new userDAOImpl();
			
			UserDTO profiledetailofuser=userDAO.fetchUserProfileDetail(userDTO);
			userDTO.setUserProfileDetail(profiledetailofuser);
		    return profiledetailofuser;	
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

	public ArrayList<UserDTO> getUserDetails(UserDTO userDTO) {
		try {
			UserDAO userDAO =new userDAOImpl();
			ArrayList<UserDTO> result=userDAO.getUserRegisteredDetails(userDTO);
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
			UserDAO userDAO = new userDAOImpl();
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
			UserDAO userDAO=new userDAOImpl();
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
			UserDAO userDAO=new userDAOImpl();
			UserDTO res=userDAO.fetchUserUpdateProfileDetail(userDTO);
			userDTO.setRes(res);
		    return res;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}


	public String updateUserInfo(UserDTO userDTO) {
		// TODO Auto-generated method stub
		try {
		UserDAO userDAO =new userDAOImpl();
		userDAO.storeUserProfileDetail(userDTO);
		
		return "status";
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}


	public int getLanguageId(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		try {
			 UserDAO userDAO=new userDAOImpl();
			 int language_id=userDAO.getDatabaseLanguageId(userDTO);
		     return language_id;
	    }
		catch(Exception e) {
				System.out.println(e);
			  }
		return 0;

		}


	public String deleteUsers(UserDTO userDTO) {
		// TODO Auto-generated method stub
		try {
			UserDAO userDAO=new userDAOImpl();
			userDAO.deleteUsersProfileDetail(userDTO);
			return "status";
		
		}
		catch(Exception e) {
			System.out.println(e);
		}

		return null;

	}


	public String updateUserPassword(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		try {
			UserDAO userDAO = new userDAOImpl();
			userDAO.updateUserPasswordRequest(userDTO);
			return "valid";
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		return "invalid";
		
	}
	}












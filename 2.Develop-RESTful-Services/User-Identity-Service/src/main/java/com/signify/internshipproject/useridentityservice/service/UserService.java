package com.signify.internshipproject.useridentityservice.service;



import java.util.List;

import javax.ws.rs.core.Response;

import com.signify.internshipproject.useridentityservice.model.UserInfo;
import com.signify.internshipproject.useridentityservice.model.UserRegisterInfo;

public interface UserService {
	
		public UserInfo getUserProfile(String username);
		public List<UserInfo> getAllRegisteredUsers();
		public Response registerUserDetails(UserRegisterInfo userReg);
		public Response deletePerson(String username);
		public Response updateUserDetail(String username, UserInfo userReg);	
		public Response authenticatelogincredentials(UserInfo userInfo);
		public UserInfo getLastlogintime(String username);
		public UserInfo getLanguageId(String username);
		public Response updateTimezoneName(String userName);
		
		
		
}

	


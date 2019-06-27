package com.signify.internshipproject.useridentityservice.service;



import com.signify.internshipproject.useridentityservice.dto.UserDTO;
import com.signify.internshipproject.useridentityservice.model.Response;
import com.signify.internshipproject.useridentityservice.model.UserInfo;
import com.signify.internshipproject.useridentityservice.model.UserLastlogin;
import com.signify.internshipproject.useridentityservice.model.UserRegisterInfo;

public interface UserService {
	
		public UserInfo getUserProfile(String username);
		public UserInfo getAllRegisteredUsers();
		public Response registerUserDetails(UserRegisterInfo userReg);
		public Response deletePerson(String username);
		public Response updateUserDetail(String username,UserRegisterInfo userReg);	
		public Response authenticatelogincredentials(UserDTO userDTO);
		public UserLastlogin getLastlogintime(String username);
		
}

	


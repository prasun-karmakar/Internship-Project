package com.signify.internshipproject.webappservice.service;



import com.signify.internshipproject.webappservice.dto.UserDTO;
import com.signify.internshipproject.webappservice.model.Response;
import com.signify.internshipproject.webappservice.model.UserInfo;
import com.signify.internshipproject.webappservice.model.UserLastlogin;
import com.signify.internshipproject.webappservice.model.UserRegisterInfo;

public interface UserService {
	
		public UserInfo getUserProfile(String username);
		public UserInfo getAllRegisteredUsers();
		public Response registerUserDetails(UserRegisterInfo userReg);
		public Response deletePerson(String username);
		public Response updateUserDetail(String username,UserRegisterInfo userReg);	
		public Response authenticatelogincredentials(UserDTO userDTO);
		public UserLastlogin getLastlogintime(String username);
		
}

	


package com.signify.internshipproject.service;
import com.signify.internshipproject.model.*;
public interface UserService {
	


		public Response addPerson(UserInfo p);
		
		public Response deletePerson(int id);
		
		public UserInfo getPerson(int id);
		
		public UserInfo[] getAllPersons();

	}

	


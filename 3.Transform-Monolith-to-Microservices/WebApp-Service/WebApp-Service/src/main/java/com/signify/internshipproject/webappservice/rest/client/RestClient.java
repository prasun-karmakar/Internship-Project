package com.signify.internshipproject.webappservice.rest.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.signify.internshipproject.webappservice.dto.UserDTO;

public class RestClient {
	
	private Client client = ClientBuilder.newClient(); 

   public boolean authenticateUser(UserDTO userDTO) {  //Rest client authenticate
		boolean status=false;
		Response response=client.target("http://10.10.21.106:8080/User-Identity-Service/userinfo/authenticateuser").request(MediaType.APPLICATION_JSON).post(Entity.entity(userDTO, MediaType.APPLICATION_JSON));
		status=response.getStatus()==200?true:false;
		return status; 
	}
   
   
	
/*	public static void main(String args[]) {
		UserDTO userDTO=new UserDTO();
		userDTO.setUsername("sindhu");
		userDTO.setPassword("kavya");
		//Response response=new RestClient().authenticateUser(userDTO);
		boolean response=new RestClient().authenticateUser(userDTO);
		System.out.println(response);
	}*/
	
	/*

	public class JerseyClient {
		private static final String REST_URI = "http://10.10.21.107:8080/Notification-Service/notify/email"; 
		private Client client = ClientBuilder.newClient(); 

		public static void main(String[] args) {
			Email email=new Email();
			email.setEmailid("sindhu.mr@signify.com");
			email.setMsg("I am fine");
			Response response=new JerseyClient().createJsonEmail(email);
			System.out.println(response.getStatus());
		}
		
	         public Response createJsonEmail(Email info) { 
	        		return client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(info, MediaType.APPLICATION_JSON)); 
		    
	         } 
	 
	}   


	*/

	public boolean getLastlogintime(UserDTO userDTO) { //rest client lastlogin
		// TODO Auto-generated method stub
		boolean status=false;
		//Invoke REST API
		return status;
	}
	
	public Map<Integer, String> getTimezonesFromUserIdentity(UserDTO userDTO){ //rest client gettimezones
		//Invoke REST API here
		///
		Map<Integer, String> timezoneMap=new HashMap<Integer, String>(20);
		timezoneMap.put(1,"Asia/Amman");
		timezoneMap.put(2,"Asia/Dacca");
		timezoneMap.put(3,"Asia/Beirut");
		timezoneMap.put(4,"Asia/Damascus");
		timezoneMap.put(5,"Pacific/Tahiti");
		return timezoneMap;
		
	}


	public Map<Integer, String> getLanguageDropdownFromUserIdentity(UserDTO userDTO) { //rest client getlanguagename
		// TODO Auto-generated method stub
		Map<Integer, String> languageMap=new HashMap<Integer, String>(20);
		languageMap.put(1,"English");
		languageMap.put(2,"French");
		return languageMap;
		
	}
/*

public class JerseyClient {
	private static final String REST_URI = "http://10.10.21.107:8080/Notification-Service/notify/email"; 
	private Client client = ClientBuilder.newClient(); 

	public static void main(String[] args) {
		Email email=new Email();
		email.setEmailid("sindhu.mr@signify.com");
		email.setMsg("I am fine");
		Response response=new JerseyClient().createJsonEmail(email);
		System.out.println(response.getStatus());
	}
	
         public Response createJsonEmail(Email info) { 
        		return client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(info, MediaType.APPLICATION_JSON)); 
	    
         } 
 
}   


*/
	
	public Response registerconfirmdetails(UserDTO userDTO) {
		UserRegisterInfo info=new UserRegisterInfo();
		info.setUsername(userDTO.getUsername());
		info.setPassword(userDTO.getPassword());
		info.setMobileno(userDTO.getMobileno());
		info.setEmail(userDTO.getEmail());
		info.setLanguage_id(userDTO.getLanguage_id());
		info.setTimezone_id(userDTO.getTimezone_id());
		System.out.println(info);
		return client.target("http://10.10.21.106:8080/User-Identity-Service/userinfo/registerconfirm").request(MediaType.APPLICATION_JSON).post(Entity.entity(info, MediaType.APPLICATION_JSON)); 
	}


	public boolean updatePassword(UserDTO userDTO) {
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public boolean updateUserProfileDetail(UserDTO userDTO) {
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public boolean getForgotPassword(UserDTO userDTO) {
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public UserDTO fetchUserProfileDetail(UserDTO userDTO) {
		// TODO Auto-generated method stub
		UserRegisterInfo info=new UserRegisterInfo();
		info.setUsername(userDTO.getUsername());
		info.setPassword(userDTO.getPassword());
		info.setMobileno(userDTO.getMobileno());
		info.setEmail(userDTO.getEmail());
		info.setLanguage_id(userDTO.getLanguage_id());
		info.setTimezone_id(userDTO.getTimezone_id());
		//return client.target("http://localhost:8080/User-Identity-Service/userinfo/registerconfirm").request(MediaType.APPLICATION_JSON).post(Entity.entity(info, MediaType.APPLICATION_JSON));
		return userDTO;
	}


	


	public String getTimezoneName(UserDTO userDTO) {
		// TODO Auto-generated method stub
		//Invoke REST AP
		return null;
	}


	public boolean updateLastLoginTime(UserDTO userDTO) {
		
		// TODO Auto-generated method stub
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public ArrayList<UserDTO> getAllUserList(UserDTO userDTO) {
		// TODO Auto-generated method stub
		ArrayList<UserDTO> userRecords=new ArrayList<>();
		//UserRecords.add("sindhu","")
		return userRecords;
	}


	public boolean insertRegistrationDetails(UserDTO userDTO) {
		boolean status=false;
		return status;
		// TODO Auto-generated method stub
		
	}


	public ArrayList<UserDTO> fetchUserList(UserDTO userDTO) {
		// TODO Auto-generated method stub
		ArrayList<UserDTO> userList=new ArrayList<>();
		return userList;
	}


	public UserDTO fetchUserUpdateProfileDetail(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
		return null;
	}


	public boolean storeUserProfileDetail(UserDTO userDTO) {
		// TODO Auto-generated method stub
		boolean status=false;
		return status;
		
	}


	public int getDatabaseLanguageId(UserDTO userDTO) {
		// TODO Auto-generated method stub
		int status=0;
		//Invoke REST API
		return status;
	}


	public boolean deleteUsersProfileDetail(UserDTO userDTO) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				boolean status=false;
				//Invoke REST AP
				return status;

	}


	public boolean updateUserPasswordRequest(UserDTO userDTO) {
		// TODO Auto-generated method stub
		boolean status=false;
		//Invoke REST AP
		return status;
		
	}
	
	/*public static void main(String[] args) {
		UserRegisterInfo info=new UserRegisterInfo();
		info.setUsername("sanjana");
		info.setPassword("shreshta");
		info.setMobileno("1234567890");
		info.setEmail("sindhu@gmail.com");
		info.setLanguage_id("1");
		info.setTimezone_id("2");
		Response response=new RestClient().registerconfirmdetails(info);
		System.out.println(response.getStatus());
	}*/
	
         
	
	
}

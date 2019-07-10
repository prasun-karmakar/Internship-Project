package com.signify.internshipproject.webappservice.rest.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.signify.internshipproject.webappservice.dto.UserDTO;
import com.signify.internshipproject.webappservice.rest.domain.UserInfo;

public class RestClient {
	
	private static final String NOTOFICATION_SERVICE_URI = "http://10.10.21.107:8080/Notification-Service/notify/email";
	private String SERVER_ADDRESS="http://10.10.21.106:8080/User-Identity-Service";
	//private String SERVER_ADDRESS="http://localhost:8080/User-Identity-Service";
	private String REST_URI_REGISTER_CONFIRM=SERVER_ADDRESS+"/userinfo/registerconfirm";
	
	private Client client = ClientBuilder.newClient(); 

	public static void main(String[] args) {
		UserDTO userDTO=new UserDTO();
		userDTO.setUsername("user1");
		userDTO.setPassword("password");
		userDTO.setEmail("abc@xyz.com");
		userDTO.setMobileno("1234567");
		userDTO.setLanguage_id("1");
		userDTO.setTimezone_id("1");
		//new RestClient().registerconfirmdetails(userDTO);
		//new RestClient().getLastlogintime(userDTO);
		//new RestClient().getDatabaseLanguageId(userDTO);
		//new RestClient().authenticateUser(userDTO);
		//new RestClient().updateLastlogin(userDTO);
		//new RestClient().updateUserProfileDetail(userDTO);
		new RestClient().getUserList();
		//new RestClient().getUserInfo(userDTO);
	}
	
	public void getUserList() {
		
		String URI=SERVER_ADDRESS+"/userinfo/getAll";
		List<UserInfo> userInfoList=client.target(URI).request(MediaType.APPLICATION_JSON).get().readEntity(new GenericType<List<UserInfo>>() {});
		
		for(UserInfo response:userInfoList) {
			String userNameResp=response.getUserName();
			System.out.println(userNameResp);
			String email=response.getEmailId();
			System.out.println(email);
		}
	}

	public void getUserInfo(UserDTO userDTO) {
		boolean status=false;
		//Invoke REST API
		//get the user name
		String userName=userDTO.getUsername();
		String URI=SERVER_ADDRESS+"/userinfo/"+userName+"/getuserinfo";
		UserInfo response=client.target(URI).request(MediaType.APPLICATION_JSON).get(UserInfo.class);
		String userNameResp=response.getUserName();
		System.out.println(userNameResp);
		String email=response.getEmailId();
		System.out.println(email);
		
	}
	
   public boolean authenticateUser(UserDTO userDTO) {  //Rest client authenticate
		boolean status=false;
		String URI=SERVER_ADDRESS+"/userinfo/authenticateuser";
		UserInfo userInfo=new UserInfo();
		userInfo.setUserName(userDTO.getUsername());
		userInfo.setPassword(userDTO.getPassword());
		Response response=client.target(URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(userInfo, MediaType.APPLICATION_JSON));
		status=response.getStatus()==200?true:false;
		System.out.println(status);
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
		//get the user name
		String userName=userDTO.getUsername();
		String URI=SERVER_ADDRESS+"/userinfo/"+userName+"/getlastlogin";
		UserInfo response=client.target(URI).request(MediaType.APPLICATION_JSON).get(UserInfo.class);
		String lastLogintime=response.getLastLogintime();
		System.out.println(lastLogintime);
		userDTO.setZonedDateTime(lastLogintime);
		
		return status;
	}
	
	public Map<Integer, String> getTimezonesFromUserIdentity(UserDTO userDTO){ //rest client gettimezones
		//Invoke REST API here
		///
		Map<Integer, String> timezoneMap=new HashMap<Integer, String>(20);
		timezoneMap.put(1,"Asia/Kolkata");
		timezoneMap.put(2,"Europe/Paris");
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
	public boolean notifyUser(Email email) {
		Response response=client.target(NOTOFICATION_SERVICE_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(email, MediaType.APPLICATION_JSON));
		return (response.getStatus()==Response.Status.OK.getStatusCode())?true:false;
	}
	
	public boolean registerconfirmdetails(UserDTO userDTO) {
		boolean isCreated=false;
		UserRegisterInfo info=new UserRegisterInfo();
		info.setUsername(userDTO.getUsername());
		info.setPassword(userDTO.getPassword());
		info.setMobileno(userDTO.getMobileno());
		info.setEmail(userDTO.getEmail());
		info.setLanguage_id(userDTO.getLanguage_id());
		info.setTimezone_id(userDTO.getTimezone_id());
		System.out.println(info);
		Response response=client.target(REST_URI_REGISTER_CONFIRM).request(MediaType.APPLICATION_JSON).post(Entity.entity(info, MediaType.APPLICATION_JSON));
		isCreated=(Response.Status.CREATED.getStatusCode()==response.getStatus())?true:false;
		System.out.println(isCreated);
		return isCreated;
	}


	public boolean updatePassword(UserDTO userDTO) {
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public boolean updateUserProfileDetail(UserDTO userDTO) {
		boolean status=false;
		//Invoke REST AP
		String userName=userDTO.getUsername();
		UserInfo userInfo=new UserInfo();
		userInfo.setEmailId(userDTO.getEmail());
		userInfo.setLanguageId(Integer.valueOf(userDTO.getLanguage_id()));
		userInfo.setTimezoneId(Integer.valueOf(userDTO.getTimezone_id()));
		String URI=SERVER_ADDRESS+"/userinfo/"+userName+"/update";
		Response response=client.target(URI).request(MediaType.APPLICATION_JSON).put(Entity.entity(userInfo, MediaType.APPLICATION_JSON));
		
		return (response.getStatus()==Response.Status.OK.getStatusCode())?true:false;
		
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



	public boolean updateLastlogin(UserDTO userDTO) {
		//Invoke REST AP
		String userName=userDTO.getUsername();
		String URI=SERVER_ADDRESS+"/userinfo/"+userName+"/lastlogin";
		Response response=client.target(URI).request(MediaType.APPLICATION_JSON).put(Entity.entity(String.class, MediaType.APPLICATION_JSON));
		boolean status=(response.getStatus()==Response.Status.OK.getStatusCode())?true:false;
		System.out.println(status);
		
		return status;
	}


	public boolean updateLastLoginTime(UserDTO userDTO) {
		
		// TODO Auto-generated method stub
		boolean status=false;
		//Invoke REST AP
		return status;
	}


	public ArrayList<UserDTO> getAllUserList(UserDTO userDTO) {
		// TODO Auto-generated method stub
		ArrayList<UserDTO> userRecords=new ArrayList<UserDTO>();
		
		String URI=SERVER_ADDRESS+"/userinfo/getAll";
		List<UserInfo> userInfoList=client.target(URI).request(MediaType.APPLICATION_JSON).get().readEntity(new GenericType<List<UserInfo>>() {});
		
		for(UserInfo response:userInfoList) {
			
			String userNameResp=response.getUserName();
			System.out.println(userNameResp);
			String email=response.getEmailId();
			System.out.println(email);
			
			UserDTO userDTOResult=new UserDTO();
			
			 userDTOResult.setUsername(response.getUserName());

		     userDTOResult.setEmail(response.getEmailId());

		     userDTOResult.setMobileno(response.getMobileNo());

		     userDTOResult.setName(response.getTimezoneName());

		     userDTOResult.setLanguage_name(response.getLanguage());

		     userRecords.add(userDTOResult);

		     userDTOResult.setUserRec(userRecords);
		}
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
		String userName=userDTO.getUsername();
		String URI=SERVER_ADDRESS+"/userinfo/"+userName+"/language";
		UserInfo response=client.target(URI).request(MediaType.APPLICATION_JSON).get(UserInfo.class);
		System.out.println(response.getLanguageId());
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

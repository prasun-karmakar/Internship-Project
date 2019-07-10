package com.signify.internshipproject.useridentityservice.service;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.signify.internshipproject.useridentityservice.dto.UserDTO;
import com.signify.internshipproject.useridentityservice.model.UserInfo;
import com.signify.internshipproject.useridentityservice.model.UserRegisterInfo;


@Path("/userinfo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserImpl implements UserService {


	
	
	@Override
	@GET
	@Path("/{username}/getuserinfo")
	public UserInfo getUserProfile(@PathParam("username") String username) { //myprofile
		System.out.println("Received User Name:"+username);
		UserDTO userDTO = new UserDTO();
		RestHandler handler=new RestHandler();
		UserInfo userinfo=new UserInfo();
		userDTO.setUsername(username);
		userinfo=handler.getProfileDetail(userDTO);
		
		return userinfo;
	}
	
	@Override
	@GET
	@Path("/getAll")
	public List<UserInfo> getAllRegisteredUsers() {  //getAllregisteredusers
		UserDTO userDTO = new UserDTO();
		RestHandler info=new RestHandler();
		ArrayList<UserDTO> res=info.getRegisteredUsers(userDTO);
		System.out.println(res);
		List<UserInfo> userInfoList=new ArrayList<UserInfo>();

		
		for(UserDTO dto:res) { 
		  UserInfo userInfo=new UserInfo();
		  userInfo.setUserName(dto.getUsername());
		  userInfo.setEmailId(dto.getEmail());
		  userInfo.setMobileNo(dto.getMobileno());
		  userInfo.setLanguage(dto.getLanguage_name());
		  userInfo.setTimezoneName(dto.getName());
		  
		  userInfoList.add(userInfo);
		  
		  }
		 
		return userInfoList;
	
	}
	
	@Override
	@POST
    @Path("/registerconfirm")
	public Response registerUserDetails(UserRegisterInfo userReg) { //Register confirm
		UserDTO userDTO = new UserDTO();
	
		RestHandler handler=new RestHandler();
		userDTO.setUsername(userReg.getUsername());
		userDTO.setPassword(userReg.getPassword());
		userDTO.setRegisterconfirmpassword(userReg.getUsername());
		userDTO.setEmail(userReg.getEmail());
		userDTO.setMobileno(userReg.getMobileno());
		userDTO.setTimezone_id(userReg.getTimezone_id());
		userDTO.setLanguage_id(userReg.getLanguage_id());
		boolean status=handler.registerUserDetails(userDTO);
		System.out.println(status); 

		return Response.status(Response.Status.CREATED.getStatusCode()).build();
	} 
	
	
	@Override
	@DELETE
    @Path("/{username}/delete")
	public Response deletePerson(@PathParam("username") String username) { //DeleteRecords
		UserDTO userDTO = new UserDTO();
		RestHandler info=new RestHandler();
		userDTO.setUsername(username);
		boolean status=info.deleteUserDetail(userDTO);
		System.out.println(status);
		return Response.status(Status.OK.getStatusCode()).entity(status).build();
	}
	
	@Override
	@PUT
	@Path("/{username}/update")
	public Response updateUserDetail(@PathParam("username") String username,UserInfo userInfo) { //editUserDetails in submission
		UserDTO userDTO = new UserDTO();
		
		RestHandler info=new RestHandler();
		userDTO.setUsername(userInfo.getUserName());
		userDTO.setPassword(userInfo.getPassword());
		userDTO.setEmail(userInfo.getEmailId());
		userDTO.setMobileno(userInfo.getMobileNo());
		userDTO.setTimezone_id(String.valueOf(userInfo.getTimezoneId()));
		userDTO.setLanguage_id(String.valueOf(userInfo.getLanguageId()));
		boolean status=info.editUserDetails(userDTO);
		System.out.println(status); 
		return Response.status(200).entity(status).build();
}
	
	@Override
	@GET
	@Path("/{username}/getlastlogin")
	public UserInfo getLastlogintime(@PathParam("username") String username) { //Users lastlogintime
		UserDTO userDTO = new UserDTO();
		RestHandler handler=new RestHandler();
		UserInfo userInfo=new UserInfo();
		userDTO.setUsername(username);
		handler.getLastlogintime(userDTO);
		userInfo.setLastLogintime(userDTO.getZonedDateTime());
		
		return userInfo;
	}
	
	@Override
	@GET
	@Path("/{username}/language")
	public UserInfo getLanguageId(@PathParam("username") String username) { //Users lastlogintime
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(username);

		RestHandler handler=new RestHandler();
		UserInfo userInfo=handler.getLanguageId(userDTO);
		System.out.println(userInfo.getLanguageId());
		return userInfo;
	}

	@Override
	@POST
    @Path("/authenticateuser")
	public Response authenticatelogincredentials(UserInfo userInfo) { //Login authentication
		
		
		RestHandler handler=new RestHandler();
		
		boolean status=handler.authenticateuserlogin(userInfo);
		
		System.out.println(status); 
		if(status) {
		return Response.status(200).entity(status).build();
		}
		else {
			return Response.status(404).entity(status).build();
		}
	
	}
	
	@PUT
	@Path("/{username}/lastlogin")
	public Response updateTimezoneName(@PathParam("username") String userName) {
		UserDTO userDTO=new UserDTO();
		userDTO.setUsername(userName);
		RestHandler handler=new RestHandler();
		
		boolean status=handler.getTimezoneName(userDTO);
		
		System.out.println(status); 
		
		if(status) {
		return Response.status(Response.Status.OK.getStatusCode()).entity(status).build();
		}
		else {
			return Response.status(Status.NOT_MODIFIED.getStatusCode()).entity(status).build();
		}
		
	}
}

	
	






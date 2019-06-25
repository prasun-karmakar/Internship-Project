package com.signify.internshipproject.notificationservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.signify.internshipproject.notificationservice.handler.NotificationServiceHandler;
import com.signify.internshipproject.notificationservice.handler.NotificationServiceHandlerImpl;
import com.signify.internshipproject.notificationservice.model.Email;
import com.signify.internshipproject.notificationservice.model.Response;


@Path("/notify")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NotificationServiceImpl implements NotificationService {
	
	@Override
	@POST
    @Path("/email")
	public Response sendEmail(Email info) {
		Response response = new Response();
		NotificationServiceHandler handler=new NotificationServiceHandlerImpl();
		boolean status=handler.sendEmail(info);
		if(status) {
		response.setStatus(true);
		response.setMessage("email sent successfully");}
		else
		{
			response.setStatus(false);
			response.setMessage("email not sent");
		}
		return response;
		
	}

}
/*
 @Override
	@POST
    @Path("/registerconfirm")
	public Response registerUserDetails(UserRegisterInfo userReg) { //Register confirm
		UserDTO userDTO = new UserDTO();
		Response response = new Response();
		RestHandler info=new RestHandler();
		userDTO.setUsername(userReg.getUsername());
		userDTO.setPassword(userReg.getPassword());
		userDTO.setRegisterconfirmpassword(userReg.getUsername());
		userDTO.setEmail(userReg.getEmail());
		userDTO.setMobileno(userReg.getMobileno());
		userDTO.setTimezone_id(userReg.getTimezone_id());
		userDTO.setLanguage_id(userReg.getLanguage_id());
		boolean status=info.registerUserDetails(userDTO);
		System.out.println(status); 
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response;
	} 
	
*/
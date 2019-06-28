package com.signify.internshipproject.webappservice.rest.client;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



 
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


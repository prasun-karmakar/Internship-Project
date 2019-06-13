package com.signify.internshipproject.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.signify.internshipproject.model.UserInfo;
import com.signify.internshipproject.model.Response;


@Path("/userinfo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserImpl implements UserService {

	private static Map<Integer,UserInfo> persons = new HashMap<Integer,UserInfo>();
	
	@Override
	@POST
    @Path("/add")
	public Response addPerson(UserInfo p) {
		Response response = new Response();
		if(persons.get(p.getId()) != null){
			response.setStatus(false);
			response.setMessage("Person Already Exists");
			return response;
		}
		persons.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Person created successfully");
		return response;
	}

	@Override
	@GET
    @Path("/{id}/delete")
	public Response deletePerson(@PathParam("id") int id) {
		Response response = new Response();
		if(persons.get(id) == null){
			response.setStatus(false);
			response.setMessage("Person Doesn't Exists");
			return response;
		}
		persons.remove(id);
		response.setStatus(true);
		response.setMessage("Person deleted successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/get")
	public UserInfo getPerson(@PathParam("id") int id) {
		return persons.get(id);
	}
	
	@GET
	@Path("/{id}/getDummy")
	public UserInfo getDummyPerson(@PathParam("id") int id) {
	UserInfo p = new UserInfo();
		p.setAge(99);
		p.setName("Dummy");
		p.setId(id);
		return p;
	}

	@Override
	@GET
	@Path("/getAll")
	public UserInfo[] getAllPersons() {
		Set<Integer> ids = persons.keySet();
		UserInfo[] p = new UserInfo[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = persons.get(id);
			i++;
		}
		return p;
	}

}






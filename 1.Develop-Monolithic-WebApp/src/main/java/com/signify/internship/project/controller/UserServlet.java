package com.signify.internship.project.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.signify.internship.project.dto.UserDTO;
import com.signify.internship.project.model.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/loginRegister")

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UserServlet() {

		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionType = request.getParameter("actionType");
		if (actionType.equals("login")) {
			processLoginRequestParameter(request, response);
		} 
		
		else if (actionType.equals("newregister")) {//newRegistraionReq
			processRegisterRequestParameter(request, response);
		}
		else if (actionType.equals("confirmRegistration")) {
			ProcessRegisterConfirmRequestParameter(request, response);
		}
		else if (actionType.equals("Forgotpasswordpage")) {
			processForgotPasswordPage(request, response);
		}
		else if (actionType.equals("forgotpassword")) {
			ProcessForgotPasswordRequestParameter(request, response);
		}
		else if (actionType.equals("resetpassword")) {
			ProcessResetPasswordRequestParameter(request, response);
		}
		else if(actionType.equals("list_UserRecords")) {
			ProcessUsersRecordRequestParameter(request,response);
		}
		else if(actionType.equals("myProfile")) {
		    ProcessUserProfileRequestParameter(request,response);	
		}
		else if(actionType.equals("deleteRecords")) {
			ProcessUserDeleteRequestParameter(request,response);
		}
		
		else if (actionType.equals("updatePassword")) {
			processUpdatePasswordRequestParameter(request, response);
		}
		else if (actionType.equals("update")) {
			ProcessUserUpdateRecordRequestParameter(request, response);
		}
		else if(actionType.equals("updateRecords")) {
			ProcessUserUpdateRequestParameter(request,response);
		}
		else if(actionType.equals("editUserProfile")) {
		    ProcessEditUserProfileRequestParameter(request,response);	
		}
		else if (actionType.equals("logout")) {
		    ProcessLogoutRequestParameter(request, response);
		}
	}
	
	
	private void  processUpdatePasswordRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		String username = request.getParameter("Username");
		System.out.println(username);
		String newpassword = request.getParameter("Newpassword");
		System.out.println(newpassword);
		String confirmpassword= request.getParameter("Confirmpassword");
		System.out.println(confirmpassword);
		userDTO.setUsername(username);
		userDTO.setNewpassword(newpassword);
		userDTO.setConfirmpassword(confirmpassword);
		userService.updateUserPassword(userDTO);
		
}
	
	
	
	private void  ProcessUserUpdateRecordRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		String username = request.getParameter("Username");
		String email = request.getParameter("Email");
		String mobile_no = request.getParameter("Mobileno");
		String timezone_id = request.getParameter("Timezone_id");
		String language_id = request.getParameter("Language_id");
		userDTO.setUsername(username);
		userDTO.setEmail(email);
		userDTO.setLanguage_id(language_id);
		userDTO.setMobileno(mobile_no);
		userDTO.setTimezone_id(timezone_id);
		userService.updateUserInfo(userDTO);
		
	
		
}
	
	
	
	private void processLoginRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get user name & password from request
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDTO userDTO = new UserDTO();
	    userDTO.setUsername(username);
		userDTO.setPassword(password);
		UserService userService=new UserService();
		boolean status = userService.authenticateUser(userDTO);
	

		if (status) {
			HttpSession session=request.getSession();
			session.setAttribute("username",username);
			session.setMaxInactiveInterval(1*60);
			userService.getLastLoginTime(userDTO);
			session.setAttribute("Lastlogin", userDTO.getZonedDateTime());
			userService.getTimezoneData(userDTO);
			Map<Integer,String> timezone_list = userService.getTimezoneDropdownValues(userDTO);
			Map<Integer,String> language_list = userService.getLanguageDropdownValues(userDTO);
			int languageid=userService.getLanguageId(userDTO);
			request.setAttribute("language_list",language_list);
			request.setAttribute("timezone_list",timezone_list);
			session.setAttribute("language_id",languageid);
			request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);

			
		} else {
			request.setAttribute("message", "Data Not Found,click on Register !!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}
	
	private void ProcessUserDeleteRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		String username = request.getParameter("Username"); 
		userDTO.setUsername(username);
		System.out.print(username);
	    userService.deleteUsers(userDTO);
		
}

	
	

	private void ProcessUserUpdateRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		String username = request.getParameter("Username"); 
		userDTO.setUsername(username);
		System.out.print(username);
		UserDTO res=userService.getUpdateUsers(userDTO);
		StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("{");
		sb.append("\"Username\":"+"\""+res.getUsername().trim()+"\",");
		sb.append("\"Email\":"+"\""+res.getEmail()+"\",");
		sb.append("\"Mobileno\":"+res.getMobileno()+",");
	    sb.append("\"Timezone_id\":"+"\""+res.getTimezone_id()+"\",");
	    sb.append("\"Language_id\":"+"\""+res.getLanguage_id()+"\"");
		sb.append("}");
		sb.append("]");
		System.out.println(sb.toString());
		   response.setContentType("application/json");
	       response.setCharacterEncoding("UTF-8");
		   response.getWriter().write(sb.toString()); 
}

	

	private void  ProcessUserProfileRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		HttpSession session=request.getSession(false);
		String username=(String)session.getAttribute("username");
		userDTO.setUsername(username);
	    UserDTO res=userService.getUserProfileDetail(userDTO);
		StringBuilder Document = new StringBuilder(); // create a generic XML string
			   Document.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			   Document.append("<MyProfile>");//declare the root.
			   Document.append("\n");
			   Document.append("<User>");//declare the child.
			   Document.append("\n");
			   Document.append("<UserID>");//declare the sub child.
			   Document.append(res.getUsername()); 
			   Document.append("</UserID>");
			   Document.append("\n");
			   Document.append("<Mobileno>");
			   Document.append(res.getMobileno());
			   Document.append("</Mobileno>");
			   Document.append("\n");
			   Document.append("<lastlogin>");
			   Document.append(res.getLastlogin());
			   Document.append("</lastlogin>");
			   Document.append("\n");
			   Document.append("<Language_Id>");//declare the sub child.
			   Document.append(res.getLanguage_name()); 
			   Document.append("</Language_Id>");
			   Document.append("\n");
			   Document.append("<email>");
			   Document.append(res.getEmail());
			   Document.append("</email>");
			   Document.append("\n");
			   Document.append("<name>");
			   Document.append(res.getName());
			   Document.append("</name>");
			   Document.append("\n");
			   Document.append("</User>");//declare the root.
			   Document.append("\n");
			   Document.append("</MyProfile>");
			   System.out.println(Document.toString());
			   response.setContentType("text/xml");
			   response.setCharacterEncoding("UTF-8"); 
			   response.getWriter().write(Document.toString()); 
				
			}
		        		   
	
	private void  ProcessUsersRecordRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		ArrayList<UserDTO> result = userService.getUserDetails(userDTO);
		StringBuilder sb = new StringBuilder();
        sb.append("[");
	    for(int count=0;count<result.size();count++)
		{
		 UserDTO userDTO1=(UserDTO)result.get(count);//string str = "\"ugjhjnhjknkjk\"";
		 	sb.append("{");
			sb.append("\"Username\":"+"\""+userDTO1.getUsername().trim()+"\",");
			sb.append("\"Email\":"+"\""+userDTO1.getEmail()+"\",");
			sb.append("\"Mobileno\":"+userDTO1.getMobileno()+",");
			sb.append("\"Language_name\":"+"\""+userDTO1.getLanguage_name()+"\",");
		    sb.append("\"Timezone_id\":"+"\""+userDTO1.getName()+"\"");
			sb.append("}");
			sb.append(",");   
		}

	   sb.deleteCharAt(sb.lastIndexOf(","));    //You can check here if string builder has comma to avoid IndexOutofboundException
	   sb.append("]");
	   System.out.println(sb.toString());
	   response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");
	   response.getWriter().write(sb.toString()); 

		
	}
		
		  		 

	private void ProcessForgotPasswordRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(request.getParameter("username"));
		userDTO.setEmail(request.getParameter("email"));
		UserService userService=new UserService();
		boolean validate=userService.getForgotPasswordRequest(userDTO);
        if(validate) 
        {	
        request.setAttribute("messages",userDTO.getUsername());
    	request.getRequestDispatcher("/WEB-INF/jsp/resetpassword.jsp").forward(request, response);
		}
        else {
        	
        	request.setAttribute("message", "Data Not Found,click on Register !!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
        	
        }
	}
	
	private void processForgotPasswordPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Forgot.jsp").forward(request, response);
		
	}

	/*private void processRegister1RequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		Map<Integer,String> res1 = userService.getLanguageDropdownValues(userDTO);
		request.setAttribute("resu", res1);
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);

	}*/


	private void processRegisterRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		Map<Integer,String> timezonedropdownvalues = userService.getTimezoneDropdownValues(userDTO);
		Map<Integer,String> languagedropdownvalues = userService.getLanguageDropdownValues(userDTO);
		request.setAttribute("languagedropdownvalues", languagedropdownvalues);
		request.setAttribute("timezonedropdownvalues",timezonedropdownvalues);
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);

	}

	private void ProcessRegisterConfirmRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
   {
		
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		userDTO.setUsername(request.getParameter("username"));
		userDTO.setPassword(request.getParameter("password"));
		userDTO.setRegisterconfirmpassword(request.getParameter("registerconfirmpassword"));
		userDTO.setEmail(request.getParameter("email"));
		userDTO.setMobileno(request.getParameter("mobileno"));
		userDTO.setTimezone_id(request.getParameter("name"));
		userDTO.setLanguage_id(request.getParameter("language_id"));
		
		boolean status=userService.registerUserDetails(userDTO);
		if(status) {
			
			request.setAttribute("message","Username already exists,please register with a different username");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			userService.insertUserDetails(userDTO);
			request.setAttribute("successMessage", "Registration done,please login to continue!!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	}
			
		
	
	private void ProcessResetPasswordRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		userDTO.setUsername(request.getParameter("username"));
		userDTO.setConfirmPassword(request.getParameter("confirmPassword"));
		userService.updatePasswordRequest(userDTO);
		request.setAttribute("successMessage", "Password set,please login to continue!!!");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	private void ProcessEditUserProfileRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO=new UserDTO();
		UserService userService=new UserService();
		ArrayList<UserDTO> userslist = userService.getUserList(userDTO);
		StringBuilder sb = new StringBuilder();
        sb.append("[");
	    for(int count=0;count<userslist.size();count++)
		{
		 UserDTO userDTO1=(UserDTO)userslist.get(count);	
		//string str = "\"ugjhjnhjknkjk\"";
		 	sb.append("{");
			sb.append("\"Username\":"+"\""+userDTO1.getUsername().trim()+"\",");
			sb.append("\"Email\":"+"\""+userDTO1.getEmail()+"\",");
			sb.append("\"Mobileno\":"+userDTO1.getMobileno()+",");
		    sb.append("\"Lastlogin\":"+"\""+userDTO1.getLastlogin()+"\"");
			sb.append("}");
			sb.append(",");   
		}

	   sb.deleteCharAt(sb.lastIndexOf(","));    //You can check here if string builder has comma to avoid IndexOutofboundException
	   sb.append("]");
	   System.out.println(sb.toString());
	   response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");
	   response.getWriter().write(sb.toString()); 
		}

	private void ProcessLogoutRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		    HttpSession session = request.getSession(false);
	    if (session != null) {
		    	session.invalidate();
		    }
		response.sendRedirect("login.jsp");
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doPost(request, response);
	}

}

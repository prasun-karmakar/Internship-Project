package com.signify.internship.project.controller;
import java.io.IOException;
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
		else if (actionType.equals("Forgotpwd")) {
			processForgotPwdRequestParameter(request, response);
		}

		else if (actionType.equals("register1")) {
			processRegisterRequestParameter(request, response);
		}
		else if (actionType.equals("register2")) {
			ProcessRegisterConfirmRequestParameter(request, response);
		}
		else if (actionType.equals("forgot")) {
			ProcessForgotPasswordRequestParameter(request, response);
		}
		else if (actionType.equals("reset")) {
			ProcessResetPasswordRequestParameter(request, response);
		}
		else if(actionType.equals("list_UserRecords")) {
			ProcessUserRecordRequestParameter(request,response);
		}
		
		else if (actionType.equals("update")) {
			ProcessUpdateRequestParameter(request, response);
		}
		else if(actionType.equals("cancel")) {
			ProcessCancelRequestParameter(request,response);
		}
		else if (actionType.equals("logout")) {
		    ProcessLogoutRequestParameter(request, response);
		}
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
			session.setAttribute("value", userDTO.getZonedDateTime());
			userService.getTimezoneData(userDTO);
			session.setAttribute("username",username);
			request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);

			
		} else {
			request.setAttribute("message", "Data Not Found,click on Register !!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}

	}
	
	private void processForgotPwdRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Forgot.jsp").forward(request, response);
		
	}


	private void  ProcessUserRecordRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		ArrayList<UserDTO> result = userService.getUserDetails(userDTO);
		request.setAttribute("result", result);
		request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
		
		
	}
	

	private void ProcessCancelRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
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


	private void processRegisterRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		Map<Integer,String> results = userService.getTimezoneDropdownValues(userDTO);
		request.setAttribute("results", results);
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);

	}

	private void ProcessRegisterConfirmRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
   {
		
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		userDTO.setUsername(request.getParameter("username"));
		userDTO.setPassword(request.getParameter("password"));
		userDTO.setPassword1(request.getParameter("password1"));
		userDTO.setEmail(request.getParameter("email"));
		userDTO.setMobileno(request.getParameter("mobileno"));
		userDTO.setTimezone_id(request.getParameter("timezone_id"));
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
		userDTO.setPassword2(request.getParameter("password2"));
		userService.updatePasswordRequest(userDTO);
		request.setAttribute("successMessage", "Password set,please login to continue!!!");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	private void ProcessUpdateRequestParameter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		UserService userService=new UserService();
		userDTO.setUsername(request.getParameter("username"));
		userDTO.setPassword(request.getParameter("password"));
		userDTO.setEmail(request.getParameter("email"));
		userDTO.setMobileno(request.getParameter("mobileno"));
		userService.updateUserProfileRequest(userDTO);
		request.setAttribute("successMessage", "updation done,please login to continue!!!");
		request.getRequestDispatcher("login.jsp").forward(request, response);

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

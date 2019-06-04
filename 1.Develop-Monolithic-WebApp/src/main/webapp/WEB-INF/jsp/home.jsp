<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap"%>
<%@ page import= "java.util.Map"%>
<%@ page import="com.signify.internship.project.controller.UserServlet" %>
<%@ page import="com.signify.internship.project.dto.UserDTO" %>
<%@page import = "com.signify.internship.project.db.ResourceBundleManager" %>



<% Map<Integer,String> timezone_list=(HashMap<Integer,String>)request.getAttribute("timezone_list");%>


<%Map<Integer,String> language_list=(HashMap<Integer,String>)request.getAttribute("language_list");%>

<%ArrayList result=(ArrayList)request.getAttribute("result");%>


<%int languageId=(session.getAttribute("language_id")!=null)?Integer.valueOf((Integer)session.getAttribute("language_id")):1;%>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Home Page</title>
		<link rel="icon" href="Signify_2.png" type="image/png">
		<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
		<link href="style.css" rel="stylesheet" />
		
		<script src=scripts.js>
		
		</script>
		
	</head>

	<body>
	
		
		<div class="container-fluid"> <!-- Parent Container -->
			<div class=""> <!-- Parent Row container -->
				<div class="side_nav"> <!-- Column Div (Left Side Nav) -->
					<div class=""> <!-- Row within column div -->
						<div class="nav_image_div"> <!-- column within row div --> <!-- User Profile header on top of Nav menu links -->
							<div class="">								
								<img src="admin.jpg" alt="Profile Image" style="border-radius: 5%;">
								<h3><%=ResourceBundleManager.getString("MessageBundle","Hello",languageId)%> ${username}</h3>								
							</div>
						</div>
						<hr> <br>
						<div class="navigation"> <!-- column within row div --> <!-- Navigation Menu links -->
							<div class=""> <!-- Child Row div -->
								<ul class="">
									<li class="active"><a href="#section1" onclick="getRegisteredUserList()" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","registeredUsers",languageId)%></a></li> 
									<li class="active"><a href="#section1" onclick="getUserProfileDetail()" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","myProfile",languageId)%></a></li> 
									<li><a href="#section2" style="text-decoration:none" onclick="addNewUser()"><%=ResourceBundleManager.getString("MessageBundle","addNewUser",languageId)%></a></li> 
									<li class="active"><a href="#section3" onclick="getUserList()" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","editUserProfile",languageId)%></a></li> 
									
									<li class ="active"><a href="#section3" onclick="removeUser()" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","removeUser",languageId)%></a></li> 
									
									<li class="active"><a href="#section3" onclick="changePassword()" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","changePassword",languageId)%></a></li>
									<li><a href="loginRegister?actionType=logout" style="text-decoration:none"><%=ResourceBundleManager.getString("MessageBundle","logout",languageId)%></a></li>
								</ul> <br>
							</div>
						</div>		
					</div>	
				</div>
			
				<div class="page"> <!-- Column Div (Right Side Nav) --> 
					<div class="page_header"> <!-- Row within column div --> <!-- Right side top container -->
						<div class=""> <!-- column within row div -->
							<div class="nav_image_div">
								<img src="signify_header.jpg" alt="signify_header.png" class="">
								<div class="topleft"><%=ResourceBundleManager.getString("MessageBundle","welcome",languageId)%></div>
								<div class="topright"><%=ResourceBundleManager.getString("MessageBundle","lastLoginTime",languageId)%>:${value} </div>
							</div>
						</div>
					</div>
					
					<div class="page_body"> <!-- Row within column div --> <!-- Right side body container -->
						<div id="signup_container">  
	                        <h3 class="formheading">Edit Users Detais</h3>  
		                        <table> 
		 						<tr><td>Username:</td><td><input type="username" name="username" id="t1"/></td></tr>  
								<tr><td>Email:</td><td><input type="email" name="email" id="t2"/></td></tr>  
								<tr><td>Mobileno:</td><td><input type="mobileno" name="mobileno" id="t3"/></td></tr>
								  
								<tr><td>Timezone_id:</td><td><div style="height: 25px;">
								<select id="timezone_id" name="name" style="width:90%" >
								<option value="none">Select</option> 
									<%if(timezone_list!=null){
	         							for(Map.Entry<Integer, String> entry:timezone_list.entrySet()) {
		         							Integer timezone_id=entry.getKey();
		          							String name=entry.getValue();%>
	         									<option value="<%=timezone_id %>"><%=name%></option>
	         							<%}%>
	         						<%}%> 
	         					</select></div></td></tr>  
	         					
								<tr><td>Language_id:</td><td><div style="height:25px;">
									<select id="language_id" name="language_id" style="width:90%" >
									<option value="none">Select</option> 
									<%if(language_list!=null){
         							for(Map.Entry<Integer, String> entry: language_list.entrySet()) {
         								Integer language_id=entry.getKey();
         								String language_name=entry.getValue();%>
        									<option value="<%=language_id %>"><%=language_name%></option>
         							<%}%> <%}%>  
         						</select></div>  </td></tr>  <br/> <br/><br/>
   
								<tr><td colspan="2" style="text-align:center" ><button onclick="submission_form()">Submit</button> &nbsp;| &nbsp;<input type="button" value="Cancel" onclick="getUserList()"> </td></tr>  
							</table>  
 						</div>
 						
						<div id="usersUpdate">
						<p>Users Detail updated</p>
						</div>
						
						<div id="resetPassword">  
	                        <h3 class="formheading">Reset Password</h3>  
		                        <table> 
		                        <input id="t5" name="username" type="hidden">
		 						<tr><td>New Password:</td><td><input type="password" name="new password" id="t6"/></td></tr>  
								<tr><td>Confirm Password:</td><td><input type="password" name="confirm password" id="t7"/></td></tr>  
								  <br/> <br/><br/>
   
								<tr><td colspan="2" style="text-align:center" ><button onclick="submitchangepasswordform()">Submit</button> &nbsp;| &nbsp;<input type="button" value="Cancel" onclick="changePassword()"> </td></tr>  
							</table>  
 						</div>
 	
						 <div id="registeredUsers">  
	                        <h3 class="formheading">Registered Users</h3> 
	                       <table id="sampleDiv"> </table>
						</div>
						
						<div id="userProfileDetail">  
						<h3 class="formheading">MyProfile</h3> 
	                       <table id="ajaxFunc"> </table>
						</div>
					
					<div id="getUserListForUpdate">  
						<h3 class="formheading">User Update Links</h3> 
	   						<table id="jsonFunc"></table>
	   				 </div>
	   				 
	   				 <div id="deleteUser">  
						<h3 class="formheading">Delete User</h3> 
	   						<table id="removeUser"></table>
	   				 </div>
	   				 
	   				 
	   				<div id="resetUserPassword">  
						<h3 class="formheading">Reset Password</h3> 
	   						<table id="changePassword"></table>
	   				 </div>
					
					</div>
		
		
		
		</div>
		
		</div>
	
				
	

	</body>
</html>


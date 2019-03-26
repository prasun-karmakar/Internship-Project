<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
    

    <%@page import = "com.signify.internship.project.controller.UserServlet" %>
    <%@page import = "com.signify.internship.project.dto.UserDTO" %>
    <%ArrayList result=(ArrayList)request.getAttribute("result"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Home Page</title>
		<link rel="icon" href="Signify_2.png" type="image/png">
		<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
		<script>
	
		
		function pageLoad()
{
			var result = <%=(ArrayList)request.getAttribute("result")%>;
			if(null!=result)
			{
				sampleDiv.style.display = 'block';
			   
			}	
			else
				{
				sampleDiv.style.display = 'none';
				}
}
</script>
		<style>
		
		table {
    margin: 0 auto; /* or margin: 0 auto 0 auto */
  }

		html { 
			background: url(home_bg.bmp) no-repeat center fixed; 
			background-size: cover;
		}

		body {
			font: 17px Montserrat, sans-serif;
			line-height: 1;
			color: #f5f6f7;
			
		}
		ul li{
               padding:20px;
               border-bottom:2pxsolid grey;}

        ul li:hover{
               background:#bdc3c7;
               color:white;}
		
		/* Remove bullets */
		ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
		}
		
		.container-fluid {
			position: relative;
		}
		
		.side_nav {
			width: 18%;
			background-color:hsla(156, 100%, 50%, 0.5);
			height: 915px;
		}
		
		.side_nav_top {
		
		}
		
		.side_nav_bottom {
		
		}
		
		.page {
			width: 81%;
			position: absolute;
			right: 8px;
			top: 0px;
			height: 150px;
			
		}
		
		.page_header {
			position: absolute;
			width: 100%;
			height: 150px;
		}
		
		.page_body {
			position: absolute;
			width: 100%;
			right: 0px;
			top: 235px;
			background-color:hsla(156, 100%, 50%, 0.5);
			height: 680px;
		}
		 
		.nav_image_div {
			width: 100%;
			background-size: cover;
			height: 280px;
		}
		.navigation{
		font: 17px Montserrat, sans-serif;
		
		}
		#sampleDiv{
		display:'none';
	     width: 100%;
         padding: 50px 0;
         text-align: center;
         margin-top: 20px;
		
		}

		img {	
			width: 100%;
			height: 230px;
		}
		
		.topright {
		  position: absolute;
		  top: 8px;
		  right: 16px;
		  font-size: 20px;
		}
		
		.topleft {
		  position: absolute;
		  top: 8px;
		  left: 16px;
		  font-size: 30px;
		}
		.table .thead-light th {
 
  color: #401500;
 
  background-color: #FFDDCC;
 
  border-color: #792700;
 
}
		
		
		</style>
	</head>

	<body onload="pageLoad()">
		
		<div class="container-fluid"> <!-- Parent Container -->
			<div class=""> <!-- Parent Row container -->
				<div class="side_nav"> <!-- Column Div (Left Side Nav) -->
					<div class=""> <!-- Row within column div -->
						<div class="nav_image_div"> <!-- column within row div --> <!-- User Profile header on top of Nav menu links -->
							<div class="">								
								<img src="admin.jpg" alt="Profile Image" style="border-radius: 5%;">
								<h3>Hello ${username}</h3>								
							</div>
						</div>
						<hr> <br>
						<div class="navigation"> <!-- column within row div --> <!-- Navigation Menu links -->
							<div class=""> <!-- Child Row div -->
								<ul class="">
									
									<li class="active"><a href="loginRegister?actionType=list_UserRecords" style="text-decoration:none">Registered Users</a></li> 
									<li class="active"><a href="#section1" style="text-decoration:none">MyProfile</a></li> 
									<li><a href="#section2" style="text-decoration:none">Add New User</a></li> 
									<li><a href="#section3" style="text-decoration:none">Edit User Profile</a></li>
									<li><a href="#section3" style="text-decoration:none">Remove User</a></li> 
									<li><a href="changepassword.jsp" style="text-decoration:none">Change Password</a></li>
									<li><a href="loginRegister?actionType=logout" style="text-decoration:none">Logout</a></li>
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
								<div class="topleft"> Welcome</div>
								<div class="topright">Last Login Time:${value} </div>
							</div>
						</div>
					</div>
					
					<div class="page_body"> <!-- Row within column div --> <!-- Right side body container -->
					
						<div id="sampleDiv" >
							
								<input id="username" name="username" type="hidden" value="${messages}">
								<table class="table table-striped" width="70%">
								<thead class="thead-light">
								<tr>
								<th>Username</th><br />
								<th>Email</th><br />
								<th>Mobileno</th><br />
								<th>Timezone_id</th>
								</tr>
								</thead>
								<tbody>
					
									<tr>
									<%if(null!=result) {%>
									<%for(int count=0;count<result.size();count++){ %>
										<tr>
											<%UserDTO userDTO=(UserDTO)result.get(count); %>
											<td><%=userDTO.getUsername() %></td>
											<td><%=userDTO.getEmail() %></td>
											<td><%=userDTO.getMobileno() %></td>
											<td><%=userDTO.getTimezone_id() %></td>
											</td>
										</tr>
									</tr>
								    <%}%>
								    <%} %>
				    			</tbody>
				    		</table>
					</div>
				</div>
				
			</div>
		</div>
		</div>

	</body>
</html>
